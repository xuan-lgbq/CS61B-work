package timingtest;
import edu.princeton.cs.algs4.Stopwatch;
import net.sf.saxon.om.Item;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }
    public static void main(String[] args) {
        /** (int i = 0; i < 5; i++) {
            timeAListConstruction();
        }*/
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ns=new AList<>();
        AList<Double>  times=new AList<>();
        AList<Integer> opCounts=new AList<>();
        for (int i = 0; i <= 7; i += 1) {
            int N = (int)( 1000 * Math.pow(2, i));
           Ns.addLast(N);
           int recursionTimes=10;
           double time=0;
           for(int j=0;j<recursionTimes;j+=1) {
               AList<Integer> list = new AList<>();
               double startTime = System.nanoTime();
               while (list.size() < N) {
                   list.addLast(0);
               }
               double endTime = System.nanoTime();
               time += endTime - startTime;
           }
           time=time/recursionTimes;
            times.addLast((time)/1e9);
            opCounts.addLast(N);
        }
        printTimingTable( Ns,  times,  opCounts);
    }
}

//For the first the result is
/**
 *            N     time (s)        # ops  microsec/op
 * ------------------------------------------------------------
 *         1000         0.00         1000         0.89
 *         2000         0.00         2000         0.71
 *         4000         0.01         4000         1.35
 *         8000         0.01         8000         1.86
 *        16000         0.04        16000         2.70
 *        32000         0.16        32000         4.93
 *        64000         0.49        64000         7.72
 *       128000         2.10       128000        16.42
 However, for the multiply manipulation,the result turns to
 N     time (s)        # ops  microsec/op
 ------------------------------------------------------------
 1000         0.00         1000         0.24
 2000         0.00         2000         0.21
 4000         0.00         4000         0.16
 8000         0.00         8000         0.10
 16000         0.00        16000         0.09
 32000         0.00        32000         0.09
 64000         0.00        64000         0.03
 128000         0.01       128000         0.07
 */
