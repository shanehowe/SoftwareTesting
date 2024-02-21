import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RobotTest {

    Robot buddy;

    @BeforeAll
    void beforeAll() {
        buddy = new Robot("buddy", 20);
        System.out.println("Before test suite");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("Before each test case");
        buddy.turnOff();
    }

    @Test
    @Order(2)
    @DisplayName("Hello World")
    public void testGetName() {
        assertEquals("buddy", buddy.getName());
    }

    @Test
    public void testGetNameThrowsIllegalArgumentExceptionWhenEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new Robot("", 20));
    }

    @Test
    public void testGetWorkingIsFalseOnCreation() {
        assertFalse(buddy.isWorking());
    }

    @Test
    public void testTurnOnSetsWorkingToTrue() {
        buddy.turnOn();
        assertTrue(buddy.isWorking());
    }

    @Test
    public void testGetWorkingMessageWhenInWorkingMode() {
        buddy.turnOn();
        assertEquals("I am in working mode!", buddy.getWorkingMessage());
    }

    @Test
    @Order(1)
    public void testGetWorkingMessageThrowsExceptionWhenNotInWorkingMode() {
        assertThrows(IllegalStateException.class, () -> buddy.getWorkingMessage());
    }

}