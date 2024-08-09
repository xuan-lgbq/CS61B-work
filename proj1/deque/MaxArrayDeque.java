package deque;
import java.util.Comparator;
public class MaxArrayDeque<Item> extends ArrayDeque<Item> {
    private Comparator<Item> comparator;
   public MaxArrayDeque(Comparator<Item> c){
       super();
       this.comparator=c;
   }
   public Item max(){
       return max(comparator);
   }
   public Item max(Comparator<Item> c){
       if(isEmpty()){
           return null;
       }
       Item maxitem=get(0);
       for(int i=0;i<size();i+=1){
           Item currentItem=get(i);
           if(c.compare(currentItem,maxitem)>0){
               maxitem=currentItem;
           }
       }
       return maxitem;
   }

}
