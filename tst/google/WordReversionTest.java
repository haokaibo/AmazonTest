package google;

import com.google.WordReversion;
import junit.framework.TestCase;

public class WordReversionTest extends TestCase {
    public void testSimpleReverse(){
        String origin = "hello world here";
        String reversed = WordReversion.simpleReverse(origin);
        System.out.println(reversed);
    }
}
