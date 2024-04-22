public class F {
    public static void main(String[] args) {
        QReader in = new QReader();
        int k = in.nextInt();
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Deque max = new Deque();
        Deque min = new Deque();
        int length = -1;
        int i = 0;
        int j = 0;
        while (j < n && i < n) {
//            System.out.println("i: "+i+"    j: "+j);
            while (max.peekLast() != null && max.peekLast().num < arr[j]) {
                max.popLast();
            }
            max.pushLast(arr[j], j);
//            System.out.println("max in deque: "+max.peekFirst().num +"  id"+max.peekFirst().index);
            while (min.peekLast() != null && min.peekLast().num > arr[j]) {
                min.popLast();
            }
            min.pushLast(arr[j], j);
//            System.out.println("min in deque: "+min.peekFirst().num+"  id"+min.peekFirst().index);
            while (max.peekFirst().index < i) {
                max.popFirst();
            }
            while (min.peekFirst().index < i) {
                min.popFirst();
            }
//            System.out.println("max: " + max.peekFirst().num);
//            System.out.println("min: "+ min.peekFirst().num);
            if (Math.abs(max.peekFirst().num - min.peekFirst().num) > k){
                i++;
                continue;
            }else{
                length = Math.max(length, j - i +1);
                j++;
            }
        }
        System.out.println(length);
    }
}

class Deque {
    Node first;
    Node last;

    public Deque() {
        this.first = new Node(-1, -1, null, null);
        this.last = new Node(-2, -2, first, null);
        this.first.next = last;
    }

    public void pushFirst(long num, long index) {
        Node queue = new Node(num, index);
        queue.prev = first;
        queue.next = first.next;
        first.next.prev = queue;
        first.next = queue;
    }

    public Node peekFirst() {
        return first.next == last ? null : first.next;
    }

    public Node popFirst() {
        if (peekFirst() != null) {
            return delete(peekFirst());
        }
        return null;
    }

    public void pushLast(long num, int index) {
        Node queue = new Node(num, index);
        queue.next = last;
        queue.prev = last.prev;
        last.prev.next = queue;
        last.prev = queue;
    }

    public Node peekLast() {
        return last.prev == first ? null : last.prev;
    }

    public Node popLast() {
        if (peekLast() != null) {
            return delete(peekLast());
        }
        return null;
    }

    public static Node delete(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        node.prev = null;
        node.next = null;
        return node;
    }
}

class Node {
    long num;
    long index;
    Node prev;
    Node next;

    public Node(long num, long id, Node prev, Node next) {
        this.num = num;
        this.index = id;
        this.prev = prev;
        this.next = next;
    }

    public Node(long num, long id) {
        this.num = num;
        this.index = id;
        this.prev = null;
        this.next = null;
    }
}
