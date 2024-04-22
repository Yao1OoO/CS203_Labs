import java.util.Arrays;

public class E {
    private static long[] pow;
    private static long[] hash1;
    private static long[] hash2;
    private static boolean flag = false;

    public static void main(String[] args) {
        QReader in = new QReader();
        char[] str1 = in.next().toCharArray();
        char[] str2 = in.next().toCharArray();

        int n = str1.length;
        int m = str2.length;

        hash1 = new long[n + 1];
        hash2 = new long[m + 1];
        hash1[0] = 0;
        hash2[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            hash1[i] = 139 * hash1[i - 1] + str1[i - 1];
        }
        for (int i = 1; i < m + 1; i++) {
            hash2[i] = 139 * hash2[i - 1] + str2[i - 1];
        }

        pow = n > m ? new long[n + 1] : new long[m + 1];
        pow[0] = 1;
        for (int i = 1; i < pow.length; i++) {
            pow[i] = pow[i - 1] * 139;
        }
        int l = 0;
        int r = Math.min(n, m);
        while (l != r) {
            int mid = (r + l) / 2;
            if (haveSameStr(mid + 1)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        System.out.println(l);
    }

    public static long getHash(long[] hash, int l, int r) {
        if (r >= l){
            return hash[r] - hash[l] * pow[r - l];
        }
        return 0;
    }

    public static boolean haveSameStr(int t) {
//        if (t >= hash1.length || t >= hash2.length){
//            return false;
//        }
        long[] hash1t = new long[hash1.length - t + 1];
        long hash2t;
        for (int i = 0; i <= hash1.length - t - 1; i++) {
            hash1t[i] = getHash(hash1, i, i + t);
        }
        sort(hash1t, 0, hash1t.length - 1);
        for (int i = 0; i <= hash2.length - t - 1; i++) {
            flag = false;
            hash2t = getHash(hash2, i, i + t);
            if (binarySearch(hash1t, hash2t, 0, hash1t.length - 1)) {
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearch(long[] arr, long x, int l, int r) {

        if (l > r) return false;
        int mid = (l + r) / 2;
        if (arr[mid] == x) {
            flag = true;
            return true;
        }

        if (arr[mid] > x) {
            binarySearch(arr, x, l, mid - 1);
        } else if (arr[mid] < x) {
            binarySearch(arr, x, mid + 1, r);
        }

        if (flag) return true;
        return false;
    }

    public static void sort(long[] arr, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            sort(arr, l, mid);
            sort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    public static void merge(long[] arr, int l, int m, int r) {
        int i = l;
        int j = m + 1;
        long[] temp = new long[r - l + 1];
        int k = 0;
        while (i <= m && j <= r) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i <= m) {
            temp[k] = arr[i];
            i++;
            k++;
        }
        while (j <= r) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        for (int n = 0; n < r - l + 1; n++) {
            arr[n + l] = temp[n];
        }
    }

}


