package com.epam.brest.course.model;

public class Player {

    private Integer player_id;

    private Integer player_number;

    private String player_name;

    private Integer player_age;

    private Integer player_cost;

    private Integer player_team_id;

    public Player(Integer player_id, Integer player_number,
                  String player_name, Integer player_age,
                  Integer player_cost, Integer player_team_id) {

        this.player_id = player_id;
        this.player_number = player_number;
        this.player_name = player_name;
        this.player_age = player_age;
        this.player_cost = player_cost;
        this.player_team_id = player_team_id;
    }

    public Player() {

    }

    public Integer getPlayer_id() {

        return player_id;
    }

    public void setPlayerId(Integer player_id) {
        this.player_id = player_id;
    }

    public Integer getPlayerNumber() {
        return player_number;
    }

    public void setPlayerNumber(Integer player_number) {
        this.player_number = player_number;
    }

    public String getPlayerName() {
        return player_name;
    }

    public void setPlayerName(String player_name) {
        this.player_name = player_name;
    }

    public Integer getPlayerAge() {
        return player_age;
    }

    public void setPlayerAge(Integer player_age) {
        this.player_age = player_age;
    }

    public Integer getPlayerCost() {
        return player_cost;
    }

    public void setPlayerCost(Integer player_cost) {
        this.player_cost = player_cost;
    }

    public Integer getPlayerTeamId() {
        return player_team_id;
    }

    public void setPlayerTeamId(Integer player_team_id) {
        this.player_team_id = player_team_id;
    }
}
