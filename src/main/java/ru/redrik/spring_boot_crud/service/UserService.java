package ru.redrik.spring_boot_crud.service;

import ru.redrik.spring_boot_crud.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    void updateUser(Long id, User user);

    void deleteUser(Long id);

    User getUserById(Long id);

    List<User> getAllUsers();
}
