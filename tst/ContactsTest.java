import com.amazon.Anagrams;
import com.amazon.Contacts;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by kaibohao on 2016-11-11.
 */
public class ContactsTest extends TestCase {

    private Contacts contacts;

    @Before
    public void initialize() {

    }

    @Test
    public void testAddContactSuccessfully() {
        Contacts contacts = new Contacts();
        String[] words = new String[]{"CAR", "CARD", "CARDS", "COTS", "TRIE", "TRIED"};
        for (String w : words) {
            contacts.addContact(w);
        }
        int contactCount = contacts.findContacts("CAR");
        assertEquals(3, contactCount);

    }

    @Test
    public void testAddContactSuccessfully2() {
        Contacts contacts = new Contacts();
        String[] words = new String[]{"s", "ss", "sss", "ssss", "sssss"};
        for (String w : words) {
            contacts.addContact(w);
        }
        String[] expectedStrings = new String[]{"s", "ss", "sss", "ssss", "sssss"};
        int[] expectedCount = new int[]{5, 4, 3, 2, 1, 0};
        for (int i = 0; i < expectedStrings.length; i++) {
            int contactCount = contacts.findContacts(expectedStrings[i]);
            assertEquals(expectedCount[i], contactCount);
        }
    }


}
