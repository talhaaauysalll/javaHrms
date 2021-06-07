package kodlamaio.javahrms.business.abstracts;

import kodlamaio.javahrms.core.entities.User;
import kodlamaio.javahrms.core.utilities.results.DataResult;

import java.util.List;

public interface UserService {
    List<User> findByEmail(String email);
}
