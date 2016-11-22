import com.amazon.CoinChange;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * Created by kaibohao on 2016-11-16.
 */
public class CoinChangeTest extends TestCase {
    @Test
    public void testGetChange() {
        CoinChange coinChange = new CoinChange();
        long changes = coinChange.getChangeWays(10, new int[]{2, 5, 3, 6});
        assertEquals(5, changes);
    }

    @Test
    public void testGetChange2() {
        CoinChange coinChange = new CoinChange();
        long changes = coinChange.getChangeWays(4, new int[]{1, 2, 3});
        assertEquals(4, changes);
    }

    @Test
    public void testGetChange3() {
        CoinChange coinChange = new CoinChange();
        int coins[] = new int[]{25, 10, 11, 29, 49, 31, 33, 39, 12,
                36, 40, 22, 21, 16, 37, 8, 18, 4, 27, 17, 26, 32, 6, 38, 2, 30, 34};
        long changes = coinChange.getChangeWays(75, coins);
        assertEquals(16694, changes);
    }

    @Test
    public void testGetChange4() {
        long startTime = System.currentTimeMillis();
        CoinChange coinChange = new CoinChange();
        int coins[] = new int[]{5, 37, 8, 39, 33, 17, 22, 32, 13, 7, 10, 35, 40, 2, 43,
                49, 46, 19, 41, 1, 12, 11, 28};
        long changes = coinChange.getChangeWays(166, coins);
        assertEquals(96190959, changes);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(String.format("%d ms", totalTime));
    }

    @Test
    public void testGetChange5() {
        long startTime = System.currentTimeMillis();
        CoinChange coinChange = new CoinChange();
        int coins[] = new int[]{41, 34, 46, 9, 37, 32, 42, 21, 7, 13, 1, 24, 3, 43, 2, 23, 8, 45, 19, 30, 29, 18, 35, 11};
        long changes = coinChange.getChangeWays(250, coins);
        assertEquals(15685693751l, changes);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(String.format("%d ms", totalTime));
    }
}
