package com.epam.brest.course.dao;

import com.epam.brest.course.model.Team;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class TeamDaoImpl implements TeamDao {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String TEAM_NAME = "team_name";
    private static final String TEAM_COUNTRY = "team_country";
    private static final String TEAM_ID = "team_id";

    @Value("${teams.getAllTeams}")
    private String getAllTeamsQuery;

    @Value("${teams.addNewTeam}")
    private String addNewTeamQuery;

    @Value("${teams.deleteTeamById}")
    private String deleteTeamQuery;

    @Value("${players.deletePlayersFromTeam}")
    private String deletePlayersFromTeamQuery;


    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public TeamDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    /**
     * Gets collection of teams
     *
     * @return teams
     */
    @Override
    public Collection<Team> getAllTeams() {

        LOGGER.debug("getAllTeams()");
//        Collection<Team> teams = namedParameterJdbcTemplate
//                .getJdbcOperations()
//                .query(getAllTeamsQuery, new TeamRowMapper());
        Collection<Team> teams = namedParameterJdbcTemplate.getJdbcOperations()
                .query(getAllTeamsQuery,
                        BeanPropertyRowMapper.newInstance(Team.class));
        return teams;
    }

    /**
     * Adds new team
     *
     * @param team team to adding
     * @return added team
     */
    @Override
    public Team addTeam(Team team) {

        LOGGER.debug("addTeam()", team);
        MapSqlParameterSource mapSqlParameterSource =
                new MapSqlParameterSource();
        mapSqlParameterSource.addValue(TEAM_NAME, team.getTeam_name());
        mapSqlParameterSource.addValue(TEAM_COUNTRY, team.getTeam_country());

        KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(addNewTeamQuery,
                mapSqlParameterSource, generatedKeyHolder);
        team.setTeam_id(generatedKeyHolder.getKey().intValue());
        return team;
    }

    /**
     * Deletes team by id
     *
     * @param teamId required id
     */
    @Override
    public void deleteTeamById(Integer teamId) {

        LOGGER.debug("deleteTeamById({})", teamId);
        namedParameterJdbcTemplate.getJdbcOperations().update(deletePlayersFromTeamQuery, teamId);
        namedParameterJdbcTemplate.getJdbcOperations().update(deleteTeamQuery, teamId);
    }
//
//    private class TeamRowMapper implements RowMapper<Team>{
//        @Override
//        public Team mapRow(ResultSet resultSet, int i) throws SQLException {
//
//            Team team = new Team();
//            team.setTeam_name(resultSet.getString(TEAM_NAME));
//            team.setTeam_country(resultSet.getString(TEAM_COUNTRY));
//            team.setTeam_id(resultSet.getInt(TEAM_ID));
//            return team;
//        }
//    }
}
