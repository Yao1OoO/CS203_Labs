
public class F {

    public static NumList first;
    public static NumList last;

    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();

        //t组样例
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            //初始化头尾节点
            first = new NumList();
            last = new NumList();
            first.next = last;
            last.prev = first;

            //读入
            int n = in.nextInt();
            int prevNum = 0;            //记录上一次的数值
            NumList currentList = null; //记录当前储存的内层链表
            for (int j = 0; j < n; j++) {
                int x = in.nextInt();  //当前值
                NumNode num = new NumNode(x, null, null);
                if (j == 0 || prevNum <= x) {      //如果输入的数为第一个数，或者大于等于他前面的数，则新建立一个内层链表存放
                    NumList list = new NumList();
                    currentList = list;
                    list.addLastNum(num);
                    addLast(list);
                } else {                          //如果输入的数小于上个数，则加入当前链表
                    currentList.addLastNum(num);
                }
                prevNum = x;     //更新上一次的数值
            }

//            print();

            NumList temp = first.next;
            NumList[] location = new NumList[n + 10];
            int k = 0;

            while (temp.next != null) {
                if (temp.size > 1) {
                    NumList temp1 = temp.next;
                    delete(temp);
                    temp = temp1;
                    if (temp.size == 1) {
                        if (temp.prev.last.prev.num > temp.first.next.num) {
                            mergeList(temp);
                            location[k] = temp;
                        } else {
                            if (location[k] != null) {
                                k++;
                            }
                        }
                        temp = temp.next;
                    }
                } else {
                    if (location[k] != null) {
                        k++;
                    }
                    temp = temp.next;
                }
            }



            int l = 0;
            for (int j = 0; j < n + 10; j++) {

//                System.out.println("---------------------------------");
                //print();

                //printLoc(location);
                //System.out.println("l = " + l);

                if (location[j] == null) {
                    break;
                }
                NumList list = location[j].next;
                delete(location[j]);
                location[j] = null;
                //System.out.println("list.first = "+list.first.next.num+ " prev = "+list.prev.last.prev.num);
                if (list.size == 1){
                    //System.out.println("loc[l] == null is : "+(location[l] == null));
                    if (list.first.next.num < list.prev.last.prev.num){
                        if (location[l] == null || location[l] == list.prev){
                            mergeList(list);
                            location[l] = list;
                        }else {
                            mergeList(list);
                            location[++l] =list;
                        }
                    }else {
                        if (location[l] != null){
                            l++;
                        }
                    }
                }
                if (location[j + 1] == null){
                    //System.out.println("$$$");
                    j = -1;
                    l = 0;
                }
            }

            NumList temp1 = first.next;
            while (temp1.next != null) {
                NumNode temp2 = temp1.first.next;
                while (temp2.next != null) {
                    out.print(temp2.num + " ");
                    temp2 = temp2.next;
                }
                temp1 = temp1.next;
            }
            out.println("");
        }
        out.close();
    }

    public static void addBefore(NumList newNode, NumList node) {
        newNode.next = node;
        newNode.prev = node.prev;
        node.prev.next = newNode;
        node.prev = newNode;
    }

    public static void addLast(NumList list) {
        list.next = last;
        list.prev = last.prev;
        last.prev.next = list;
        last.prev = list;
    }

    public static NumList mergeList(NumList node) {
        NumList list1 = node.prev;
        list1.prev.next = node;
        node.prev = list1.prev;
        list1.last.prev.next = node.first.next;
        node.first.next.prev = list1.last.prev;
        list1.last.prev = null;
        list1.last = null;
        node.first.next = null;
        node.first = list1.first;
        list1.first = null;
        node.size = node.size + list1.size;
        return node;
    }


    public static void delete(NumList node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        node.prev = null;
        node.next = null;
    }

    public static void print() {
        NumList temp1 = first.next;
        while (temp1.next != null) {
            NumNode temp2 = temp1.first.next;
            while (temp2.next != null) {
                System.out.print(temp2.num + " ");
                temp2 = temp2.next;
            }
            System.out.print(" --- ");
            temp1 = temp1.next;
        }
        System.out.println();
    }

    public static void printLoc(NumList[] loc) {
        for (int i = 0; i < loc.length; i++) {
            if (loc[i] != null)
                System.out.print(loc[i].toString() + " || ");
            else System.out.print("null || ");
        }
        System.out.println();
    }

}

class NumList {
    NumNode first;
    NumNode last;
    int size;

    NumList prev;
    NumList next;

    public NumList() {
        this.first = new NumNode(-1, null, null);
        this.last = new NumNode(-2, first, null);
        this.first.next = last;
        this.size = 0;
    }

    public void addLastNum(int num) {
        NumNode node = new NumNode(num, this.last.prev, this.last);
        this.last.prev.next = node;
        this.last.prev = node;
        size++;
    }

    public void addLastNum(NumNode num) {
        num.next = this.last;
        num.prev = this.last.prev;
        this.last.prev.next = num;
        this.last.prev = num;
        size++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        NumNode temp = first.next;
        while (temp != last) {
            sb.append(temp.num + " ");
            temp = temp.next;
        }
        sb.append(")");
        return sb.toString();
    }
}

class NumNode {
    NumNode prev;
    NumNode next;
    int num;

    public NumNode(int num, NumNode prev, NumNode next) {
        this.num = num;
        this.prev = prev;
        this.next = next;
    }
}