/*
 * Created on 06/04/2020 at 04:52:04 GMT+2
 */
package com.example.demo.dtos;

public class VotingDto {

    private int userId;
    private int rating;

    public VotingDto() {
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
