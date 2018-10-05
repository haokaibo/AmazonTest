package dropbox;

import com.dropbox.ConwayGame;
import com.sun.javaws.exceptions.InvalidArgumentException;
import junit.framework.TestCase;
import org.junit.Test;

public class ConwayGameTest extends TestCase {

    @Test
    public void testInitialization() throws InvalidArgumentException {
        ConwayGame conwayGame = new ConwayGame(5, 10);
        conwayGame.printCells();
    }
}
