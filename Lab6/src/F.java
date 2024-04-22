import java.util.ArrayList;

public class F {
    public static int root = 0;  //用来储存这棵树的根
    public static long[] max;    //用来储存对于node是[i],e值最大的子节点是max[i]
    public static long sum = 0; //答案

    public static void main(String[] args) {
        QReader in = new QReader();
        int n = in.nextInt();
        Node[] nodes = new Node[n + 1];
        max = new long[n + 1];
        for (int i = 0; i < n + 1; i++) {
            nodes[i] = new Node(i);
        }
        nodes[0].e = 0;
        nodes[0].p = 0;
        //建树
        for (int i = 0; i < n - 1; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            nodes[u].children.add(nodes[v]);
            nodes[v].children.add(nodes[u]);
        }
        root = 1;
        //将叶子结点的e赋值成p 并找到根节点
        for (int i = 1; i <= n; i++) {
            nodes[i].p = in.nextInt();
            if (nodes[i].p > nodes[root].p) root = i;
            if (nodes[i].children.size() == 1) {
                nodes[i].e = nodes[i].p;
            } else {
                nodes[i].e = 0;
            }
        }
//        System.out.println(root);

        for (int i = 0; i < nodes[root].children.size(); i++) {
            //从下往上更新e值 e值为以当前节点为根的子树中e的最大值
            dfs1(nodes[root].children.get(i), root);
            //从上往下更新e值，最大e的儿子等于当前节点的e值
            dfs2(nodes[root].children.get(i), root);
            //将叶子节点的值加起来
            dfs3(nodes[root].children.get(i), root);
        }

        //如果根节点也是叶子节点
        if (nodes[root].children.size() == 1) {
            sum += nodes[root].p;
            sum += nodes[root].p - nodes[root].children.get(0).e;
        } else {  //如果根节点不是叶子结点
            int maxId = 0;  //第一大叶子节点下标
            for (int i = 0; i < nodes[root].children.size(); i++) {
                maxId = nodes[root].children.get(i).e > nodes[maxId].e ? nodes[root].children.get(i).id : maxId;
            }
            int secMaxId = 0; //第二大叶子结点下标
            for (int i = 0; i < nodes[root].children.size(); i++) {
                if (nodes[root].children.get(i).id != maxId) {
                    secMaxId = nodes[root].children.get(i).e > nodes[secMaxId].e ? nodes[root].children.get(i).id : secMaxId;
                }
            }
            if (nodes[root].p >= nodes[maxId].e + nodes[secMaxId].e) {
                sum += nodes[root].p;
            } else {
                sum += (long) 2 * nodes[root].p - nodes[maxId].e - nodes[secMaxId].e;
            }
        }
        System.out.print(sum);
    }

    public static void dfs1(Node root, int father) {
        for (Node node : root.children) {
            if (node.id != father) {
                dfs1(node, root.id);
            }
        }
        long maxNum = 0;
        for (int i = 0; i < root.children.size(); i++) {
            if (root.children.get(i).id != father) {
                maxNum = maxNum >= root.children.get(i).e ? maxNum : root.children.get(i).e;
            }
        }
        max[root.id] = maxNum;
        root.e = root.p >= maxNum ? root.p : maxNum;
    }

    public static void dfs2(Node root, int father) {
        for (int i = 0; i < root.children.size(); i++) {
            if (root.children.get(i).id != father) {
                if (root.children.get(i).e == max[root.id]) {
                    root.children.get(i).e = root.e;
                    break;
                }
            }
        }
        for (Node node : root.children) {
            if (node.id != father) {
                dfs2(node, root.id);
            }
        }
    }

    public static void dfs3(Node root, int father) {
        if (root.children.size() == 1) {
            sum += root.e;
        }
        for (Node node : root.children) {
            if (node.id != father) {
                dfs3(node, root.id);
            }
        }
    }
}

class Node {
    int id;
    long p;
    long e;
    ArrayList<Node> children = new ArrayList<>();

    public Node(int id) {
        this.id = id;
    }
}
