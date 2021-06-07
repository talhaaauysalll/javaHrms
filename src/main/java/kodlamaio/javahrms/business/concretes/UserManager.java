package kodlamaio.javahrms.business.concretes;

import kodlamaio.javahrms.business.abstracts.UserService;
import kodlamaio.javahrms.core.dataAccess.UserDao;
import kodlamaio.javahrms.core.entities.User;
import kodlamaio.javahrms.core.utilities.results.DataResult;
import kodlamaio.javahrms.core.utilities.results.ErrorDataResult;
import kodlamaio.javahrms.core.utilities.results.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findByEmail(String email) {
        return this.userDao.findByEmail(email);
    }
}
