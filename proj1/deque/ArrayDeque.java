package deque;
public class ArrayDeque<Item> {
    private Item[] items;
    private int size;
    private int start;
    private int end;
    private int capacity;
    public ArrayDeque(){
        capacity=8;
        items=(Item []) new Object[capacity];
        start=0;
        end=0;
        size=0;
    }
    private void resize(int newCapacity){
        Item [] newArray=(Item[]) new Object[newCapacity];
        for (int i=0;i<size;i+=1){
            newArray[i]=items[(start+i)%capacity];
        }
        items=newArray;
        start=0;
        end=size;
        capacity=newCapacity;
    }
    public void addFirst (Item item){
        if(size==capacity){
            resize(capacity*2);
        }
           start=(start-1+capacity)%capacity;
        items[start]=item;
        size+=1;
    }
    public void addLast(Item item){
        if(size==capacity){
            resize(capacity*2);
        }
        items[end]=item;
        end=(end+1)%capacity;
        size+=1;
    }
    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        for(int i=0;i<size;i+=1){
            System.out.println(items[(start+i)%capacity]);
        }
    }
    public Item removeFirst(){
        if(isEmpty()){
            return null;
        }
        else {
            Item x=items[start];
            start=(start+1)%capacity;
            size-=1;
            if(size>0&&size<=capacity/4){
                resize(capacity/2);
            }
            return x;
        }
    }
    public Item removeLast(){
        if(isEmpty()) {
            return null;
        }
        else{
            end=(end-1+capacity)%capacity;
            Item x=items[end];
            items[end]=null;
                size-=1;
                if(size>0&&size<=capacity/4){
                    resize(capacity/2);
            }
                return x;

    }
  }
  public Item get(int index){
   if(index>=size||index<0){
       return null;
   }
   return items[(start+index)%capacity];
  }
}

