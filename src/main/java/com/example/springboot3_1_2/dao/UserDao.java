package org.example.dao;

import org.example.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {

    void saveUser(User user);
    List<User> getUserList();
    void removeUser(long id);
    User getUserFindById(long id);
    void updateUser(long id, User user);
}
