package google;

import com.google.UniqueNumberInArray;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class UniqueNumberInArrayTest extends TestCase {
    private UniqueNumberInArray uniqueNumberInArray;

    @Before
    public void initialize() {
        uniqueNumberInArray = new UniqueNumberInArray();
    }

    @Test
    public void testUniqueNumberWithHappyPath() {
        int[] arr = new int[]{6, 1, 3, 3, 3, 6, 6};
        int result = UniqueNumberInArray.findUniqueNumber(arr);
        assertEquals(1, result);
    }


}
