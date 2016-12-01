import com.amazon.MergeSort2;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by kaibohao on 2016-11-30.
 */
public class MergeSort2Test extends TestCase {
    @Test
    public void testMergeSort21() {
        int arr[] = new int[]{3, 2, 1};
        int expected[] = new int[]{1, 2, 3};
        int swapTimes = MergeSort2.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            assertEquals(expected[i], arr[i]);
        }
        assertEquals(3, swapTimes);
    }

    @Test
    public void testMergeSort22() {
        int arr[] = new int[]{2, 1, 3, 1, 2};
        int expected[] = new int[]{1, 1, 2, 2, 3};
        int swapTimes = MergeSort2.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            assertEquals(expected[i], arr[i]);
        }
        assertEquals(4, swapTimes);
    }

    @Test
    public void testMergeSort23() {
        int n = 5;
        int arr[] = new int[n];
        int expected[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = n - i;
            expected[i] = i + 1;
        }

        int swapTimes = MergeSort2.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            assertEquals(expected[i], arr[i]);
        }
        assertEquals(10, swapTimes);
    }
}
