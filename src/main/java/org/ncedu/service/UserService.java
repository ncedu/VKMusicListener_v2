package org.ncedu.service;


import org.ncedu.entity.Users;

public interface UserService {
    void addUser (Users user);
    Users getUserById (long id);
    void updateUser (Users user);
    Users getUserByVk (String vk);
}
