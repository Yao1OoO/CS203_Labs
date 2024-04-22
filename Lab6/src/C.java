public class C {
    public static QWriter out = new QWriter();
    public static void main(String[] args) {
        QReader in = new QReader();
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] preO = new int[n];
            int[] inO = new int[n];
            for (int j = 0; j < n; j++) {
                preO[j] = in.nextInt();
            }
            for (int j = 0; j < n; j++) {
                inO[j] = in.nextInt();
            }
            re(preO,inO,0,0,n);
            out.println("");
        }
        out.close();
    }

    public static void re(int[] pre, int[] in, int i, int j, int len) {
        if (len == 0) {
            return;
        }
        int data = pre[i];
        int index = 0;
        for (int k = 0; k < len; k++) {
            if (in[j + k] == data) {
                index = j + k;
                break;
            }
        }
        re(pre, in, i + 1, j, index - j);
        re(pre, in, i + index - j+1, index + 1, len - (index - j) - 1);
        out.print(data+" ");
    }
}
