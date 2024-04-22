import java.util.Arrays;

public class A {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        String[] str = new String[in.nextInt()];
        int[] sum =new int[1001];
        sum[0] = 0;
        for (int i = 1; i < 1001; i++) {
            sum[i] = i + sum[i-1];
        }
        for (int i = 0; i < str.length; i++) {
            str[i] = in.next();
            out.println(sum[str[i].length()]);
        }
        out.close();
    }
}
