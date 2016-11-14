import com.amazon.MaxIntHeap;
import com.amazon.MinIntHeap;
import com.amazon.RansomNote;
import com.amazon.RunningMedian;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by kaibohao on 2016-11-12.
 */
public class RunningMedianTest extends TestCase {

    private RunningMedian runningMedian;

    @Before
    public void initialize() {
    }

    @Test
    public void testRunningMedianSuccessfully() {
        int[] a = new int[]{12, 4, 5, 3, 8, 7};
        RunningMedian runningMedian = new RunningMedian();
        double[] results = new double[]{12.0, 8.0, 5.0, 4.5, 5.0, 6.0};
        for (int i = 0; i < a.length; i++) {
            assertEquals(results[i], runningMedian.getMedian(a[i]));
        }
    }

    @Test
    public void testRunningMedianSuccessfully2() {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        RunningMedian runningMedian = new RunningMedian();
        double[] results = new double[]{1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5, 5.0, 5.5};
        for (int i = 0; i < a.length; i++) {
            assertEquals(results[i], runningMedian.getMedian(a[i]));
        }
    }


}
