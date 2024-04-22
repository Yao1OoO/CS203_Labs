public class A {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] arr = new int[n + m];
            int[] arr1 = new int[n];
            int[] arr2 = new int[m];
            int a = 0, b = 0, c = 0;
            for (int j = 0; j < n; j++) {
                arr1[j] = in.nextInt();
            }
            for (int j = 0; j < m; j++) {
                arr2[j] = in.nextInt();
            }
            while (a < n && b < m) {
                if (arr1[a] <= arr2[b]) {
                    arr[c] = arr1[a];
                    a++;
                } else {
                    arr[c] = arr2[b];
                    b++;
                }
                c++;
            }
            while (a < n){
                arr[c] = arr1[a];
                c++;
                a++;
            }
            while (b < m){
                arr[c] = arr2[b];
                c++;
                b++;
            }
            for (int j = 0; j < n+m; j++) {
                out.print(arr[j]+" ");
            }
            out.println("");
        }
        out.close();
    }
}
