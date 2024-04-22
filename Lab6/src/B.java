//import java.util.ArrayList;
//
//public class B {
//    public static long sum = 0;
//
//    public static void main(String[] args) {
//        QReader in = new QReader();
//        int n = in.nextInt();
//        int target = in.nextInt();
//        node[] nodes = new node[n + 1];
//        for (int i = 0; i < n + 1; i++) {
//            nodes[i] = new node(i);
//        }
//        for (int i = 0; i < n - 1; i++) {
//            int u = in.nextInt();
//            int v = in.nextInt();
//            int w = in.nextInt();
//            nodes[u].children.add(nodes[v]);
//            nodes[v].children.add(nodes[u]);
//            nodes[u].edges.add(w);
//            nodes[v].edges.add(w);
//        }
//        nodes[1].isVisited =true;
//        dfs(nodes[1],0,target);
//        System.out.println(sum);
//    }
//
//    public static void dfs(node node, long currentLen, int target) {
//        node.isVisited = true;
//        for (int i = 0; i < node.children.size(); i++) {
//            node newNode = node.children.get(i);
//            if (!newNode.isVisited) {
//                currentLen += node.edges.get(i);
//                if (newNode.data != 1 && newNode.children.size() == 1 && currentLen == (long) target) {
//                    sum += 1;
//                }
//                dfs(newNode, currentLen, target);
//                currentLen -= node.edges.get(i);
//            }
//        }
//    }
//}
//
//class node {
//    public int data;
//    public boolean isVisited;
//    public ArrayList<node> children = new ArrayList<>();
//    public ArrayList<Integer> edges = new ArrayList<>();
//
//    public node(int data) {
//        this.data = data;
//        this.isVisited = false;
//    }
//}
//
