import java.util.HashMap;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
//        int arr[][] = new int[3][4];
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.print("1");
//
//            }
//            System.out.println();
//        }
//        Scanner in = new Scanner(System.in);
//        String str1 = in.next(),str2 = in.next();
//        if (str1.charAt(0)+2 ==str2.charAt(0)){
//            System.out.println("111");
//        }else System.out.println("222");
/*
        String str[] = new String[3];
        String mj = "4w";
        System.out.println(isValid(str,mj));
        String text = "Hello World Hello Java Hello Java";
        HashMap<String, Integer> wordCountMap = new HashMap<>();

        // 分割文本为单词数组
        String[] words = text.split(" ");

        // 遍历单词数组
        for (String word : words) {
            // 如果单词已经存在于HashMap中，更新其数量
            if (wordCountMap.containsKey(word)) {
                wordCountMap.put(word, wordCountMap.get(word) + 1);
            }
            // 否则将新单词添加到HashMap中
            else {
                wordCountMap.put(word, 1);
            }
        }

        // 输出结果
        for (String word : wordCountMap.keySet()) {
            System.out.println("Word: " + word + ", Frequency: " + wordCountMap.get(word));
        }  */

        int a = 13;
        System.out.println(a/3);
        System.out.println(a/3*3);
    }

    static boolean isValid(String[] mj, String oneMj) {
        if (mj[0] == null) {
            return true;
        } else if (mj[1] == null) {
            if (oneMj.charAt(1) == mj[0].charAt(1) && (oneMj.charAt(0) == mj[0].charAt(0)
                    || oneMj.charAt(0) == mj[0].charAt(0) + 1
                    || oneMj.charAt(0) == mj[0].charAt(0) - 1)) {
                return true;
            } else return false;
        } else if (mj[2] == null) {
            if (mj[1].charAt(0) == mj[0].charAt(0)) {
                if (oneMj.charAt(0) == mj[0].charAt(0) && mj[0].charAt(1) == oneMj.charAt(1)) {
                    return true;
                }
            } else {
                if ((oneMj.charAt(0) + mj[0].charAt(0) == mj[1].charAt(0) * 2
                        ||oneMj.charAt(0) + mj[1].charAt(0) == mj[0].charAt(0) * 2)
                        && mj[0].charAt(1) == oneMj.charAt(1)) {
                    return true;}
            }
        }
        return false;
    }
}
