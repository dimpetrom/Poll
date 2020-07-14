package com.example.demo.services;

import com.example.demo.model.User;
import java.util.List;

public interface UserServiceInterface {

    public void insertUser(User u);

    public User getUserByUsername(String name);

    public List<User> getAllCandidates();
    
    public User getUser(int userid);
    
    public List<User> getAllUsers();

}
