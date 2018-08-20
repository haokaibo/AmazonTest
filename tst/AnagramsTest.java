import com.amazon.Anagrams;
import junit.framework.TestCase;
import junit.framework.TestResult;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by kaibohao on 2016-10-18.
 */

public class AnagramsTest extends TestCase {

    private Anagrams anagrams;

    @Before
    public void initialize() {
        anagrams = new Anagrams();
    }

    @Test
    public void testNumberNeeded() {
        int result = Anagrams.numberNeeded("imkhnpqnhlvaxlmrsskbyyrhwfvgteubrelgubvdmrdmesfxkpykprunzpustowmvhupkqsyjxmnptkcilmzcinbzjwvxshubeln",
                "wfnfdassvfugqjfuruwrdumdmvxpbjcxorettxmpcivurcolxmeagsdundjronoehtyaskpwumqmpgzmtdmbvsykxhblxspgnpgfzydukvizbhlwmaajuytrhxeepvmcltjmroibjsdkbqjnqjwmhsfopjvehhiuctgthrxqjaclqnyjwxxfpdueorkvaspdnywupvmy");
        assertEquals(102, result);
    }

    @Test
    public void testA(){
        for(Character c : "abc".toCharArray()){
            System.out.println(c);
        }
    }

}
