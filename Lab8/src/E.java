
public class E {

    public static long maxResult = 0;
    public static int n;
    public static int m;
    public static int[][] d = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    public static void main(String[] args) {
        QReader in = new QReader();
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            n = in.nextInt();
            m = in.nextInt();
            long[][] group = new long[n + 2][m + 2];
            boolean[][] valid = new boolean[n + 2][m + 2];
            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < m + 1; k++) {
                    group[j][k] = in.nextLong();
                }
            }
            put(0,0,group,valid);
            System.out.println(maxResult);
            maxResult = 0;
        }
    }

    public static void put(int num, long result, long[][] group, boolean[][] valid) {
        if (num == n * m) {
            maxResult = Math.max(maxResult, result);
            return;
        }
        int row = num / m + 1;
        int col = num % m + 1;
        boolean flag = true;
        for (int i = 0; i < 8; i++) {
            if (valid[row+d[i][0]][col + d[i][1]]){
                flag = false;
                break;
            }
        }
//        System.out.println(flag);
        if (flag) {
            valid[row][col] = true;
            result += group[row][col];
            put(num + 1, result, group, valid);
            result -= group[row][col];
            valid[row][col] = false;
        }
        put(num + 1, result, group, valid);
    }
}
