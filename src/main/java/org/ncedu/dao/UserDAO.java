package org.ncedu.dao;


import org.ncedu.entity.T;
import org.ncedu.entity.Users;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserDAO {
    void addUser (Users user);
    Users getUserById(Long id);
    void removeUser (Long id);
    void updateUser (Users user);
    List<?> getUserByVk (String vk);
}
