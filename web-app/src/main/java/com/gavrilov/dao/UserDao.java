package com.gavrilov.dao;

import com.gavrilov.model.User;

import java.util.List;

public interface UserDao {
    User findById (Long id);
    List<User> getAllUser();
    void create (User user);
    boolean checkUniqueLogin (String newLogin);
}
