package com.epam.brest.course.web_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *Controller of Department
 */
@Controller
public class DepartmentController {
    /**
     * If exist /departments in address
     * @param model model of departments
     * @return departments page
     */
    @GetMapping(value = "departments")
    public String departments(Model model) {
        return "departments";
    }

    /**
     * If exist /department in address
     * @param model model of department
     * @return department pagw
     */
    @GetMapping(value = "department")
    public String department(Model model) {
        return "department";
    }
}
