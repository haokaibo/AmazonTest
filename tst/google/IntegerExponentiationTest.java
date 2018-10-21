package google;

import com.google.IntegerExponentiation;
import junit.framework.TestCase;
import org.junit.Test;

public class IntegerExponentiationTest extends TestCase {
    @Test
    public void testPow(){
        IntegerExponentiation integerExponentiation = new IntegerExponentiation();
        int result = integerExponentiation.pow(3, 3);
        assertEquals(27, result);
    }
}
