package com.gavrilov.service;

import com.gavrilov.model.User;

import java.util.List;

public interface UserService {
    User findById (Long id);
    List<User> findAllUsers ();
}
