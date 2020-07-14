package com.example.demo.services;

import com.example.demo.model.Role;
import com.example.demo.repos.RoleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleServiceInterface{
    
    @Autowired
    RoleRepository roleRepository;
    @Override
    public List<Role> getAllRoles() {
        List<Role> allRoles = roleRepository.findAll();
        allRoles.remove(allRoles.get(2));
        return allRoles;
    }
    


}