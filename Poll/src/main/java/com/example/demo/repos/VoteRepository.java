/*
 * Created on 24/03/2020 at 20:18:26 GMT+2
 */
package com.example.demo.repos;

import com.example.demo.model.User;
import com.example.demo.model.Vote;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer>{
    
    public Vote findByVoterid(User voterid);
    
    public List<Vote> findByCandidateid(User candidateid);
    
    @Query(value = "select COUNT(candidateid) from poll.vote where candidateid = ?1", nativeQuery = true)
    public int getNumberOfVotes(int id);
    
}
