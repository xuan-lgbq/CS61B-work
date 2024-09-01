package flik;

/** An Integer tester created by Flik Enterprises.
 * @author Josh Hug
 * */
public class Flik {
    /** @param a Value 1
     *  @param b Value 2
     *  @return Whether a and b are the same */
    public static boolean isSameNumber(Integer a, Integer b) {
        return a.equals(b) ;
    }
    //For the type of Integer, "==" will determine their reference (address) rather than the value, however, for the integer from -127 to 128, this values will be saved temporary,therefore the result shows true.
    //We can also fix it by following steps
    /*public static boolean isSameNumber(int a, int b) {
        return a==b ;
    }*/
}
