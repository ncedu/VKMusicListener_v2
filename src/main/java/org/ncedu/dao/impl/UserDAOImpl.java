package org.ncedu.dao.impl;


import org.ncedu.dao.UserDAO;
import org.ncedu.entity.T;
import org.ncedu.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void addUser(Users user) {
        hibernateTemplate.save(user);
    }

    @Override
    public Users getUserById(Long id) {
        return (Users) hibernateTemplate.get(Users.class, id);
    }

    @Override
    public List<?> getUserByVk (String vk) {
        return hibernateTemplate.find("FROM org.ncedu.entity.Users WHERE VK_ID=" + vk);
    }
    @Override
    public void updateUser(Users user) {
        hibernateTemplate.update(user);
    }

    @Override
    public void removeUser(Long id) {

    }
}
