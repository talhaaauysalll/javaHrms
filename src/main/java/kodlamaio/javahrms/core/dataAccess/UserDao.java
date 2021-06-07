package kodlamaio.javahrms.core.dataAccess;

import kodlamaio.javahrms.core.entities.User;
import kodlamaio.javahrms.core.utilities.results.DataResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User,Integer> {
    List<User> findByEmail(String email);
}
