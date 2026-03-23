package org.example.library.service;

import org.example.library.entity.User;
import org.example.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User login(String username, String password) {

        User user = repo.findByUsername(username);

        if(user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public void saveUser(User user) {
        repo.save(user);
    }
}