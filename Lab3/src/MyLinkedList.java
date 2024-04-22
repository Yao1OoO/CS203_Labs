//public class MyLinkedList<T> {
//    private Node<T> first;
//    private Node<T> last;
//    private long size;
//
//    public MyLinkedList(){
//        this.first = new Node<>(null,null,null);
//        this.last = new Node<>(null,this.first,null);
//        this.first.next = this.last;
//        this.size = 0;
//    }
//
//    public Node<T> getIndex(long index){
//        if (index< 0 || index >= size){
//            return null;
//        }else {
//            Node<T> temp = null;
//            if (index <= size/2){
//                temp  = first.next;
//                for (int i = 0; i < index; i++) {
//                    temp = temp.next;
//                }
//            }else {
//                temp = last.prev;
//                for (long i = size -1 ; i > index; i--) {
//                    temp = temp.prev;
//                }
//            }
//            return temp;
//        }
//    }
//
//    public T getIndexData(long index){
//        T t =getIndex(index).data;
//        if (t == null){
//            return null;
//        }
//        return t;
//    }
//
//    public boolean addFirst(T data){
//        Node<T> node = new Node<T>(data,null,null);
//        node.prev = this.first;
//        this.first.next.prev =node;
//        node.next = this.first.next;
//        this.first.next = node;
//        size++;
//        return true;
//    }
//
//    public boolean addLast(T data){
//        Node<T> node = new Node<>(data,null,null);
//        node.data = data;
//        node.next = this.last;
//        node.prev = this.last.prev;
//        this.last.prev.next = node;
//        this.last.prev = node;
//        size++;
//        return true;
//    }
//
//    public boolean addIndex(T data ,long index){
//        if (index > size  | index < 0){
//            return false;
//        }else {
//            if (index  == 0){
//                addFirst(data);
//            }else if (index == size){
//                addLast(data);
//            }else {
//                Node<T> temp = getIndex(index);
//                Node<T> node = new Node<>(data,null,null);
//                node.data = data;
//                node.next = temp;
//                node.prev = temp.prev;
//                temp.prev.next = node;
//                temp.prev = node;
//                size++;
//            }
//            return true;
//        }
//    }
//
//    public boolean removeIndex(long index){
//        Node<T> temp= getIndex(index);
//        if (temp == null){
//            return false;
//        }else {
//            temp.next.prev = temp.prev;
//            temp.prev.next = temp.next;
//            size--;
//            return true;
//        }
//    }
//
//    public long getSize(){
//        return this.size;
//    }
//    private static class Node<T>{
//        public T data;
//        public Node<T> prev;
//        public Node<T> next;
//
//        public Node(T data ,Node<T> prev, Node<T> next){
//            this.data = data;
//            this.prev = prev;
//            this.next = next;
//        }
//
//    }
//}
//
//
//
//
