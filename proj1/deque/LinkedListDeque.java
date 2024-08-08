package deque;

public class LinkedListDeque <Item>{
    private class IntNode{
        public Item item;
        public IntNode next;
        public IntNode before;
        public  IntNode(Item i,IntNode n,IntNode m){
            item=i;
            next=n;
            before=m;
        }
    }
    private  IntNode startSentinel;
    private IntNode endSentinel;
    private int size;
    public LinkedListDeque(){
        startSentinel =new IntNode(null,null,null);
        endSentinel=new IntNode(null,null,null);
        startSentinel.next=endSentinel;
        startSentinel.before=null;
        endSentinel.next=null;
        endSentinel.before=startSentinel;
        size=0;
    }
    public  LinkedListDeque(Item x){
      this();
       startSentinel.next=new IntNode(x,endSentinel, startSentinel);
       size=1;
    }
    public void addFirst(Item x){
        IntNode t=startSentinel.next;
        startSentinel.next=new IntNode(x,t,startSentinel);
        t.before=startSentinel.next;
        size+=1;
    }
    public Item getFirst(){
        return (startSentinel.next.item);
    }
    public void addLast(Item x){
        IntNode p=endSentinel.before;
        IntNode q=new IntNode(x,endSentinel,p);
        p.next=q;
        endSentinel.before=q;
        size+=1;
    }
    public Item removeLast(){
        if(size==0)
        {
            return null;
        }
        IntNode p=endSentinel.before;
        if(p!=null) {
            Item remove = p.item;
            p.before.next = endSentinel;
            endSentinel.before = p.before;
            p.next = null;
            p.before = null;
            size -= 1;
            return remove;
        }
        return null;
    }
    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }
    public Item removeFirst(){
        IntNode x=startSentinel.next;
        if(size==0)
        {
            return null;
        }
        if(x==null){
            return null;
        }
        else{
            Item remove=x.item;
        startSentinel.next=x.next;
        if(x.next!=null) {
            x.next.before=startSentinel;
        }
        x.before=null;
        x.next=null;
        size-=1;
        return remove;
        }
    }
    public int size(){
        return size;
    }
    public Item getRecursive(int index){

        int i=0;
        IntNode p;
        p=startSentinel.next;
        if(index>size()-1) {
            return null;
        }
        while(i<index){
            i+=1;
            p=p.next;
        }
            return p.item;
    }
    public Item get(int index){
        int i=0;
        IntNode p;
        p=startSentinel.next;
        if(index>size()-1) {
            return null;
        }
        while(i<index){
            i+=1;
            p=p.next;
        }
        return p.item;
    }
    public void printDeque(){
        for(int i=0;i<size;i+=1)
         System.out.println(getRecursive(i));
    }
}
