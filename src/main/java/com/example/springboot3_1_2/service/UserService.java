package org.example.service;

import org.example.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    List<User> getUserList();
    void removeUser(long id);
    User getUserFindById(long id);
    void updateUser(long id, User user);
}
