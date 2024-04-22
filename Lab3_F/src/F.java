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
            //test 输入

//            NumList temp5 = first.next;
//            while (temp5.next != null){
//                NumNode temp1 = temp5.first.next;
//                while (temp1.next != null){
//                    out.print(temp1.num + " ");
//                    temp1 = temp1.next;
//                }
//                out.println("");
//                temp5 = temp5.next;
//            }


            //test 合并
//            mergeList(first.next);
//            mergeList(first.next);
//            mergeList(first.next);
//            mergeList(first.next);
//            NumList temp = first.next;
//            while (temp.next != null){
//                NumNode temp1 = temp.first.next;
//                while (temp1.next != null){
//                    out.print(temp1.num + " ");
//                    temp1 = temp1.next;
//                }
//                out.println("num: "+ temp.size);
//                temp = temp.next;
//            }

            //删除且排序

            NumList temp = first.next;
            int count = 0;
            while (temp.next != null) {
//                out.println(temp.size);
                if (temp.size > 1) {
                    NumList temp1 = temp.next;
                    delete(temp);
//                    out.println("###");
                    temp = temp1;
                    if (temp.prev.last.prev.num > temp.first.next.num && temp.size == 1) {
                        temp = mergeList(temp.prev).next;
                        count++;
//                        out.println("count:" + count);
                    }
                } else {
                    temp = temp.next;
                }
                if (count != 0 && temp == last) {
                    temp = first.next;
                    count = 0;
                } else if (count == 0 && temp == last){
                    break;
                }
            }

            //test 删除//输出
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

    public static void addAfter(NumList newNode, NumList node) {
        newNode.next =
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
        NumList list1 = node;
        NumList list2 = node.next;
        list1.last.prev.next = list2.first.next;
        list2.first.next.prev = list1.last.prev;
        NumList list = new NumList();
        list.first = list1.first;
        list.last = list2.last;
        list.size = list1.size + list2.size;
        list.prev = list1.prev;
        list.next = list2.next;
        list1.prev.next = list;
        list2.next.prev =list;
        list1.prev = null;
        list2.next = null;
        return list;
    }


    public static void delete(NumList node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;

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