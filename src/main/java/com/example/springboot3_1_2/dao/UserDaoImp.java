package org.example.dao;

import org.example.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getUserList() {
        Query query = entityManager.createQuery("from User");
        return (List<User>) query.getResultList();
    }

    @Override
    public void removeUser(long id) {
        entityManager.remove(getUserFindById(id));
    }

    @Override
    public User getUserFindById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(long id, User user) {
        User editUser = getUserFindById(id);
        editUser.setName(user.getName());
        editUser.setSurname(user.getSurname());
        editUser.setAge(user.getAge());
        saveUser(editUser);
    }
}
