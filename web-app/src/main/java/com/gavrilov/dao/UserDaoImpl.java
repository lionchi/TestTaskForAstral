package com.gavrilov.dao;

import com.gavrilov.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    @Override
    public List<User> getAllUser() {
        return entityManager.createQuery("select u from User as u", User.class).getResultList();
    }

    @Override
    public boolean checkUniqueLogin(String newLogin) {
        try {
            User user = entityManager.createQuery("select u from User as u where u.login = :newLogin", User.class)
                    .setParameter("newLogin", newLogin)
                    .getSingleResult();
            if (user != null) {
                return false;
            }
        } catch (NoResultException e) {
            return true;
        }
        return true;
    }
}
