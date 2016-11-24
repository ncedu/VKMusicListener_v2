package org.ncedu.service.impl;

import org.ncedu.dao.UserDAO;
import org.ncedu.entity.*;
import org.ncedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Transactional
    @Override
    public void addUser (Users user) {
        userDAO.addUser(user);
    }

    @Transactional
    @Override
    public Users getUserById(long id) {
        return userDAO.getUserById(id);
    }

    @Transactional
    @Override
    public void updateUser(Users user) {
        userDAO.updateUser(user);
    }

    @Transactional
    @Override
    public Users getUserByVk (String vk) {
        List list = userDAO.getUserByVk(vk);
        if (list.size() == 1) {
            return (Users) list.get(0);
        } else {
            return null;
        }
    }

}
