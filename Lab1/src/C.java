public class C {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        int[] arr = new int[n];
        int q = in.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        for (int i = 0; i < q; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int min = searchMin(arr, x, 0, arr.length - 1);
            int max = searchMax(arr, y, 0, arr.length - 1);
//            System.out.println(min);
//            System.out.println(max);
//            System.out.println();
            if (min == -1 ||max == -1||max-min+1 <= 0){
                out.println("NO");
            }else {
                out.print("YES ");
                out.println(max-min+1);
            }
        }
        out.close();
    }

    static int searchMin(int[] arr, int x, int l, int r) {
        if (x< arr[0]) return 0;
        if (l > r) return -1;
        int mid = l + (r - l) / 2;
        if (arr[mid] > x) {
            if (mid == 0 || arr[mid - 1] <= x) {
                return mid;
            }
            return searchMin(arr, x, l, mid - 1);
        } else {
            return searchMin(arr, x, mid+1, r);
        }
    }

    static int searchMax(int[] arr, int y, int l, int r) {
        if (y > arr[arr.length-1]) return arr.length-1;
        if (l > r) return -1;
        int mid = l + (r - l) / 2;
        if (arr[mid] < y) {
            if (mid == arr.length-1 || arr[mid + 1] >= y) {
                return mid;
            }
            return searchMax(arr, y, mid+1, r);

        } else {
            return searchMax(arr, y, l, mid - 1);
        }
    }
}

