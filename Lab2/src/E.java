import java.util.Arrays;
import java.util.Random;

public class E {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        quickSort(arr, 0, arr.length - 1);
        int t = arr.length / 3;
        int m = arr.length % 3;
        int k = arr[t];
        out.println(k);
//        System.out.println(Arrays.toString(arr));
        if (arr[1] == arr[t]) {
            for (int i = 0; i < arr.length; i++) {
                out.print(arr[i] + " ");
            }
            out.close();
            return;
        }
        label:
        for (int i = 0; i < t; i++) {
            if (i < t - 1 && arr[i + 1] == k) {
                for (int j = i; j < t; j++) {
                    out.print(arr[j] + " ");
                }
                for (int j = t + i * 2; j < arr.length-m; j++) {
                    out.print(arr[j] + " ");
                }
                break label;
            } else {
                out.print(arr[i] + " " + arr[t + i * 2] + " " + arr[t + i * 2 + 1] + " ");

            }
        }
        if (m == 1) {
            out.print(arr[n - 1]);
        } else if (m == 2) {
            out.print(arr[n - 2] + " " + arr[n - 1]);
        }
        out.close();
    }

    public static void quickSort(int[] arr, int l, int r) {
        Random rand = new Random();
        if (l < r) {
            swap(arr, l + rand.nextInt(r - l + 1), r);
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }

    }

    public static int[] partition(int[] arr, int l, int r) {
        int x = arr[r];
        int i = l;
        int less = l - 1;
        int more = r;
        while (i < more) {
            if (arr[i] < x) {
                swap(arr, i, less + 1);
                i++;
                less++;
            } else if (arr[i] == x) {
                i++;
            } else {
                swap(arr, i, more - 1);
                more--;
            }
        }
        swap(arr, r, more);
        return new int[]{less + 1, more};
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
