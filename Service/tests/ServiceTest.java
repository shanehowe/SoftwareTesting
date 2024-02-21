import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ServiceTest {

    @Mock
    Repository repository;

    @InjectMocks
    Service service;

    @Test
    void getStuffWithLengthLessThanFive() {
        try {
            Mockito
                    .when(repository.getStuff())
                    .thenReturn(List.of("A", "B", "ABCDEFG"));
        } catch (SQLException e) {
            // do nothing
        }
        List<String> stuff = service.getStuffWithLengthLessThan(5);

        assertNotNull(stuff);
        assertEquals(2, stuff.size());
    }

    @Test
    void getStuffLengthLessThanFiveWithException() {
        try {
            Mockito
                    .when(repository.getStuff())
                    .thenThrow(SQLException.class);
        } catch (SQLException e) {
            // do nothing
        }

        List<String> stuff = service.getStuffWithLengthLessThan(5);
        assertNotNull(stuff);
        assertTrue(stuff.isEmpty());
    }

    @Test
    void getStuffWithLengthThrowsIllegalArgumentException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> service.getStuffWithLengthLessThan(-1)
        );
    }
}