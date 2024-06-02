public class B {

    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int t = in.nextInt();
        long[] sum =  new long[1000001];
        sum[0] = 0;
        for (int i = 1; i < 1000001; i++) {
            sum[i] = sum[i-1] + (long) i*(i+1)/2;
        }
        for (int i = 0; i < t; i++) {
            int x = in.nextInt();
            out.println(sum[x]);
        }
        out.close();
    }
}
