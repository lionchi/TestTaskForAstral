package com.gavrilov.service;

import com.gavrilov.dao.UserDao;
import com.gavrilov.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    public User findById(Long id) {
        return dao.findById(id);
    }

    public List<User> findAllUsers() {
        return dao.getAllUser();
    }

    @Override
    public void saveUser(User user) {
        dao.create(user);
    }

    @Override
    public boolean checkUniqueLogin(String newLogin) {
        return dao.checkUniqueLogin(newLogin);
    }
}
