public class C {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        String s = in.next();
        int[][] fsp = new int[s.length()][26];
        char[] str = s.toCharArray();
        int k = 0;
        fsp[0][str[0] - 97] = 1;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                if (str[i] == j+97){
                    fsp[i][j] = i + 1;
                }else {
                    fsp[i][j] = fsp[k][j];
                }
            }
            k = fsp[k][str[i] -97];
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                out.print(fsp[i][j]+" ");
            }
            out.println("");
        }
        out.close();
    }
}
