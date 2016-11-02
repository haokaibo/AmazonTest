import junit.framework.TestCase;
import junit.framework.TestResult;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import com.amazon.Node;

/**
 * Created by kaibohao on 2016-10-18.
 */

public class BinarySearchTreeTest extends TestCase {

    @Before
    public void initialize() {

    }

    @Test
    public void testCheckBST() {
        Node root = new Node(3,
                new Node(5, new Node(1), new Node(4)),
                new Node(2, new Node(6), null));

        assertFalse(Node.checkBST(root));
    }


}
