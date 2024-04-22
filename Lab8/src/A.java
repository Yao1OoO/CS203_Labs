//public class A {
//    public static void main(String[] args) {
//        QReader in = new QReader();
//        QWriter out = new QWriter();
//        int t = in.nextInt();
//        for (int i = 0; i < t; i++) {
//            int n = in.nextInt();
//            int m = in.nextInt();
//            int[][] matrix = new int[n+1][n+1];
//            for (int j = 0; j < m; j++) {
//                int u = in.nextInt();
//                int v = in.nextInt();
//                matrix[u][v] = 1;
//            }
//            for (int j = 1; j <=n; j++) {
//                for (int k = 1; k <= n; k++) {
//                    out.print(matrix[j][k] + " ");
//                }
//                out.println("");
//            }
//        }
//        out.close();
//    }
//}
