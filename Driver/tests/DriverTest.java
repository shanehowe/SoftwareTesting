import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class DriverTest {

    private Driver driver;

    @BeforeEach
    void setUp() {
        driver = new Driver("John Doe", 123456);
    }

    @Test
    void test_getDriverNum() {
        assertEquals(123456, driver.getDriverNum());
    }

    @Test
    void test_setDriverNum_throwsExceptionWhenLessThan100() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Driver("Text", 1)
        );
    }

    @Test
    void test_setDriverName_throwsExceptionWhenEmpty() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Driver("", 101)
        );
    }

    @Test
    void test_getDriverName() {
        assertEquals("John Doe", driver.getDriverName());
    }

    @Test
    void test_check_status() {
        assertFalse(driver.check_status());
    }

    @Test
    void test_waitTillBanned() {
        assertTimeout(Duration.ofMillis(1000), () -> driver.waitTillBanned());
    }
}