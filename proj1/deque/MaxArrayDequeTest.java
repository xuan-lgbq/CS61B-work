package deque;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import java.util.Comparator;
public class MaxArrayDequeTest {
    @Test
    public void testMaxWithDefaultComparator() {
        Comparator<Integer> comparator = Integer::compareTo;
        //Integer::compareTo is a reference for a compareTo method for Integer class,which creates a lambda expression
        //which equals to (a,b) ->a.compareTo(b)
        //which returns positive number(usually 1) when a>b
        //returns 0 when a=b
        //returns negative numbers(usually-1) when a<b
        MaxArrayDeque<Integer> maxDeque = new MaxArrayDeque<>(comparator);

        maxDeque.addLast(3);
        maxDeque.addLast(1);
        maxDeque.addLast(4);
        maxDeque.addLast(1);
        maxDeque.addLast(5);
        assertEquals((Integer) 5, maxDeque.max());
    }
    @Test
    public void testMaxWithCustomComparator() {
        Comparator<Integer> reverseComparator = (a, b) -> b - a;
        //It is a lambda expression that get two parameters a and b and returns b-a
        MaxArrayDeque<Integer> maxDeque = new MaxArrayDeque<>(reverseComparator);

        maxDeque.addLast(3);
        maxDeque.addLast(1);
        maxDeque.addLast(4);
        maxDeque.addLast(1);
        maxDeque.addLast(5);

        assertEquals((Integer) 1, maxDeque.max());
    }
    @Test
    public void testMaxWithEmptyDeque() {
        Comparator<Integer> comparator = Integer::compareTo;
        //Integer::compareTo is a reference for a compareTo method for Integer class,which creates a lambda expression
        //which equals to (a,b) ->a.compareTo(b)
        //which returns positive number(usually 1) when a>b
        //returns 0 when a=b
        //returns negative numbers(usually-1) when a<b
        MaxArrayDeque<Integer> maxDeque = new MaxArrayDeque<>(comparator);

        assertNull(maxDeque.max());
    }

    @Test
    public void testMaxWithSingleElement() {
        Comparator<Integer> comparator = Integer::compareTo;
        //Integer::compareTo is a reference for a compareTo method for Integer class,which creates a lambda expression
        //which equals to (a,b) ->a.compareTo(b)
        //which returns positive number(usually 1) when a>b
        //returns 0 when a=b
        //returns negative numbers(usually-1) when a<b
        MaxArrayDeque<Integer> maxDeque = new MaxArrayDeque<>(comparator);

        maxDeque.addLast(42);

        assertEquals((Integer) 42, maxDeque.max());
    }
}
