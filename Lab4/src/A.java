
public class A {
    public static bracket first;
    public static bracket last;
    public static boolean flag;


    public static void main(String[] args) {

        QReader in = new QReader();
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            first = new bracket('1',null,null);
            last = new bracket('2',first,null);
            first.next = last;
            flag = true;
            int n = in.nextInt();
            String str = in.next();
//            if (n%2 == 1) {
//                System.out.println("NO");
//                continue;
//            }
            for (int j = 0; j < n; j++) {
                if (str.charAt(j) == '{' || str.charAt(j) == '[' || str.charAt(j) == '('){
                    push(new bracket(str.charAt(j),null,null));
                }else {
                    if (first.next != last){
                        bracket bracket = pop();
                        if (!((bracket.data == '{' && str.charAt(j) == '}')
                                ||(bracket.data == '[' && str.charAt(j) == ']')
                                ||(bracket.data == '(' && str.charAt(j) == ')'))){
                            flag =false;
                            break;
                        }
                    }else {
                        flag =false;
                        break;
                    }
                }
            }
            if (flag && (first.next ==last)){
                System.out.println("YES");
            }else System.out.println("NO");
        }
    }

    public static void push(bracket node) {
        node.prev = first;
        node.next = first.next;
        first.next.prev = node;
        first.next = node;
    }

    public static bracket pop() {
        bracket node = first.next == last ? null : first.next;
        if (node != null) delete(node);
        return node;
    }
    public static bracket peek(){
        return first.next == last ? null : first.next;
    }

    public static void delete(bracket node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }
}

class bracket {
    char data;
    bracket prev;
    bracket next;

    public bracket(char data, bracket prev, bracket next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}
