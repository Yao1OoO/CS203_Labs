public class E {
    public static Queue first;
    public static Queue last;

    public static void main(String[] args) {
        QReader in = new QReader();
        first = new Queue(-10,null,null);
        last = new Queue(-20,first,null);
        first.next = last;
        long m = in.nextInt();
        long x = in.nextInt();
        long t = 0;
        int index = 1;
        long result = 0;
        while (x != -1){
            while (peekLast() == null ||( peekLast().num < x && peekLast().num != -10 && peekLast().num != -20)) {
                if (peekLast() == null) {
                    break;
                }else {
                    popLast();
                }
            }
            pushLast(x);
            peekLast().index = index;
            if (index >= m){
                t++;
            }
            if (peekFirst()!= null && peekFirst().index < t){
                popFirst();
            }

//            Queue temp = first.next;
//            while (temp != last){
//                System.out.print(temp.num+" ");
//                temp = temp.next;
//            }
//            System.out.println();
            if (index>=m){
                result = result^ peekFirst().num;
//                System.out.println("result: "+result);
            }

            x = in.nextInt();
            index++;
        }

        System.out.println(result);
    }


    public static void pushFirst(long num) {
        Queue queue = new Queue(num);
        queue.prev = first;
        queue.next = first.next;
        first.next.prev = queue;
        first.next = queue;
    }

    public static Queue peekFirst() {
        return first.next == last ? null : first.next;
    }

    public static Queue popFirst() {
        if (peekFirst() != null) {
            return delete(peekFirst());
        }
        return null;
    }

    public static void pushLast(long num) {
        Queue queue = new Queue(num);
        queue.next = last;
        queue.prev = last.prev;
        last.prev.next = queue;
        last.prev = queue;
    }

    public static Queue peekLast() {
        return last.prev == first ? null : last.prev;
    }

    public static Queue popLast() {
        if (peekLast() != null) {
            return delete(peekLast());
        }
        return null;
    }

    public static Queue delete(Queue queue) {
        queue.next.prev = queue.prev;
        queue.prev.next = queue.next;
        queue.prev = null;
        queue.next = null;
        return queue;
    }
}

class Queue {
    long num;
    long index;
    Queue prev;
    Queue next;

    public Queue(long num, Queue prev, Queue next) {
        this.num = num;
        this.prev = prev;
        this.next = next;
    }

    public Queue(long num) {
        this.num = num;
        this.prev = null;
        this.next = null;
    }
}
