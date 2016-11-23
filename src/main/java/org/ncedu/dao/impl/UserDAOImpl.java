package org.ncedu.dao.impl;


import org.ncedu.dao.UserDAO;
import org.ncedu.entity.T;
import org.ncedu.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void addUser(Users user) {
        hibernateTemplate.save(user);
    }

    //@Override
    //public User getUser(Long id) {
   //     return null;
    //}

    @Override
    public void removeUser(Long id) {

    }

    public String hello (int id) {
        return "hello!";
    }
}
