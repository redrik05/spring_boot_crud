package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceIm implements UserService {
    @Autowired
    private final UserDao ud;

    public UserServiceIm(UserDao ud) {
        this.ud = ud;
    }

    @Override
    public void addUser(User user) {
        ud.addUser(user);
    }

    @Override
    public void updateUser(Long id, User user) {
        ud.updateUser(id, user);
    }

    @Override
    public void deleteUser(Long id) {
        ud.deleteUser(id);
    }

    @Override
    public User getUserById(Long id) {
        return ud.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return ud.getAllUsers();
    }
}


