package google;

import com.google.PalindromeFinder;
import junit.framework.TestCase;

public class PalindromeFinderTest extends TestCase {
    public void testIsFindPalindromeWithOddElements() {
        int[] a = new int[]{1, 4, 3, 4, 1};

        PalindromeFinder.Node node = new PalindromeFinder.Node(a[0]);
        PalindromeFinder.Node curr = node;
        PalindromeFinder.Node head = node;
        for (int i = 1; i < a.length; i++) {
            curr.next = new PalindromeFinder.Node(a[i]);
            curr = curr.next;
        }

        curr = head;

        while (curr != null) {
            if (curr.next == null)
                System.out.printf("%d", curr.value);
            else
                System.out.printf("%d -> ", curr.value);
            curr = curr.next;
        }

        boolean result = PalindromeFinder.findPalindrome(head);

        System.out.printf(" is %spalindrome.", result ? "" : "not ");
    }

    public void testIsFindPalindromeWithEvenElements() {
        int[] a = new int[]{1, 4, 4, 1};

        PalindromeFinder.Node node = new PalindromeFinder.Node(a[0]);
        PalindromeFinder.Node curr = node;
        PalindromeFinder.Node head = node;
        for (int i = 1; i < a.length; i++) {
            curr.next = new PalindromeFinder.Node(a[i]);
            curr = curr.next;
        }

        curr = head;

        while (curr != null) {
            if (curr.next == null)
                System.out.printf("%d", curr.value);
            else
                System.out.printf("%d -> ", curr.value);
            curr = curr.next;
        }

        boolean result = PalindromeFinder.findPalindrome(head);

        System.out.printf(" is %spalindrome.", result ? "" : "not ");
    }

    public void testIsNotFindPalindromeWithEvenElements() {
        int[] a = new int[]{1, 4};

        PalindromeFinder.Node node = new PalindromeFinder.Node(a[0]);
        PalindromeFinder.Node curr = node;
        PalindromeFinder.Node head = node;
        for (int i = 1; i < a.length; i++) {
            curr.next = new PalindromeFinder.Node(a[i]);
            curr = curr.next;
        }

        curr = head;

        while (curr != null) {
            if (curr.next == null)
                System.out.printf("%d", curr.value);
            else
                System.out.printf("%d -> ", curr.value);
            curr = curr.next;
        }

        boolean result = PalindromeFinder.findPalindrome(head);

        System.out.printf(" is %spalindrome.", result ? "" : "not ");
    }

    public void testIsNotFindPalindromeWithOddElements() {
        int[] a = new int[]{1, 4, 2};

        PalindromeFinder.Node node = new PalindromeFinder.Node(a[0]);
        PalindromeFinder.Node curr = node;
        PalindromeFinder.Node head = node;
        for (int i = 1; i < a.length; i++) {
            curr.next = new PalindromeFinder.Node(a[i]);
            curr = curr.next;
        }

        curr = head;

        while (curr != null) {
            if (curr.next == null)
                System.out.printf("%d", curr.value);
            else
                System.out.printf("%d -> ", curr.value);
            curr = curr.next;
        }

        boolean result = PalindromeFinder.findPalindrome(head);

        System.out.printf(" is %spalindrome.", result ? "" : "not ");
    }
}
