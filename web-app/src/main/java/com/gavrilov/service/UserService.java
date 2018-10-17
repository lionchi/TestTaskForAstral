package com.gavrilov.service;

import com.gavrilov.model.User;

import java.util.List;

public interface UserService {
    User findById(Long id);

    List findAllUsers();

    void saveUser(User user);

    boolean checkUniqueLogin (String newLogin);
}
