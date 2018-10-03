package amazon;

import com.amazon.MaxStack;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class MaxStackTest extends TestCase {
    private MaxStack maxStack;


    @Test
    public void testMax() {
        maxStack = new MaxStack();
        maxStack.push(4);
        assertEquals(Integer.valueOf(4), maxStack.max());
        maxStack.push(2);
        assertEquals(Integer.valueOf(4), maxStack.max());
        maxStack.push(14);
        assertEquals(Integer.valueOf(14), maxStack.max());
        maxStack.push(1);
        assertEquals(Integer.valueOf(14), maxStack.max());
        maxStack.push(18);
        assertEquals(Integer.valueOf(18), maxStack.max());
        maxStack.pop();
        assertEquals(Integer.valueOf(14), maxStack.max());
    }
}
