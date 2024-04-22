public class C {
    public static Num first;
    public static Num last;
    public static long MOD = 514329;

    public static void main(String[] args) {
        first = new Num(-10000, null, null);
        last = new Num(-20000, first, null);
        first.next = last;
        QReader in = new QReader();
        String str = in.next();
        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            if (x == '(') {
                push(-1);
            } else {
                if (peek().data == -1) {
                    pop();
                    push(1);
                } else {
                    long n = pop().data % MOD;
                    while (peek().data != -1) {
                        n = (n + pop().data) % MOD;
                    }
                    n = (n * 2) % MOD;
                    pop();
                    push(n);
                }
            }

        }
        if (peek().data == -1) {
            pop();
            push(1);
        } else {
            long n = pop().data % MOD;
            while (peek() != null) {
                n = (n + pop().data) % MOD;
            }
            pop();
            push(n);
        }
        System.out.println(pop().data);
    }


    public static void push(Num node) {
        node.prev = first;
        node.next = first.next;
        first.next.prev = node;
        first.next = node;
    }

    public static void push(long data) {
        Num node = new Num(data, null, null);
        node.prev = first;
        node.next = first.next;
        first.next.prev = node;
        first.next = node;
    }

    public static Num pop() {
        Num node = first.next == last ? null : first.next;
        if (node != null) delete(node);
        return node;
    }

    public static Num peek() {
        return first.next == last ? null : first.next;
    }

    public static void delete(Num node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }


}


class Num {
    long data;
    Num prev;
    Num next;

    public Num(long data, Num prev, Num next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}