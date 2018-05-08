package com.epam.brest.course.service;

import com.epam.brest.course.dao.MeetingDao;
import com.epam.brest.course.model.Meeting;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;
import java.util.Collection;

public class MeetingServiceImpl implements MeetingService{

    private static final Logger LOGGER = LogManager.getLogger();

    private MeetingDao meetingDao;

    public MeetingServiceImpl(MeetingDao meetingDao) {
        this.meetingDao = meetingDao;
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
        return meetingDao.addMeeting(meeting);
    }

    /**
     * Gets all meetings
     * @return meeting's collection
     */
    @Override
    public Collection<Meeting> getAllMeetings() {

        LOGGER.debug("getAllMeetings()");
        return meetingDao.getAllMeetings();
    }

    /**
     * Deletes meeting with required id
     *
     * @param meetingId required meeting's id
     */
    @Override
    public void deleteMeeting(Integer meetingId) {

        LOGGER.debug("deleteMeeting()");
        meetingDao.deleteMeeting(meetingId);
    }

    /**
     * Returns meeting which exists between determined date interval
     *
     * @param firstDate  the first date in interval
     * @param secondDate the second date in interval
     * @return collection with matches which was in required date interval
     */
    @Override
    public Collection<Meeting> searchMeetingBetweenDates(Date firstDate, Date secondDate) {

        LOGGER.debug("searchMeetingBetweenDates({}, {})", firstDate, secondDate);
        return meetingDao.getMeetingsByDatesInterval(firstDate, secondDate);
    }
}
