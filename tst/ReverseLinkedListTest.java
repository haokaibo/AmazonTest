import com.microsoft.ReverseLinkedList;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class ReverseLinkedListTest extends TestCase {


    @Before
    public void initialize() {
    }

    @Test
    public void testChangeOrder() {
        ReverseLinkedList.Node head = null;
        ReverseLinkedList.Node tail = null;
        for (int i = 0; i < 8; i++) {
            if (head == null) {
                head = new ReverseLinkedList.Node(i + 1);
                tail = head;
            } else {
                tail.next = new ReverseLinkedList.Node(i + 1);
                tail = tail.next;
            }
        }

        int k = 3;
        ReverseLinkedList.Node newHead = ReverseLinkedList.change(head, k);

        while (newHead != null) {
            System.out.print(newHead.value);
            System.out.print("\t");
            newHead = newHead.next;
        }
    }
}
