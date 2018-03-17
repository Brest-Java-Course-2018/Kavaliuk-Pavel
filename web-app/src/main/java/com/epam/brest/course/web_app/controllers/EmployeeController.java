package com.epam.brest.course.web_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Employee's controller
 */
@Controller
public class EmployeeController {
    /**
     * If exist /employees in address
     * @param model model of employees
     * @return employees page
     */
    @GetMapping(value = "employees")
    public String employees(Model model) {
        return "employees";
    }

    /**
     * If exist /employee in address
     * @param model model of employee
     * @return employee page
     */
    @GetMapping(value = "employee")
    public String employee(Model model) {
        return "employee";
    }
}
