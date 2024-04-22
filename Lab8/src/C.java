//import java.util.ArrayList;
//public class C {
//    public static void main(String[] args) {
//        QReader in = new QReader();
//        QWriter out = new QWriter();
//        int t = in.nextInt();
//        for (int i = 0; i < t; i++) {
//            int n = in.nextInt();
//            int m = in.nextInt();
//            Node[] nodes = new Node[n + 1];
//            boolean[] result = new boolean[n + 1];
//            int num = 0;
//            for (int j = 1; j < n + 1; j++) {
//                nodes[j] = new Node(j);
//            }
//            for (int j = 0; j < m; j++) {
//                int u = in.nextInt();
//                int v = in.nextInt();
//                nodes[u].arr.add(nodes[v]);
//                nodes[v].arr.add(nodes[u]);
//            }
//            for (int j = 1; j < n + 1; j++) {
//                if (nodes[j].arr.size() == 1 && !nodes[j].isProtected) {
//                    result[nodes[j].arr.get(0).data] = true;
//                    nodes[j].arr.get(0).isProtected = true;
//                    for (int k = 0; k < nodes[j].arr.get(0).arr.size(); k++) {
//                        nodes[j].arr.get(0).arr.get(k).isProtected = true;
//                    }
//                }
//            }
//            for (int j = 1; j < n + 1; j++) {
//                if (!nodes[j].isProtected) {
//                    result[nodes[j].data] = true;
//                    nodes[j].isProtected = true;
//                    for (int k = 0; k < nodes[j].arr.size(); k++) {
//                        nodes[j].arr.get(k).isProtected = true;
//                    }
//                }
//            }
//            for (int j = 1; j < n + 1; j++) {
//                if (result[j]) num++;
//            }
//            out.println(num);
//            for (int j = 1; j < n + 1; j++) {
//                if (result[j]) out.print(j + " ");
//            }
//            out.println("");
//        }
//        out.close();
//    }
//}
//
//class Node {
//    ArrayList<Node> arr = new ArrayList<>();
//    boolean isVisited =false;
//    boolean isProtected = false;
//    int data;
//    public Node(int data){
//        this.data = data;
//    }
//}
//
