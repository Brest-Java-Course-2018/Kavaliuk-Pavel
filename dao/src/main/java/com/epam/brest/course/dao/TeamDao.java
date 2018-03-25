package com.epam.brest.course.dao;

import com.epam.brest.course.model.Team;

import java.util.Collection;

public interface TeamDao {

    /**
     * Gets collection of teams
     * @return teams
     */
    Collection<Team> getAllTeams();

    /**
     * Adds new team
     * @param team team to adding
     * @return added team
     */
    Team addTeam(Team team);

    /**
     * Deletes team by id
     * @param teamId required id
     */
    void deleteTeamById(Integer teamId);
}
