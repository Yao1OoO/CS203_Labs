public class D {
    static long sum;

    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        int s = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        label:
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (arr[i] > s / 3) {
                    break label;
                }
                if ((arr[i] + arr[j]) > s * 2 / 3) {
                    break;
                }
                int x = s - arr[i] - arr[j];
                //System.out.println("i:" + arr[i] + "   j:" + arr[j]);
                int min = searchMin(arr, x - 1, j + 1, n - 1);
                int max = searchMax(arr, x + 1, j + 1, n - 1);
                //System.out.println(min + "  " + max + "  " + sum);
                //System.out.println("=======================");
                if (max >= min && max != -1 && min != -1) {
                    sum += (max - min + 1);
                }
            }
        }
        out.println(sum);
        out.close();
    }

    static int searchMin(int[] arr, int x, int l, int r) {
        if (l > r) return -1;
        if (x < arr[l]) return l;
        int mid = l + (r - l) / 2;
        if (arr[mid] > x) {
            if (mid == l || arr[mid - 1] <= x) {
                return mid;
            }
            return searchMin(arr, x, l, mid - 1);
        } else {
            return searchMin(arr, x, mid + 1, r);
        }
    }

    static int searchMax(int[] arr, int y, int l, int r) {
        if (l > r) return -1;
        if (y > arr[arr.length - 1]) return arr.length - 1;
        int mid = l + (r - l) / 2;
        if (arr[mid] < y) {
            if (mid == arr.length - 1 || arr[mid + 1] >= y) {
                return mid;
            }
            return searchMax(arr, y, mid + 1, r);

        } else {
            return searchMax(arr, y, l, mid - 1);
        }
    }

    public static int binarySearchLeBd(int[] arr, int key, int lo, int hi) {
        int le = lo;
        int ri = hi;
        while (le < ri) {
            int mid = (le + ri) >> 1;
            if (arr[mid] == key) {
                ri = mid;
            } else if (arr[mid] < key) {
                le = mid + 1;
            } else {
                ri = mid;
            }
        }
        return le;
    }

    // 查找范围[lo, hi)
    // 若找到了key，返回key的下标最大的index
    // 若没找到，返回小于key的最大index
    public static int binarySearchRiBd(int[] arr, int key, int lo, int hi) {
        int le = lo;
        int ri = hi;
        while (le < ri) {
            int mid = (le + ri) >> 1;
            if (arr[mid] == key) {
                le = mid + 1;
            } else if (arr[mid] < key) {
                le = mid + 1;
            } else if (arr[mid] > key) {
                ri = mid;
            }
        }
        return le - 1;
    }
}
