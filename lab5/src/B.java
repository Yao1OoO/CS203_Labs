public class B {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        String str = "1"+in.next();
        int[] next = new int[str.length()];
        char[] p = str.toCharArray();
        next[1] = 0;
        int j = 0;
        for (int i = 2; i < next.length; i++) {
            while ( j > 0 && p[i] != p[j + 1]){
                j = next[j];
            }
            if (p[i] == p[j+1]){
                j++;
            }
            next[i] = j;
        }
        for (int i = 1; i < next.length; i++) {
            out.println(next[i]);
        }
        out.close();
    }
}
