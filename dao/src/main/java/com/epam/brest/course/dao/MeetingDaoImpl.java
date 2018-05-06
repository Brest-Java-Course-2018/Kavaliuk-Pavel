package com.epam.brest.course.dao;

import com.epam.brest.course.model.Meeting;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Date;
import java.util.Collection;

public class MeetingDaoImpl implements MeetingDao {

    private static final Logger LOGGER = LogManager.getLogger();

    @Value("${meetings.getAllMeetings}")
    private String getAllMeetingsQuery;

    @Value("${meetings.addNewMeeting}")
    private String addNewMeetingQuery;

    @Value("${meetings.deleteMeeting}")
    private String deleteMeetingQuery;

    @Value("${meetings.searchBetweenDates}")
    private String getMeetingsBetweenDatesQuery;

    private static final String WINNER = "winner";
    private static final String SCORE = "score";
    private static final String FIRST_TEAM = "first_team";
    private static final String SECOND_TEAM = "second_team";
    private static final String MEETING_DATE = "meeting_date";
    private static final String FIRST_DATE = "firstDate";
    private static final String SECOND_DATE = "secondDate";

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public MeetingDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate){
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    /**
     * Deletes meeting with required id
     * @param meetingId required meeting's id
     */
    @Override
    public void deleteMeeting(Integer meetingId) {

        LOGGER.debug("deleteMeeting({})", meetingId);

        namedParameterJdbcTemplate.getJdbcOperations()
                .update(deleteMeetingQuery, meetingId);
    }

    /**
     * Adds new meeting into DB
     *
     * @param meeting meeting to add
     * @return added meeting
     */
    @Override
    public Meeting addMeeting(Meeting meeting) {

        LOGGER.debug("addMeeting({})", meeting);

        MapSqlParameterSource namedParameter = new MapSqlParameterSource();
        namedParameter.addValue(FIRST_TEAM, meeting.getFirst_team());
        namedParameter.addValue(SECOND_TEAM, meeting.getSecond_team());
        namedParameter.addValue(MEETING_DATE, meeting.getMeeting_date());
        namedParameter.addValue(WINNER, meeting.getWinner());
        namedParameter.addValue(SCORE, meeting.getScore());

        KeyHolder generatedKeyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(addNewMeetingQuery, namedParameter,
                generatedKeyHolder);
        meeting.setMeeting_id(generatedKeyHolder.getKey().intValue());
        return meeting;
    }

    /**
     * Gets all meetings
     * @return meeting's collection
     */
    @Override
    public Collection<Meeting> getAllMeetings() {

        LOGGER.debug("getAllMeetings()");

        Collection<Meeting> meetings =
                namedParameterJdbcTemplate.getJdbcOperations()
                        .query(getAllMeetingsQuery,
                                BeanPropertyRowMapper
                                        .newInstance(Meeting.class));
        return meetings;
    }

    /**
     * Returns meeting which exists between determined date interval
     *
     * @param firstDate  the first date in interval
     * @param secondDate the second date in interval
     * @return collection with matches which was in required date interval
     */
    @Override
    public Collection<Meeting> getMeetingsByDatesInterval(Date firstDate, Date secondDate) {

        LOGGER.debug("getMeetingsByDatesInterval({},{})", firstDate, secondDate);

        MapSqlParameterSource namedParameter = new MapSqlParameterSource();
        namedParameter.addValue(FIRST_DATE, firstDate);
        namedParameter.addValue(SECOND_DATE, secondDate);

        Collection<Meeting> players = namedParameterJdbcTemplate
                .query(getMeetingsBetweenDatesQuery, namedParameter,
                        BeanPropertyRowMapper.newInstance(Meeting.class));
        return players;
    }
}
