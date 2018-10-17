package amazon;

import com.amazon.BreakUpString;
import junit.framework.TestCase;
import org.junit.Test;

public class BreakUpStringTest extends TestCase {

    @Test
    public void testBreakUp(){
        String[] words = BreakUpString.breakUp("the quick brown fox jumps over the lazy dog", 10);
        System.out.printf("words length = %d.\n", words.length);
        for (String word : words){
            System.out.println(word);
        }
    }
}
