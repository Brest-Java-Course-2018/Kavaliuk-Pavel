package com.epam.brest.course.web_app.controllers;

import com.epam.brest.course.model.Employee;
import com.epam.brest.course.service.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * Employee's controller
 */
@Controller
public class EmployeeController {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    EmployeeService employeeService;

//    @Autowired
//    private DepartmentService departmentService;
    /**
     * If exist /employees in address
     * @param model model of employees
     * @return employees page
     */
    @GetMapping(value = "employees")
    public String employees(Model model) {
        LOGGER.debug("getEmployees()");
        Collection<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
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
