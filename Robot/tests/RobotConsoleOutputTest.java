import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class RobotConsoleOutputTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @BeforeEach /* for console output testing */
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void testAgeOkMsg() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Robot buddy = new Robot("buddy", 15);
        buddy.sendAgeMsg();
        baos.flush();
        String whatWasPrinted = baos.toString();
        String[] linesOfOutput = whatWasPrinted.split(
                System.lineSeparator()
        );
        assertEquals("Age ok", linesOfOutput[0]);
    }

    @Test
    public void testAgeNotOkMsg() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Robot buddy = new Robot("buddy", 27);
        buddy.sendAgeMsg();
        baos.flush();
        String whatWasPrinted = new String(baos.toByteArray());
        String[] linesOfOutput = whatWasPrinted.split(System.lineSeparator());
        assertEquals("Error Age too old", linesOfOutput[0]);
    }

    @AfterEach
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }
}