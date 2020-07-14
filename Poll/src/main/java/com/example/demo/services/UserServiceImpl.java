package com.example.demo.services;

import com.example.demo.model.User;
import com.example.demo.repos.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    UserRepository userRepository;

    @Override
    public void insertUser(User u) {
        userRepository.save(u);
    }

    @Override
    public User getUserByUsername(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public List<User> getAllCandidates() {
        return userRepository.getAllCandidates();
    }

    @Override
    public User getUser(int userid) {
        return userRepository.getOne(userid);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
}
