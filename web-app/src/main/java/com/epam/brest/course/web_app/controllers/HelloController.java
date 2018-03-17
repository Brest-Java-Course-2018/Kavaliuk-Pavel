package com.epam.brest.course.web_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Starts controller
 */
@Controller
public class HelloController {
    /**
     * If exist / in address
     * @return make redirect to departments page
     */
    @GetMapping(value = "/")
    public String defaultPageRedirect() {
        return "redirect:departments";
    }
}
