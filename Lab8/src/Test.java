import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str= in.next();
        String[] strs = str.split("\\\\");
        System.out.println(Arrays.toString(strs));
        str = strs[0];
        for (int i = 1; i < strs.length; i++) {
         str = str + "\\\\" + strs[i];
        }
        System.out.println(str);
    }
}