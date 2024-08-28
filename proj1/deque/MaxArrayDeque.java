package deque;
import java.util.Comparator;
public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> comparator;
   public MaxArrayDeque(Comparator<T> c){
       super();
       this.comparator=c;
   }
   public T max(){
       return max(comparator);
   }
   public T max(Comparator<T> c){
       if(isEmpty()){
           return null;
       }
       T maxitem=get(0);
       for(int i=0;i<size();i+=1){
           T currentItem=get(i);
           if(c.compare(currentItem,maxitem)>0){
               maxitem=currentItem;
           }
       }
       return maxitem;
   }

}
