import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {

    Robot buddy = new Robot("buddy");

    @Test
    public void test_getName() {
        assertEquals("buddy", buddy.getName());
    }

    @Test
    public void test_getWorkingIsFalseOnCreation() {
        assertFalse(buddy.isWorking());
    }
}