package com.microservicesDemo.userservice.service;



import java.util.List;

import  com.microservicesDemo.userservice.entity.User;
public interface UserService {

    User saveUser(User user);

    List<User> fetchAllUsers();

    User getUserById(Long id);

    User updateUserById(Long id, User user);

    String deleteUserById(Long id);
}