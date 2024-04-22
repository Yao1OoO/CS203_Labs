import java.util.ArrayList;
import java.util.Arrays;

public class A {
    public static int size;
    public static void main(String[] args) {
        QReader in = new QReader();
        int n = in.nextInt();
        int m = in.nextInt();
        Node[] nodes = new Node[n+1];
        long[] dis = new long[n+1];
        nodes[1] = new Node(1);
        dis[1] = 0;
        for (int i = 2; i <=n; i++) {
            nodes[i] = new Node(i);
            dis[i] = Long.MAX_VALUE;
        }
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            long w = in.nextLong();
            nodes[u].ad.add(nodes[v]);
            nodes[u].we.add(w);
        }
        Node[] heap = new Node[n+m];
        heap[1] = nodes[1];
        size = 1;
        while (size > 0){

        }
    }
    public Node getMin (Node[] heap){
        Node top = heap[1];
    }

}
class Node{
    int key;
    boolean isVis = false;
    ArrayList<Node> ad = new ArrayList<>();
    ArrayList<Long> we = new ArrayList<>();
    public Node (int key){
        this.key = key;
    }



}
