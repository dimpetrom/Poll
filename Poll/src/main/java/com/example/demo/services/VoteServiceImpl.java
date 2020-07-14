/*
 * Created on 24/03/2020 at 20:16:24 GMT+2
 */
package com.example.demo.services;

import com.example.demo.model.User;
import com.example.demo.model.Vote;
import com.example.demo.repos.VoteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImpl implements VoteServiceInterface {

    @Autowired
    VoteRepository voteRepository;

    @Override
    public boolean hasVoted(User u) {
        Vote v = voteRepository.findByVoterid(u);
        if (v == null) {
            return false;
        }
        return true;
    }

    @Override
    public List<Vote> getVotes(User u) {
        List<Vote> votes = voteRepository.findByCandidateid(u);
        return votes;
    }

    @Override
    public void insertVote(Vote v) {
        voteRepository.save(v);
    }

    @Override
    public int getNumberOfVotes(int id) {
        return voteRepository.getNumberOfVotes(id);
    }

}
