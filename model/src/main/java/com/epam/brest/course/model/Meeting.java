package com.epam.brest.course.model;

import java.sql.Date;

/**
 * Meeting instance
 */
public class Meeting {

    private Integer meeting_id;
    private Integer first_team;
    private Integer second_team;
    private Integer winner;
    private String score;
    private Date meeting_date;

    public Integer getWinner() {
        return winner;
    }

    public void setWinner(Integer winner) {
        this.winner = winner;
    }

    public Meeting(Integer meeting_id, Integer first_team, Integer second_team, Integer winner, String score, Date meeting_date) {
        this.meeting_id = meeting_id;
        this.first_team = first_team;
        this.second_team = second_team;
        this.winner = winner;
        this.score = score;
        this.meeting_date = meeting_date;
    }

    public String getScore() {
        return score;

    }

    public void setScore(String score) {
        this.score = score;
    }

//    public Meeting(Integer first_team, Integer second_team, Date meeting_date) {
//        this.first_team = first_team;
//        this.second_team = second_team;
//        this.meeting_date = meeting_date;
//    }

    public Date getMeeting_date() {
        return meeting_date;

    }

    public void setMeeting_date(Date meeting_date) {
        this.meeting_date = meeting_date;
    }

    public Integer getMeeting_id() {
        return meeting_id;
    }

    public void setMeeting_id(Integer meeting_id) {
        this.meeting_id = meeting_id;
    }

    public Integer getFirst_team() {
        return first_team;
    }

    public void setFirst_team(Integer first_team) {
        this.first_team = first_team;
    }

    public Integer getSecond_team() {
        return second_team;
    }

    public void setSecond_team(Integer second_team) {
        this.second_team = second_team;
    }

    public Meeting() {
    }
}
