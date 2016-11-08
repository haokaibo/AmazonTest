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
    public void testCheckBSTWhenDataIsFine() {
        int[] a = new int[31];
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 1;
        }
        Node root = Node.buildTreeByLevelAndValues(0, a.length - 1, a);

        assertTrue(root.checkBST(root));
    }

    @Test
    public void testCheckBSTWhenDataIsBad() {
        Node root = new Node(4,
                new Node(2, new Node(8), new Node(3)),
                new Node(6, new Node(5), new Node(7)));

        assertFalse(root.checkBST(root));
    }

    @Test
    public void testCheckBSTWhenDataIsBad2() {
        int[] a = new int[]{1, 2, 3, 5, 4, 6, 7};
        Node root = Node.buildTreeByLevelAndValues(0, a.length - 1, a);
        assertFalse(root.checkBST(root));
    }

    @Test
    public void testCheckBSTWhenDataIsBad3() {
        int[] a = new int[]{1, 2, 2, 4, 5, 6, 7};
        Node root = Node.buildTreeByLevelAndValues(0, a.length - 1, a);
        assertFalse(root.checkBST(root));
    }

    @Test
    public void testBuildTreeByLevelAndValues() {
        int[] a = new int[31];
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 1;
        }
        Node root = Node.buildTreeByLevelAndValues(0, a.length - 1, a);
        assertTrue(root.getData() == 16);
    }

}
