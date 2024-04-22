import java.util.Arrays;

public class F {
    public static void main(String[] args) {
        QReader in = new QReader();
        char[] key = new char[26];
        for (int i = 0; i < 26; i++) {
            key[i] = in.next().charAt(0);
        }
        char[] str = in.next().toCharArray();
        int len = str.length;
        char[] strAdd = new char[len * 2 + 1];
        for (int i = 0; i < len; i++) {
            strAdd[i] = str[i];
        }
        strAdd[len] = '#';
        for (int i = 0; i < len; i++) {
            strAdd[i + len + 1] = key[str[i] - 97];
        }
        //System.out.println(Arrays.toString(strAdd));
        int[] next = new int[strAdd.length + 1];
        int j = 0;
        for (int i = 2; i < strAdd.length + 1; i++) {
            while (j != 0 && (strAdd[i - 1] != strAdd[j] || j + 1 > len / 2)) {
                j = next[j];
            }
            if (strAdd[i - 1] == strAdd[j]) {
                j++;
            }
            next[i] = j;
        }

//        while (j != 0 &&( strAdd[strAdd.length -1] != strAdd[j] || j + 1 > len/2)) {
//            j = next[j];
//        }
//        if (strAdd[strAdd.length -1] == strAdd[j]){
//            j++;
//        }
//        next[strAdd.length] = j;
        System.out.println(Arrays.toString(next));
        System.out.println(len - next[strAdd.length]);
    }
}
