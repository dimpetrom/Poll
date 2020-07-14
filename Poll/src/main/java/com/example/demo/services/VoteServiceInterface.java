/*
 * Created on 24/03/2020 at 20:16:13 GMT+2
 */
package com.example.demo.services;

import com.example.demo.model.User;
import com.example.demo.model.Vote;
import java.util.List;

public interface VoteServiceInterface {
    
    public boolean hasVoted(User u);
    
    public List<Vote> getVotes(User u);
    
    public void insertVote(Vote v);
    
    public int getNumberOfVotes(int id);
}
