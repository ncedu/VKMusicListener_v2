package org.ncedu.dao;


import org.ncedu.entity.T;
import org.ncedu.entity.Users;
import org.springframework.stereotype.Repository;


public interface UserDAO {

    public void addUser (Users user);

    //public User getUser(Long id);

    public void removeUser (Long id);

    public String hello (int id);
}
