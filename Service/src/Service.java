import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Service {

    private final Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public List<String> getStuffWithLengthLessThan(int length) {
        if (length < 0) {
            throw new IllegalArgumentException();
        }

        try {
            return repository.getStuff()
                    .stream()
                    .filter(item -> item.length() < length)
                    .toList();
        } catch (SQLException e) {
            return new ArrayList<>();
        }
    }
}
