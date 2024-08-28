package deque;

public class LinkedListDeque <T> implements Deque<T>{
    private class IntNode{
        public T item;
        public IntNode next;
        public IntNode before;
        public  IntNode(T i,IntNode n,IntNode m){
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
    public  LinkedListDeque(T x){
      this();
       startSentinel.next=new IntNode(x,endSentinel, startSentinel);
       size=1;
    }

    public int getSize() {
        return size;
    }

    public IntNode getEndSentinel() {
        return endSentinel;
    }
@Override
    public void addFirst(T x){
        IntNode t=startSentinel.next;
        startSentinel.next=new IntNode(x,t,startSentinel);
        t.before=startSentinel.next;
        size+=1;
    }
    public T getFirst(){
        return (startSentinel.next.item);
    }
    @Override
    public void addLast(T x){
        IntNode p=endSentinel.before;
        IntNode q=new IntNode(x,endSentinel,p);
        p.next=q;
        endSentinel.before=q;
        size+=1;
    }
    @Override
    public T removeLast(){
        if(size==0)
        {
            return null;
        }
        IntNode p=endSentinel.before;
        if(p!=null) {
            T remove = p.item;
            p.before.next = endSentinel;
            endSentinel.before = p.before;
            p.next = null;
            p.before = null;
            size -= 1;
            return remove;
        }
        return null;
    }
    /**
     * @Override
    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }*/
    @Override
    public T removeFirst(){
        IntNode x=startSentinel.next;
        if(size==0)
        {
            return null;
        }
        if(x==null){
            return null;
        }
        else{
            T remove=x.item;
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
    @Override
    public int size(){
        return size;
    }
    public T getRecursive(int index){

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
    @Override
    public T get(int index){
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
    @Override
    public void printDeque(){
        for(int i=0;i<size;i+=1)
         System.out.println(getRecursive(i));
    }
}
