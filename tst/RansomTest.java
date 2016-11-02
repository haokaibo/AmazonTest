import com.amazon.RansomNote;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by kaibohao on 2016-10-18.
 */

public class RansomTest extends TestCase {

    private RansomNote ransomNote;

    @Before
    public void initialize() {
        ransomNote = new RansomNote();
    }

    @Test
    public void testNumberNeeded() {
        String magazine[] = new String[]{"a", "b", "c"};
        String ransom[] = new String[]{"a", "b"};
        assertTrue(RansomNote.isFromMagazine(magazine,ransom));
    }


}
