import com.amazon.BalancedBrackets;
import com.amazon.RansomNote;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by kaibohao on 2016-11-6.
 */
public class BalancedBracketsTest extends TestCase {

    private BalancedBrackets ransomNote;

    @Before
    public void initialize() {
        ransomNote = new BalancedBrackets();
    }

    @Test
    public void testNumberNeeded() {
        String[] expressions = new String[]{
                "}][}}(}][))]",
                "[](){()}",
                "()",
                "({}([][]))[]()",
                "{)[](}]}]}))}(())("
        };
        boolean[] expectedResults = new boolean[]{false, true, true, true, false};
        for(int i=0; i<expressions.length; i++){
            assertEquals(expectedResults[i], BalancedBrackets.isBalanced(expressions[i]));
        }
    }


}
