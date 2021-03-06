package com.epam.brest.course.service;

import com.epam.brest.course.model.Team;

import java.util.Collection;

public interface TeamService {

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

    /**
     * Updates required team
     * @param team team to update
     * @return updated team's instance
     */
    void updateTeam(Team team);

    /**
     * Gets team with required ID
     * @param teamId team's ID
     * @return required team
     */
    Team getTeamById(Integer teamId);
}
