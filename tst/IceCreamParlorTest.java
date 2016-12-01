import com.amazon.IceCreamParlor;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by kaibohao on 2016-12-1.
 */
public class IceCreamParlorTest extends TestCase {
    @Test
    public void testGetIceCreamFlavors() {
        int dollar = 4;
        int[] costs = new int[]{1, 4, 5, 3, 2};
        int[] flavors = IceCreamParlor.getIceCreamFlavors(dollar, costs);
        assertNotNull(flavors);
        int[] expected = new int[]{1, 4};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], flavors[i]);
        }
    }

    @Test
    public void testGetIceCreamFlavors2() {
        int dollar = 4;
        int[] costs = new int[]{2, 2, 4, 3};
        int[] flavors = IceCreamParlor.getIceCreamFlavors(dollar, costs);
        assertNotNull(flavors);
        int[] expected = new int[]{1, 2};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], flavors[i]);
        }
    }
}
