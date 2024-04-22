public class Node{
    public long co;
    public long ex;
    public Node prev;
    public Node next;

    public Node(long co ,long ex,Node prev, Node next){
        this.co = co;
        this.ex = ex;
        this.prev = prev;
        this.next = next;
    }
    public void setCo(long co){
        this.co = co;
    }
    public Node getPrev(){
        return this.prev;
    }
    public Node getNext(){
        return this.next;
    }
}