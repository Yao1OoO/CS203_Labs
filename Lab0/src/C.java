import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int i = 0; i < t; i++) {
            String str[] = new String[13];
            for (int j = 0; j < 13; j++) {
                str[j] = input.next();
            }
            Arrays.sort(str,new StrComparator());
            for (String string:
                 str) {
                System.out.print(string+" ");
            }
            System.out.println();
        }
    }
}

class StrComparator implements Comparator<String> {

    public int compare(String o1, String o2) {
        return value(o2) - value( o1);
    }

    public int value(String str) {
        if (str.charAt(0) == 'E') {
            return 6;
        } else if (str.charAt(0) == 'S') {
            return 5;
        } else if (str.charAt(0) == 'W'&& str.length() == 1) {
            return 4;
        } else if (str.charAt(0) == 'N') {
            return 3;
        } else if (str.charAt(0) == 'B') {
            return 2;
        } else if (str.charAt(0) == 'F') {
            return 1;
        } else if (str.charAt(0) == 'Z') {
            return  0 ;
        } else if (str.charAt(0) == 'Y') {
            return 20-Character.getNumericValue(str.charAt(1));
        }else if (str.charAt(0) == 'T') {
            return 30-Character.getNumericValue(str.charAt(1));
        }else if (str.charAt(0) == 'W') {
            return 40-Character.getNumericValue(str.charAt(1));
        }
        return 0;
    }
}
