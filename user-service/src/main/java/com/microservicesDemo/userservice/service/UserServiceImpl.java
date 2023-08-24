package com.microservicesDemo.userservice.service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicesDemo.userservice.repository.UserRepository;
import com.microservicesDemo.userservice.entity.User;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        logger.debug("Saving user");
        return userRepository.save(user);
    }

    @Override
    public List<User> fetchAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    @Override
    public User updateUserById(Long id, User updatedUser) {
        logger.debug("Updating User");
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            User originalUser = userOptional.get();

            // Update only the properties that are not null in the updatedUser
            if (updatedUser.getName() != null) {
                originalUser.setName(updatedUser.getName());
            }
            if (updatedUser.getEmail() != null) {
                originalUser.setEmail(updatedUser.getEmail());
            }
            // ... update other properties in a similar manner

            // Save the modified user back to the repository
            return userRepository.save(originalUser);
        }
        return null; // Or consider throwing an exception for better error handling
    }



    @Override
    public String deleteUserById(Long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            return "user deleted successfully";
        }
        return "No such user in the database";
    }

}