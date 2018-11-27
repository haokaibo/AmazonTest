package coursera;

import com.coursera.WordInGrid;
import junit.framework.TestCase;

public class WordInGridTest extends TestCase {

    public void testExistsWithTrueResult() {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";

        assertTrue(WordInGrid.exists(board,word));
    }

    public void testExistsWithTrueResult2() {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "SEE";

        assertTrue(WordInGrid.exists(board,word));
    }

    public void testExistsWithFalseResult() {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCB";

        assertFalse(WordInGrid.exists(board,word));
    }
}
