import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RobotParamTest {

    @ParameterizedTest
    @CsvSource({
            "25,  Too old",
            "10,  Age Ok",
            "20,  Age Ok",
            "21,  Too old",
            "19,  Age Ok"
    })
    void testCheckAge(int age, String expected) {
        Robot chuck = new Robot("Chuck", age);
        assertEquals(expected, chuck.checkAge());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "ParamTestFile.csv", numLinesToSkip = 1)
    void testCheckCost(int age, double expected) {
        Robot chuck = new Robot("chuck", age);
        assertEquals(expected, chuck.checkCost());
    }
}