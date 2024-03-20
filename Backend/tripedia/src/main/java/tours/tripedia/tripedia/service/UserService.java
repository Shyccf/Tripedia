package tours.tripedia.tripedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tours.tripedia.tripedia.dao.UserDao;
import tours.tripedia.tripedia.model.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User addUser(User user) {
        if (user.getUserName().isEmpty() || user.getUserName() == null) {
            throw new RuntimeException("User name can not be empty!");
        }

        if (user.getPassword().isEmpty() || user.getPassword() == null) {
            throw new RuntimeException("User password can not be empty!");
        }

        Long currentUserId = userDao.findId(user.getUserName());

        if (currentUserId == null) {
            // 定义时间格式化对象和定义格式化样式
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            // 格式化时间对象
            user.setSignTime(dateFormat.format(new Date()));
            String encodedPassword = this.passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);

            return userDao.save(user);
        }
        else {
            throw new RuntimeException("User name already exists!");
        }
    }

    public User login(User user) {
        if (user.getUserName().isEmpty() || user.getUserName() == null) {
            throw new RuntimeException("User name can not be empty!");
        }

        if (user.getPassword().isEmpty() || user.getPassword() == null) {
            throw new RuntimeException("User password can not be empty!");
        }

        Long currentUserId = userDao.findId(user.getUserName());

        if (currentUserId == null) {
            throw new RuntimeException("User name does not exist!");
        }
        else {
            User currentUser = getUserById(currentUserId).orElse(null);

            if (currentUser != null && this.passwordEncoder.matches(user.getPassword(), currentUser.getPassword())) {
                return currentUser;
            }
            else {
                throw new RuntimeException("User password does not match!");
            }
        }

    }

    public List<User> getAllUser() {
        return (List<User>)userDao.findAll();
    }

    public Optional<User> getUserById(Long userId) {
        return userDao.findById(userId);
    }

    // ?
    public void deleteAllUser(User user) {
        userDao.deleteAll();
    }

    public void deleteUser(User user) {
        if (user.getUserId() == null) {
            throw new RuntimeException("User does not exist!");
        }
        userDao.delete(user);
    }

    public User updateUser(User user) {
        if (user.getUserId() == null || !userDao.existsById(user.getUserId())) {
            throw new RuntimeException("User does not exist!");
        }

        return userDao.save(user);
    }
}
