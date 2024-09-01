package flik;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class FilkTest {
    @Test
    public void test1(){
        boolean expected=true;
        boolean result=Flik.isSameNumber(100,100);
        assertEquals(expected,result);
    }
    @Test
    public void test2(){
        int j;
        for(int i=50;i<60;i++){
            j=i;
            assertTrue(Flik.isSameNumber(i,j));
        }
    }
    @Test
    public void test3(){
        int i=128;
        int j=128;
        assertTrue(Flik.isSameNumber(i,j));
    }
    @Test
    public void test4(){
     int i=128;
     int j=128;
     boolean result=Flik.isSameNumber(i,j);
     assertTrue("test fails",result);
    }
}
