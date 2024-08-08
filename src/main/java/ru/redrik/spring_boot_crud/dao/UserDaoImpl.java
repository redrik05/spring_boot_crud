package ru.redrik.spring_boot_crud.dao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.redrik.spring_boot_crud.model.User;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public void updateUser(Long id, User user) {
        User userToUpdate = em.find(User.class, id);
        em.detach(userToUpdate);
        userToUpdate.setName(user.getName());
        userToUpdate.setLastName(user.getLastName());
        em.merge(userToUpdate);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = em.find(User.class, userId);
        if (user != null) {
            em.remove(user);
        }
    }

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public User getUserById(Long id) {
        return em.find(User.class, id);
    }
}
