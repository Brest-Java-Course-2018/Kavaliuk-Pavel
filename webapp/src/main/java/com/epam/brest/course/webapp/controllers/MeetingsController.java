package com.epam.brest.course.webapp.controllers;

import com.epam.brest.course.model.Meeting;
import com.epam.brest.course.service.MeetingService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class MeetingsController {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    MeetingService meetingService;

    @GetMapping(value = "meetings")
    public String getMeetings(Model model){

        LOGGER.debug("getMeetingControllerWeb");
        Collection<Meeting> meetings = meetingService.getAllMeetings();
        model.addAttribute("meetings", meetings);
        return "meetings";
    }
}
