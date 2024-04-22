public class B2 {
    public static NodeOfB current;
    public static NodeOfB first;
    public static NodeOfB last;

    public static void main(String[] args) {
        QReader in = new QReader();
        QWriter out = new QWriter();
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int x = in.nextInt();
            first = new NodeOfB(-2000000,null,null);
            last = new NodeOfB(2000000,first,null);
            first.next = last;
            current = last;
            String str = in.next();
//            System.out.println(Arrays.toString(arr));
            for (int j = 0; j < str.length(); j++) {
                if (Character.isDigit(str.charAt(j))){
                    int a  = str.charAt(j) -'0';
                    add(a,current);
                }
                else if (str.charAt(j) == 'H'){
                    left();
                }else if (str.charAt(j) == 'L'){
                    right();
                } else if (str.charAt(j) == 'x') {
                    current = delete(current);
                } else if (str.charAt(j) == 'I') {
                    moveToHead();
                }else if (str.charAt(j) == 'r') {
                    if (j+1 != str.length()){
                        int a = str.charAt(j+1) - '0';
                        change(a, current);
                        j++;
                    }
                }
                //test
//                NodeOfB temp =first.next;
//                while (temp.next != null){
//                    System.out.print(temp.num);
//                    temp = temp.next;
//                }
//                System.out.println();
            }
            NodeOfB temp =first.next;
            while (temp.next != null){
                out.print(temp.num);
                temp = temp.next;
            }
            out.println("");
        }
        out.close();
    }
    public static void add(int data,NodeOfB current){
        NodeOfB node = new NodeOfB(data ,null,null);
        node.next = current;
        node.prev = current.prev;
        current.prev.next = node;
        current.prev = node;
    }
    public static NodeOfB delete(NodeOfB current){
        if (current.next == null){
            return current;
        }else {
            NodeOfB temp =  current.next;
            current.next.prev = current.prev;
            current.prev.next = current.next;
            return temp;
        }
    }

    public static void change(int data,NodeOfB cur){
        if (cur.next ==null){
            add(data,cur);
            current = cur.prev;
        }else {
            cur.num = data;
        }
    }

    public static void moveToHead(){
        current = first.next;
    }

    public static void left(){
        if (current.prev!= first){
            current = current.prev;
        }
    }
    public static void right(){
        if (current.next != null){
            current = current.next;
        }
    }
}
class NodeOfB{
    public int num;
    public NodeOfB prev;
    public NodeOfB next;

    public NodeOfB(int num,NodeOfB prev, NodeOfB next){
        this.num = num;
        this.prev = prev;
        this.next = next;
    }
}