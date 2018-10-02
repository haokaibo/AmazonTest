package google;

import com.google.SumSubsetToK;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class SumSubsetToKTest extends TestCase {
    private SumSubsetToK sumSubsetToK;

    @Before
    public void initialize() {
        sumSubsetToK = new SumSubsetToK();
    }

    @Test
    public void testGetSubsetSumToK() {
        int[] s = new int[]{12, 1, 61, 5, 9, 2};
        int k = 24;
        if (sumSubsetToK==null)
            this.initialize();
        List<Integer> result = sumSubsetToK.getSubsetSumToK(s, k);
        for (Integer i : result){
            System.out.printf("%d\t", i);
        }
    }

}
