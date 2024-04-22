import java.util.ArrayList;

public class F {
    public static long MOD = (long) 1e9 + 7;
    public static void main(String[] args) {
        QReader in = new QReader();
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            long result = 0;
            Node[] nodes = new Node[n + 1];
            for (int j = 1; j < n + 1; j++) {
                nodes[j] = new Node(j);
                nodes[j].a = in.nextLong();
                nodes[j].b = in.nextLong();
            }
            for (int j = 0; j < m; j++) {
                int u = in.nextInt();
                int v = in.nextInt();
                nodes[u].ad.add(nodes[v]);
                nodes[u].out++;
                nodes[v].in++;
            }
            Node[] queue = new Node[n + 10];
            int first = 0;
            int last = 0;
            for (int j = 1; j <= n; j++) {
                if (nodes[j].in == 0) {
                    queue[last] = nodes[j];
                    last++;
                }
            }
            while (first != last) {
                result = (result + queue[first].sum * queue[first].b % MOD) % MOD;
                for (int j = 0; j < queue[first].ad.size(); j++) {
                    queue[first].ad.get(j).sum = ((queue[first].a + queue[first].sum)% MOD + queue[first].ad.get(j).sum) % MOD;
                    queue[first].ad.get(j).cnt++;
                    if (queue[first].ad.get(j).cnt == queue[first].ad.get(j).in) {
                        queue[last] = queue[first].ad.get(j);
                        last++;
                    }
                }
                first++;
            }
            System.out.println(result);
        }
    }
}

class Node {
    ArrayList<Node> ad = new ArrayList<>();
    int key;
    long a;
    long b;
    int in = 0;
    int out = 0;
    int cnt = 0;
    long sum = 0;

    public Node(int key) {
        this.key = key;
    }
}
