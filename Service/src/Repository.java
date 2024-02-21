import java.sql.SQLException;
import java.util.List;

public class Repository {

    private final List<String> stuff;

    public Repository() {
        stuff = List.of("Hello", "world", "goodbye");
    }

    public List<String> getStuff() throws SQLException {
        return stuff;
    }
}
