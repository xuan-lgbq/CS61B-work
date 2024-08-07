package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */

public class TestBuggyAList {
  // YOUR TESTS HERE
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
    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> M=new BuggyAList<>();

        int N = 500;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                M.addLast(randVal);
                assertEquals(M.getLast(),L.getLast());
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int sizeAList = L.size();
                int sizeBuggyAList=M.size();
                assertEquals(sizeAList,sizeBuggyAList);
                System.out.println("size: " + sizeAList);
            }
            else if(operationNumber==2){
                if(L.size()>0 && M.size()>0){
                    L.removeLast();
                    M.removeLast();
                    int [] a=new int [M.size()];
                    int [] b=new int [L.size()];
                    for(int j=0;j<M.size();j+=1){
                        a[j]=M.get(j);
                    }
                    for(int c=0;c<L.size();c+=1){
                        b[c]=L.get(c);
                    }
                    assertArrayEquals(a,b);
                }
            }
        }
    }
}
