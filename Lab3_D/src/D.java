public class D {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            //读入n，规定数组长度
            int n = in.nextInt();
            int x = n % 2 == 1 ? n : n - 1;
            NodeOfD[] nodes = new NodeOfD[x]; //节点数组
            int[] id = new int[x];            //映射关系
            int[] result = new int[x];        //结果数组，只在奇数位上储存

            //建立头尾节点并连接
            NodeOfD first = new NodeOfD(-1, -1, null, null);
            NodeOfD last = new NodeOfD(-2, -2, first, null);
            first.next = last;

            //读入数组
            for (int j = 0; j < n; j++) {
                if (j == n - 1 && n % 2 == 0) {
                    int m = in.nextInt();
                    break;
                }
                NodeOfD node = new NodeOfD(in.nextInt(), j, null, null);
                nodes[j] = node;
            }

            //排序
            process(nodes, 0, nodes.length - 1);

//测试读入、排序
//            for (int j = 0; j < nodes.length; j++) {
//                out.println(j);
//                out.println(nodes[j].num);
//            }
//            out.println("____________________");
            for (int j = 0; j < x; j++) {    //link
                id[nodes[j].id] = j;
                addLast(nodes[j], last);
            }
//测试link
//            for (int j = 0; j < id.length; j++) {
//                out.print(id[j] + " ");
//            }
//            NodeOfD temp1 = first.next;
//            while (temp1.next != null){
//                out.println(temp1.num);
//                temp1 = temp1.next;
//            }
//            out.println("------------------------");

//            delete(first.next.next);
//            delete(last.prev.prev);
//            temp1 = first.next;
//            while (temp1.next != null) {
//                out.println(temp1.num);
//                temp1 = temp1.next;
//            }
//            out.println("------------------------");
            int mid = (x - 1) / 2;   //找到初始中位的点
            NodeOfD temp = nodes[mid];

            for (int j = x - 1; j >= 0; j -= 2) {
                result[j] = temp.num;
                if (j == 0) {
                    result[0] = nodes[id[0]].num;
                    break;
                } else if (id[j] >= id[temp.id] && id[j - 1] >= id[temp.id]) {
                    temp = temp.prev;
                } else if (id[j] <= id[temp.id] && id[j - 1] <= id[temp.id]) {
                    temp = temp.next;
                }
                delete(nodes[id[j]]);
                delete(nodes[id[j - 1]]);
            }
            for (int j = 0; j < result.length - 1; j += 2) {
                out.print(result[j] + " ");
            }
            out.println(result[result.length-1]);
        }
        out.close();
    }

    public static void addLast(NodeOfD node, NodeOfD last) {
        node.next = last;
        node.prev = last.prev;
        last.prev.next = node;
        last.prev = node;
    }

    public static void delete(NodeOfD node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public static void process(NodeOfD[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = (l + r) / 2;
        process(arr, l, mid);
        process(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void merge(NodeOfD[] arr, int l, int m, int r) {
        int i = l;
        int j = m + 1;
        int[] temp = new int[r - l + 1];
        int[] tempid = new int[r - l + 1];
        int k = 0;

        while (i <= m && j <= r) {
            if (arr[i].num <= arr[j].num) {
                temp[k] = arr[i].num;
                tempid[k] = arr[i].id;
                i++;
            } else {
                temp[k] = arr[j].num;
                tempid[k] = arr[j].id;
                j++;
            }
            k++;
        }

        while (i <= m) {
            temp[k] = arr[i].num;
            tempid[k] = arr[i].id;
            i++;
            k++;
        }

        while (j <= r) {
            temp[k] = arr[j].num;
            tempid[k] = arr[j].id;
            j++;
            k++;
        }
        //System.out.println(Arrays.toString(temp));
        for (int n = 0; n < r - l + 1; n++) {
            arr[n + l].num = temp[n];
            arr[n + l].id = tempid[n];
        }
    }
}

class NodeOfD {
    public int num;
    public int id;
    public NodeOfD prev;
    public NodeOfD next;

    public NodeOfD(int num, int id, NodeOfD prev, NodeOfD next) {
        this.num = num;
        this.id = id;
        this.prev = prev;
        this.next = next;
    }
}
