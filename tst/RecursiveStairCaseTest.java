import com.amazon.RecursiveStaircase;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by kaibohao on 2016-12-1.
 */
public class RecursiveStairCaseTest extends TestCase {
    @Test
    public void testCheckClimbWay() {
        int n = 3;
        int ways = RecursiveStaircase.checkClimbWay(n);
        assertEquals(4, ways);
    }

    @Test
    public void testCheckClimbWay2() {
        int n = 5;
        int ways = RecursiveStaircase.checkClimbWay(n);
        assertEquals(14, ways);
    }

    @Test
    public void testCheckClimbWay3() {
        int n = 10;
        int ways = RecursiveStaircase.checkClimbWay(n);
        assertEquals(274, ways);
    }

    @Test
    public void testCheckClimbWay21() {
        int n = 3;
        int[][] memo = new int[n + 1][n + 1];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                memo[i][j] = -1;
            }
        }
        int ways = RecursiveStaircase.checkClimbWay2(n, n, memo);
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                System.out.format("%d ", memo[i][j]);
            }
            System.out.println();
        }
        assertEquals(4, ways);
    }

}
