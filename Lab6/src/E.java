//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class E {
//    public static void main(String[] args) {
//        QReader in = new QReader();
//        int n = in.nextInt();
//        Node[] nodes = new Node[n+1];
//        for (int i = 0; i < n+1; i++) {
//            nodes[i] = new Node(i);
//        }
//        for (int i = 0; i < n -1; i++) {
//            int u = in.nextInt();
//            int v = in.nextInt();
//            nodes[u].children.add(nodes[v]);
//            nodes[v].children.add(nodes[u]);
//        }
//        int m = in.nextInt();
//        for (int i = 0; i < m; i++) {
//            int t = in.nextInt();
//            nodes[t].hasGiant = true;
//        }
//
//        nodes[1].isVisited = true;
//
//        int maxNum = 0;
//        for (int i = 0; i < nodes[1].children.size(); i++) {
//            Node root = nodes[1].children.get(i);
//            root.isVisited =true;
//            root.level = 1;
//            int[] giant = new int[m+1];
//            int k =0;
//            Node[] queue = new Node[n+1];
//            int first = 0;
//            int last = 1;
//            queue[0] = root;
//            while (first < last){
//                Node thisNode = queue[first++];
//                int level = thisNode.level;
//                if (thisNode.hasGiant){
//                    giant[k++] = thisNode.level;
//                }
//                for (int j = 0; j < thisNode.children.size(); j++) {
//                    if (!thisNode.children.get(j).isVisited){
//                        thisNode.children.get(j).isVisited = true;
//                        thisNode.children.get(j).level = level+1;
//                        queue[last++] = thisNode.children.get(j);
//                    }
//                }
//            }
//            int max = 0;
//            for (int j = 0; j < giant.length; j++) {
//                if (giant[j] == 0) break;
//                max = max >= giant[j] ? max+1 : giant[j];
//            }
//            maxNum = max > maxNum ? max : maxNum;
//        }
//        System.out.println(maxNum);
//    }
//}
//class Node {
//    public int data;
//    public boolean isVisited;
//    public int level;
//    public boolean hasGiant;
//    public ArrayList<Node> children = new ArrayList<>();
//    public Node(int data) {
//        this.data = data;
//        this.isVisited = false;
//    }
//}
//
