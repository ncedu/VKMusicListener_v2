package org.ncedu.dao;


import org.ncedu.entity.T;
import org.ncedu.entity.Users;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserDAO {
    public void addUser (Users user);

    public Users getUserById(Long id);

    public void removeUser (Long id);

    public void updateUser (Users user);

    public List<?> getUserByVk (String vk);
}
