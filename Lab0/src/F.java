import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IllegalFormatCodePointException;
import java.util.Scanner;

public class F {

    static boolean flag = false;
    static String[][] str = new String[5][3];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            flag = false;
            String str1 = in.next();
            HashMap<String, Integer> mj1 = new HashMap<>();
            for (int j = 0; j < 14; j++) {
                String substr = str1.substring(2 * j, 2 * j + 2);
                if (mj1.containsKey(substr)) {
                    mj1.put(substr, mj1.get(substr) + 1);
                } else mj1.put(substr, 1);
            }
            str = new String[5][3];
            if (traceBack(mj1, 0)) {
                System.out.println("Blessing of Heaven");
            } else System.out.println("Bad luck");
            //test
//            for (String mj2: mj1.keySet()) {
//                System.out.print(mj2+" "+mj1.get(mj2)+"||");
//            }
//            System.out.println();
            // test System.out.println(Arrays.toString(mj));
        }
    }

    static boolean traceBack(HashMap<String, Integer> mj, int index) {
        // System.out.println(index);
        if (index == 14) {
            flag = true;
            //System.out.println("====" + flag + "=====");
            return true;
        }
        for (String mj1 : mj.keySet()) {
            if (mj.get(mj1) > 0 && isValid(str, mj1, index)) {
                mj.put(mj1, mj.get(mj1) - 1);
                //  System.out.println(mj1 + "  " + mj.get(mj1) + "   " + index);
                str[index / 3][index - index / 3 * 3] = mj1;
                traceBack(mj, index + 1);
                if (flag) return true;
                //System.out.println(flag);
                str[index / 3][index - index / 3 * 3] = null;
                mj.put(mj1, mj.get(mj1) + 1);
                // System.out.println(mj1 + "  " + mj.get(mj1) + "   " + index);
            }
        }
        return false;
    }

    static boolean isValid(String[][] mj, String oneMj, int index1) {
        if (index1 < 12) {
            if (mj[index1 / 3][0] == null) {
                return true;
            } else if (mj[index1 / 3][1] == null) {
                if (mj[index1 / 3][0].charAt(1) == 'z') {
                    if (oneMj.charAt(1) == mj[index1 / 3][0].charAt(1)
                            && (oneMj.charAt(0) == mj[index1 / 3][0].charAt(0))) {
                        return true;
                    }
                } else {
                    if (oneMj.charAt(1) == mj[index1 / 3][0].charAt(1)
                            && (oneMj.charAt(0) == mj[index1 / 3][0].charAt(0)
                            || oneMj.charAt(0) == mj[index1 / 3][0].charAt(0) + 1
                            || oneMj.charAt(0) == mj[index1 / 3][0].charAt(0) - 1)) {
                        return true;
                    } else return false;
                }
            } else if (mj[index1 / 3][2] == null) {
                if (mj[index1 / 3][0].charAt(1) == 'z') {
                    if (oneMj.charAt(1) == mj[index1 / 3][0].charAt(1)
                            && (oneMj.charAt(0) == mj[index1 / 3][0].charAt(0))) {
                        return true;
                    }
                } else {
                    if (mj[index1 / 3][1].charAt(0) == mj[index1 / 3][0].charAt(0)) {
                        if (oneMj.charAt(0) == mj[index1 / 3][0].charAt(0) && mj[index1 / 3][0].charAt(1) == oneMj.charAt(1)) {
                            return true;
                        }
                    } else {
                        if ((oneMj.charAt(0) + mj[index1 / 3][0].charAt(0) == mj[index1 / 3][1].charAt(0) * 2
                                || oneMj.charAt(0) + mj[index1 / 3][1].charAt(0) == mj[index1 / 3][0].charAt(0) * 2)
                                && mj[index1 / 3][0].charAt(1) == oneMj.charAt(1)) {
                            return true;
                        }
                    }
                }

            }
        } else {
            if (mj[4][0] == null) {
                return true;
            } else if (mj[4][0].charAt(0) == oneMj.charAt(0) && mj[4][0].charAt(1) == oneMj.charAt(1)) return true;
        }
        return false;
    }
}
