
public class A {
    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int n = in.nextInt();
        int m = in.nextInt();
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        LinkedList list = new LinkedList();

        for (int i = 0; i < n; i++) {
            long co = in.nextLong();
            long ex = in.nextLong();
            list1.addLast(co, ex);
        }
//        out.println(list1.first.next.co+" "+list1.first.next.ex);
        for (int i = 0; i < m; i++) {
            long co = in.nextLong();
            long ex = in.nextLong();
            list2.addLast(co, ex);
        }
        int i = 0;
        int j = 0;
        Node temp1 = list1.getFirst().next;
        Node temp2 = list2.getFirst().next;
        while (i < n && j < m) {
            if (temp1.ex > temp2.ex) {
//                out.println("$$$");
//                out.println(temp1.co +" "+ temp2.co);
                list.addLast(temp1.co, temp1.ex);
//                out.println(list.first.next.co+" "+list.first.next.ex);
                temp1 = temp1.next;
                i++;
            } else if (temp1.ex == temp2.ex) {
//                out.println("%%%");
//                out.println(temp1.co +" "+ temp2.co);
                list.addLast(temp1.co + temp2.co, temp1.ex);
//                out.println(list.first.next.co+" "+list.first.next.ex);
                temp1 = temp1.next;
                temp2 = temp2.next;
                i++;
                j++;
            } else if (temp1.ex < temp2.ex) {
//                out.println("&&&");
//                out.println(temp1.co +" "+ temp2.co);
                list.addLast(temp2.co, temp2.ex);
//                out.println(list.first.next.co+" "+list.first.next.ex);
                temp2 = temp2.next;
                j++;
            }
        }
        while (i < n) {
            list.addLast(temp1.co, temp1.ex);
            temp1 = temp1.next;
            i++;
        }

        while (j < m) {
            list.addLast(temp2.co, temp2.ex);
            temp2 = temp2.next;
            j++;
        }

        int size = 0;
        Node temp = list.first.next;
        for (int k = 0; k < list.getSize(); k++) {
            if (temp.co != 0) {
                size++;
                temp = temp.next;
            }
        }

        out.println(size);

        Node temp3 = list.first.next;
        for (int k = 0; k < list.getSize(); k++) {
            if (temp3.co != 0) {
                out.print(temp3.co + " ");
                out.println(temp3.ex);
            }
            temp3 = temp3.next;
        }
        out.close();
    }
}
