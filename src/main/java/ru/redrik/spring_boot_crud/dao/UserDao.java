package ru.redrik.spring_boot_crud.dao;


import ru.redrik.spring_boot_crud.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    void updateUser(Long id, User user);
    void deleteUser(Long id);
    User getUserById(Long id);
    List<User> getAllUsers();
}
