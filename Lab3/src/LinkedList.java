class LinkedList {
    public Node first;
    public Node last;
    public long size;
    public Node getFirst(){
        return this.first;
    }

    public LinkedList(){
        this.first = new Node(0,0,null,null);
        this.last = new Node(0,0,this.first,null);
        this.first.next = this.last;
        this.size = 0;
    }

    public Node getIndex(long index){
        if (index< 0 || index >= size){
            return null;
        }else {
            Node temp = null;
            if (index <= size/2){
                temp  = first.next;
                for (int i = 0; i < index; i++) {
                    temp = temp.next;
                }
            }else {
                temp = last.prev;
                for (long i = size -1 ; i > index; i--) {
                    temp = temp.prev;
                }
            }
            return temp;
        }
    }

    public long getIndexCo(long index){
        return getIndex(index).co;
    }
    public void setIndexCo(long index,long co){
        getIndex(index).setCo(co);
    }


    public long getIndexEx(long index){
        return getIndex(index).ex;
    }

    public boolean addFirst(long co,long ex){
        Node node = new Node(co,ex,null,null);
        node.prev = this.first;
        this.first.next.prev =node;
        node.next = this.first.next;
        this.first.next = node;
        size++;
        return true;
    }

    public boolean addLast(long co,long ex){
        Node node = new Node(co,ex,null,null);
        node.next = this.last;
        node.prev = this.last.prev;
        this.last.prev.next = node;
        this.last.prev = node;
        size++;
        return true;
    }

    public boolean addIndex(long co ,long ex ,long index){
        if (index > size  | index < 0){
            return false;
        }else {
            if (index  == 0){
                addFirst(co,ex);
            }else if (index == size){
                addLast(co,ex);
            }else {
                Node temp = getIndex(index);
                Node node = new Node(co,ex,null,null);
                node.next = temp;
                node.prev = temp.prev;
                temp.prev.next = node;
                temp.prev = node;
                size++;
            }
            return true;
        }
    }

    public boolean removeIndex(long index){
        Node temp= getIndex(index);
        if (temp == null){
            return false;
        }else {
            temp.next.prev = temp.prev;
            temp.prev.next = temp.next;
            size--;
            return true;
        }
    }

    public long getSize(){
        return this.size;
    }

}




