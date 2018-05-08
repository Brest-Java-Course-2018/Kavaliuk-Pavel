package com.epam.brest.course.rest;


import com.epam.brest.course.dao.MeetingDao;
import com.epam.brest.course.model.Meeting;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collection;

public class MeetingRestController {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private MeetingDao meetingDao;

    @GetMapping(value = "/meetings")
    @ResponseStatus(HttpStatus.OK)
    Collection<Meeting> getAllMeetings(){

        LOGGER.debug("getAllMeetingsREST()");
        return meetingDao.getAllMeetings();
    }
}
