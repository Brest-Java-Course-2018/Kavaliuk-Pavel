package com.epam.brest.course.dao;

import com.epam.brest.course.model.Player;

import java.util.Collection;

public interface PlayerDao {

    /**
     * Gets all players
     * @return collection of players
     */
    Collection<Player> getAllPlayers();

    /**
     * Adds new player
     * @return instance of added player
     */
    Player addPlayer(Player player);

    /**
     * Deletes player by id
     * @param playerId required id
     */
    void deletePlayerById(Integer playerId);
}
