import java.util.Arrays;

public class C {

    public static long x;

    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            x = 0;
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = in.nextInt();
            }
            process(arr, 0, arr.length - 1);
            out.println(x);
        }
        out.close();
    }

    public static void process(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = (l + r) / 2;
        process(arr, l, mid);
        process(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int i = l;
        int j = m + 1;
        int[] temp = new int[r - l + 1];
        int k = 0;

        while (i <= m && j <= r) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
                x += m - i + 1;
                //System.out.println("X:" + x);
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
        //System.out.println(Arrays.toString(temp));
        for (int n = 0; n < r - l + 1; n++) {
            arr[n + l] = temp[n];
        }
    }
}
