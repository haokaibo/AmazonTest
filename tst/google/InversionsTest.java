package google;

import com.google.Inversions;
import junit.framework.TestCase;
import org.junit.Test;

public class InversionsTest extends TestCase {
    @Test
    public void testCountInversions() {
        Inversions inversions = new Inversions();
        int[] arr = new int[]{5, 4, 3, 2, 1};
        int result = inversions.countInversions(arr);
        assertEquals(10, result);
    }
}
