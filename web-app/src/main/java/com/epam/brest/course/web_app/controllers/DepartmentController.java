package com.epam.brest.course.web_app.controllers;

import com.epam.brest.course.model.Department;
import com.epam.brest.course.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.Collections;

/**
 *Controller of Department
 */
@Controller
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;
    /**
     * If exist /departments in address
     * @param model model of departments
     * @return departments page
     */
    @GetMapping(value = "departments")
    public String getDepartments(Model model) {
        Collection<Department> departments = departmentService.getDepartment();
                //Collections.emptyList();

        model.addAttribute("departments", departments);
        return "departments";
    }

    /**
     * If exist /department in address
     * @param model model of department
     * @return view
     */
    @GetMapping(value = "/department/{id}")
    public String getDepartmentById(@PathVariable Integer id, Model model) {

        Department department = departmentService.getDepartmentById(id);

        model.addAttribute("department", department);
        return "department";
    }
}
