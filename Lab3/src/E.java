public class E {
    public static NodeOfE first;
    public static NodeOfE last;

    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        first = new NodeOfE(-1, null, null);
        last = new NodeOfE(-2, first, null);
        first.next = last;
        NodeOfE[] nodesOfSort = new NodeOfE[n];
        int[] id = new int[n];
        int[] result = new int[n - 1];
        for (int i = 0; i < n; i++) {
            nodesOfSort[i] = new NodeOfE(in.nextInt(), null, null);
            nodesOfSort[i].id = i;

        }
//        for (int i = 0; i < n; i++) {
//            out.print(nodesOfSort[i].id+" ");
//        }
//        out.println("____");
//        for (int i = 0; i < nodesOfSort.length; i++) {
//            out.print(nodesOfSort[i].num+" ");
//
//        }
//        out.println("______");
        process(nodesOfSort, 0, nodesOfSort.length - 1);
        for (int i = 0; i < n; i++) {
//            out.print(nodesOfSort[i].id+" ");
            id[nodesOfSort[i].id] = i;
            addLast(nodesOfSort[i]);
        }

        for (int i = 0; i < n - 1; i++) {
            NodeOfE temp = nodesOfSort[id[i]];
            if (nodesOfSort[id[i]].id != n - 1) {
                if (temp.prev == first) {
                    result[temp.id] = Math.abs(temp.num - temp.next.num);
//                    out.println(temp.num +" " +temp.next.num + "@@@");
                } else if (temp.next == last) {
                    result[temp.id] = Math.abs(temp.num - temp.prev.num);
//                    out.println(temp.num - temp.prev.num + "###");
                } else {
                    result[temp.id] = Math.min(Math.abs(temp.num - temp.prev.num), Math.abs(temp.num - temp.next.num));
//                    out.println(temp.num - temp.next.num + "@@");
//                    out.println(temp.num - temp.prev.num + "##");
                }
                delete(temp);
//                NodeOfE temp1 = first.next;
//                while (temp1.next != null) {
//                    System.out.print(temp1.num + " ");
//                    temp1 = temp1.next;
//
//                }
//                System.out.println();
            }

        }
        for (int i = 0; i < n - 1; i++) {
            out.print(result[i] + " ");
        }

        //test sort
//        for (int i = 0; i < nodesOfSort.length; i++) {
//            out.print(nodesOfSort[i].num+" ");
//        }
//
//        test input
//        NodeOfE temp = first.next;
//        while (temp.next != null){
//            System.out.print(temp.num+" ");
//            temp = temp.next;
//        }
        //test nodes
//        for (int i = 0; i < id.length; i++) {
//            out.print(id[i]+" ");
//        }

        out.close();
    }

    public static void add(int data, NodeOfE current) {
        NodeOfE node = new NodeOfE(data, null, null);
        node.next = current;
        node.prev = current.prev;
        current.prev.next = node;
        current.prev = node;
    }

    public static void addFirst(int data) {
        NodeOfE node = new NodeOfE(data, first, first.next);
        first.next.prev = node;
        first.next = node;
    }

    public static void addLast(NodeOfE node) {
        node.next = last;
        node.prev = last.prev;
        last.prev.next = node;
        last.prev = node;
    }

    public static void delete(NodeOfE node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public static void process(NodeOfE[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = (l + r) / 2;
        process(arr, l, mid);
        process(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void merge(NodeOfE[] arr, int l, int m, int r) {
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


class NodeOfE {
    public int num;
    public int id;
    public NodeOfE prev;
    public NodeOfE next;

    public NodeOfE(int num, NodeOfE prev, NodeOfE next) {
        this.num = num;
        this.prev = prev;
        this.next = next;
    }
}
