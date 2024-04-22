
public class A {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        int[] arr = new int[n+1];
        for (int i = 0; i < n-1; i++) {
            arr[in.nextInt()]++;
            arr[in.nextInt()]++;
        }
        for (int i = 1; i <= n; i++) {
            if (arr[i] == 1){
                out.print(i+" ");
            }
        }
        out.close();
    }
}

