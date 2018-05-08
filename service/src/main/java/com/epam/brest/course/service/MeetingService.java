package com.epam.brest.course.service;

import com.epam.brest.course.model.Meeting;

import java.sql.Date;
import java.util.Collection;

public interface MeetingService {

    /**
     * Adds new meeting into DB
     * @param meeting meeting to add
     * @return added meeting
     */
    Meeting addMeeting(Meeting meeting);

    /**
     * Gets all meetings
     * @return meeting's collection
     */
    Collection<Meeting> getAllMeetings();

    /**
     * Deletes meeting with required id
     * @param meetingId required meeting's id
     */
    void deleteMeeting(Integer meetingId);

    /**
     * Returns meeting which exists between determined date interval
     *
     * @param firstDate  the first date in interval
     * @param secondDate the second date in interval
     * @return collection with matches which was in required date interval
     */
    Collection<Meeting> searchMeetingBetweenDates(Date firstDate, Date secondDate);
}
