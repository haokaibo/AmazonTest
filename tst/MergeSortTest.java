import com.amazon.MergeSort;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by kaibohao on 2016-11-29.
 */
public class MergeSortTest extends TestCase {
    @Test
    public void testMergeSort() {
        MergeSort mergeSort = new MergeSort();
        int[] array = new int[]{10, 9, 8, 1, 2, 3, 4, 7, 6, 5};
        int[] expectedArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        mergeSort.sort(array);
        for (int i = 0; i < array.length; i++) {
            assertEquals(expectedArray[i], array[i]);
        }
    }
}
