//import java.util.ArrayList;
//
//public class B {
//    public static void main(String[] args) {
//        QReader in = new QReader();
//        QWriter out = new QWriter();
//        int t = in.nextInt();
//        for (int i = 0; i < t; i++) {
//            int n = in.nextInt();
//            int m = in.nextInt();
//            int s = in.nextInt();
//            Node[] nodes= new Node[n+1];
//            int[] result = new int[n+1];
//            for (int j = 1; j < n+1; j++) {
//                nodes[j] = new Node(j);
//            }
//            for (int j = 0; j < m; j++) {
//                int u = in.nextInt();
//                int v = in.nextInt();
//                nodes[u].arr.add(nodes[v]);
//                nodes[v].arr.add(nodes[u]);
//            }
//
//            Node[] queue = new Node[n+10];
//            int first = 0;
//            int last = 1;
//            queue[0] = nodes[s];
//            nodes[s].isVisited = true;
//            result[s] = 0;
//
//            while (first !=last){
//                for (Node node: queue[first].arr) {
//                    if (!node.isVisited){
//                        node.isVisited = true;
//                        result[node.data] = result[queue[first].data] +1;
//                        queue[last++] = node;
//                    }
//                }
//                first++;
//            }
//            for (int j = 1; j < result.length; j++) {
//                if (j != s && result[j] == 0){
//                    out.print("-1 ");
//                }else {
//                    out.print(result[j] + " ");
//                }
//            }
//            out.println("");
//        }
//        out.close();
//    }
//}
//
