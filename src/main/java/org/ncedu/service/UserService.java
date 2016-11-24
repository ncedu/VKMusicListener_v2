package org.ncedu.service;


import org.ncedu.entity.Users;

public interface UserService {
    public void addUser (Users user);
    public Users getUserById (long id);
    public void updateUser (Users user);
    public Users getUserByVk (String vk);
}
