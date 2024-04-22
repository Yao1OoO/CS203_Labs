import java.util.Arrays;
import java.util.Random;

public class B {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        quickSort(arr,0,n-1);
        long x;
        if (n%2 ==0){
            x = (long)arr[n/2]+(long) arr[n/2-1];
        }else {
            x = (long) arr[(n-1)/2]*2;
        }
        out.print(x);
        out.close();
    }

    public static void quickSort(int[] arr, int l, int r) {
        Random rand = new Random();
        if (l < r) {
            swap(arr,l+ rand.nextInt(r - l + 1), r);
            int[] p =partition(arr,l,r);
            quickSort(arr,l,p[0]-1);
            quickSort(arr,p[1]+1,r);
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
