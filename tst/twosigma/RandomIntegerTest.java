package twosigma;

import com.twosigma.RandomInteger;
import junit.framework.TestCase;
import org.junit.Test;

public class RandomIntegerTest extends TestCase {
    @Test
    public void testRand5() {
        for (int i = 0; i < 10; i++)
            System.out.printf("%d\t", RandomInteger.rand5());
        System.out.println();
    }

    @Test
    public void testRand7() {
        for (int i = 0; i < 10; i++)
            System.out.printf("%d\t", RandomInteger.rand7());
        System.out.println();
    }
}