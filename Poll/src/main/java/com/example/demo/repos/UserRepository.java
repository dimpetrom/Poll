package com.example.demo.repos;

import com.example.demo.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByUsername(String username);

    @Query("SELECT u FROM User u where u.roleid.roleid=2")
    public List<User> getAllCandidates();

}
