package randomizedtest;
import org.junit.Test;
import static org.junit.Assert.*;

public class testThreeAddThreeRemove {
    @Test
    public void testBuggyList() {
        int[] a = {4, 5, 6};
        BuggyAList<Integer> x = new BuggyAList<>();
        x.addLast(4);
        assertEquals((Integer) 4, x.get(0));
        x.addLast(5);
        assertEquals((Integer) 5, x.get(1));
        x.addLast(6);
        assertEquals((Integer) 6, x.get(2));
        for (int i = x.size()-1; i > 0; i -= 1){
            x.removeLast();
            int[] expected = new int[i];
            System.arraycopy(a, 0, expected, 0, i);
            int[] item = new int[i];
            for (int j = 0; j < i; j += 1) {
                item[j] = x.get(j);
            }
            assertArrayEquals(expected, item);
        }
    }

    @Test
    public void testAListNoResizing() {
        int[] a = {4, 5, 6};
        AListNoResizing<Integer> x = new AListNoResizing<>();
        x.addLast(4);
        assertEquals((Integer) 4, x.get(0));
        x.addLast(5);
        assertEquals((Integer) 5, x.get(1));
        x.addLast(6);
        assertEquals((Integer) 6, x.get(2));
        x.removeLast();
        for (int i = x.size()-1; i > 0; i -= 1) {
            x.removeLast();
            int[] expected = new int[i];
            System.arraycopy(a, 0, expected, 0, i);
            int[] item = new int[i];
            for (int j = 0; j < i; j += 1) {
                item[j] = x.get(j);
            }
            assertArrayEquals(expected, item);
        }
    }
}
