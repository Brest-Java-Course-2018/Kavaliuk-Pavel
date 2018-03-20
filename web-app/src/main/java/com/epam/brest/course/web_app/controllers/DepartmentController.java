package com.epam.brest.course.web_app.controllers;

import com.epam.brest.course.dto.DepartmentDTO;
import com.epam.brest.course.model.Department;
import com.epam.brest.course.service.DepartmentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Collection;

/**
 *Controller of Department
 */
@Controller
public class DepartmentController {

    private static final Logger LOGGER = LogManager.getLogger();


    @Autowired
    DepartmentService departmentService;
    /**
     * If exist /departments in address
     * @param model model of departments
     * @return departments page
     */
    @GetMapping(value = "departments")
    public String getDepartments(Model model) {
        Collection<DepartmentDTO> departments = departmentService.getDepartmentDTOs();

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
        model.addAttribute("isNew", false);

        return "department";
    }

    /**
     * Add
     * @param department department's to add
     * @param result report about errors
     * @return departments if OK or
     * department is something wrong
     */
    @PostMapping(value = "/department")
    public String addDepartment(@Valid Department department,
                                   BindingResult result) {

        LOGGER.debug("addDepartment({}, {})", department, result);
        if (result.hasErrors()) {
            return "department";
        } else {
            this.departmentService.addDepartment(department);
            return "redirect:/departments";
        }
    }

    /**
     *
     * @param model m
     * @return k
     */
    @GetMapping(value = "/department")
    public final String gotoAddDepartmentPage(Model model) {
        LOGGER.debug("addDepartment({})", model);
        Department department = new Department();
        model.addAttribute("isNew", true);
        model.addAttribute("department", department);
        return "department";
    }

    /**
     * If exist /department in address
     * @param department instance for adding
     * @return view
     */
    @PostMapping(value = "/department/{id}")
    public String updateDepartment(@Valid Department department,
                                   BindingResult result) {

        LOGGER.debug("updateDepartment({}, {})", department, result);
        if (result.hasErrors()) {
            return "department";
        } else {
            this.departmentService.updateDepartment(department);
            return "redirect:/departments";
        }
    }

    /**
     * Delete department.
     *
     * @return view name
     */
    @GetMapping(value = "/department/{id}/delete")
    public final String deleteDepartmentById(@PathVariable Integer id, Model model) {
        LOGGER.debug("deleteDepartmentById({},{})", id, model);
        departmentService.deleteDepartmentById(id);
        return "redirect:/departments";
    }


}
