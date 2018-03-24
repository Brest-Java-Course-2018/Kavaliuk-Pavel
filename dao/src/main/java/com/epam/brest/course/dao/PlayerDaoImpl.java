package com.epam.brest.course.dao;

import com.epam.brest.course.model.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class PlayerDaoImpl implements PlayerDao{

    private static final Logger LOGGER = LogManager.getLogger();

    private static final String PLAYER_ID = "player_id";
    private static final String PLAYER_NAME = "player_name";
    private static final String PLAYER_NUMBER = "player_number";
    private static final String PLAYER_AGE = "player_age";
    private static final String PLAYER_TEAM_ID = "player_team_id";
    private static final String PLAYER_COST = "player_cost";


    @Value("${players.addPlayerIntoTable}")
    private String addNewPlayerQuery;

    @Value("${players.getAllPlayersFromTable}")
    private String getAllPlayersQuery;

    /**
     * Allows use named parameters instead of "?"-symbol
     */
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public PlayerDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    /**
     * Gets all players
     *
     * @return collection of players
     */
    @Override
    public Collection<Player> getAllPlayers() {

        LOGGER.debug("getAllPlayers()");
        Collection<Player> players = namedParameterJdbcTemplate
                .getJdbcOperations()
                .query(getAllPlayersQuery, new PlayerRowMapper());
        return players;
    }

    /**
     * Adds new player
     *
     * @return instance of added player
     */
    @Override
    public Player addPlayer(Player player) {

        LOGGER.debug("addPlayer({})", player);

        MapSqlParameterSource namedParameter = new MapSqlParameterSource();
        namedParameter.addValue(PLAYER_NAME, player.getPlayerName());
        namedParameter.addValue(PLAYER_NUMBER, player.getPlayerNumber());
        namedParameter.addValue(PLAYER_AGE, player.getPlayerAge());
        namedParameter.addValue(PLAYER_COST, player.getPlayerCost());
        namedParameter.addValue(PLAYER_TEAM_ID, player.getPlayerTeamId());

        KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(addNewPlayerQuery, namedParameter,
                generatedKeyHolder);
        player.setPlayerId(generatedKeyHolder.getKey().intValue());
        return player;
    }

    /**
     * Deletes player by id
     *
     * @param playerId required id
     */
    @Override
    public void deletePlayerById(Integer playerId) {

    }

    /**
     * Class for mapping of parameters
     */
    private class PlayerRowMapper implements RowMapper<Player>{
        /**
         * Maps parameter on player's instance
         * @param resultSet instance which was given form table
         * @param i iterator
         * @return player's instance
         * @throws SQLException some sql-exception
         */
        @Override
        public Player mapRow(ResultSet resultSet, int i) throws SQLException {

            Player player = new Player();
            player.setPlayerTeamId(resultSet.getInt(PLAYER_ID));
            player.setPlayerName(resultSet.getString(PLAYER_NAME));
            player.setPlayerNumber(resultSet.getInt(PLAYER_NUMBER));
            player.setPlayerAge(resultSet.getInt(PLAYER_AGE));
            player.setPlayerTeamId(resultSet.getInt(PLAYER_TEAM_ID));
            player.setPlayerCost(resultSet.getInt(PLAYER_COST));
            return player;
        }
    }
}
