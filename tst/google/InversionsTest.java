package google;

import com.google.Inversions;
import junit.framework.TestCase;
import org.junit.Test;

public class InversionsTest extends TestCase {
    @Test
    public void testCountInversions() {
        int[] arr = new int[]{5, 4, 3, 2, 1};
        int result = Inversions.mergeSort(arr, arr.length);
        assertEquals(10, result);
    }
}
