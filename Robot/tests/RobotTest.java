import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RobotTest {

    Robot buddy;

    @BeforeEach
    public void setUp() {
        buddy = new Robot("buddy");
    }

    @Test
    public void test_getName() {
        assertEquals("buddy", buddy.getName());
    }

    @Test
    public void test_getName_throwsIllegalArgumentExceptionWhenEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new Robot(""));
    }

    @Test
    public void test_getWorkingIsFalseOnCreation() {
        assertFalse(buddy.isWorking());
    }

    @Test
    public void test_turnOnSetsWorkingToTrue() {
        buddy.turnOn();
        assertTrue(buddy.isWorking());
    }

    @Test
    public void test_getWorkingMessageWhenInWorkingMode() {
        buddy.turnOn();
        assertEquals("I am in working mode!", buddy.getWorkingMessage());
    }

    @Test
    public void test_getWorkingMessage_throwsExceptionWhenNotInWorkingMode() {
        assertThrows(IllegalStateException.class, () -> buddy.getWorkingMessage());
    }
}