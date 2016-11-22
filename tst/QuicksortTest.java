import com.amazon.QuickSort;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by kaibohao on 2016-11-22.
 */
public class QuicksortTest extends TestCase {
    @Test
    public void testSort() {
        int[] numbers = new int[]{4, 3, 2, 1};
        int[] expected = new int[]{1, 2, 3, 4};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            assertEquals(expected[i], numbers[i]);
        }
    }
}
