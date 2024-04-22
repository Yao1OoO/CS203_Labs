
public class A {
    public static boolean isMax;
    public static boolean isMin;
    public static void main(String[] args) {
        QReader in = new QReader();
        int t = in.nextInt();
        label:
        for (int i = 0; i < t; i++) {
            isMax =true;
            isMin =true;
            int n = in.nextInt();
            Node[] nodes = new Node[n + 1];
            boolean[] notRoot = new boolean[n + 1];
            for (int j = 1; j < nodes.length; j++) {
                nodes[j] = new Node(in.nextInt());
            }
            for (int j = 0; j < n - 1; j++) {
                int u = in.nextInt();
                int v = in.nextInt();
                notRoot[v] = true;
//                System.out.println(nodes[u].children[0] == null);
//                System.out.println(nodes[u].children[1] == null);
                if (nodes[u].children[0] != null && nodes[u].children[1] != null) {
                    System.out.println("Case #"+(i+1)+": NO");
                    continue label;
                }
                if (nodes[u].children[0] == null) {
                    nodes[u].children[0] = nodes[v];
                } else {
                    nodes[u].children[1] = nodes[v];
                }
            }
            int root = 0;
            for (int j = 1; j < notRoot.length; j++) {
                if (!notRoot[j]) {
                    root = j;
                    break;
                }
            }
            Node[] heap = new Node[n + 1];
            nodes[root].id = 1;
            Node[] queue = new Node[n + 1];
            queue[0] = nodes[root];
            heap[1] = nodes[root];
            int first = 0;
            int last = 1;
            try {
                while (first < last) {
                    Node thisNode = queue[first++];
                    if (thisNode.id <= 0 || thisNode.id >n){
                        System.out.println("Case #"+(i+1)+": NO");
                        continue label;
                    }
                    if (thisNode.children[0] != null) {
                        thisNode.children[0].id = 2 * thisNode.id;
                        queue[last++] = thisNode.children[0];
                        heap[2 * thisNode.id] = thisNode.children[0];
                    }
                    if (thisNode.children[1] != null) {
                        thisNode.children[1].id = 2 * thisNode.id + 1;
                        queue[last++] = thisNode.children[1];
                        heap[2* thisNode.id + 1] = thisNode.children[0];
                    }
                }
            }catch (Exception e){
                System.out.println("Case #"+(i+1)+": NO");
                continue label;
            }
            for (int j = 1; j < heap.length; j++) {
                if ((heap[j].children[0]!= null && heap[j].data>heap[j].children[0].data)
                        ||(heap[j].children[1] != null && heap[j].data > heap[j].children[1].data)){
                    isMin = false;
                    break ;
                }
            }
            if (isMin){
                System.out.println("Case #"+(i+1)+": YES");
                continue ;
            }else {
                for (int j = 1; j < heap.length; j++) {
                    if ((heap[j].children[0]!= null && heap[j].data < heap[j].children[0].data)
                            ||(heap[j].children[1] != null && heap[j].data <  heap[j].children[1].data)){
                        isMax = false;
                        break ;
                    }
                }
            }
            if(isMax){
                System.out.println("Case #"+(i+1)+": YES");
            }
        }
    }
}

class Node {
    public int data;
    public int level;
    public int id;
    public Node[] children = new Node[2];

    public Node(int data) {
        this.data = data;
    }
}