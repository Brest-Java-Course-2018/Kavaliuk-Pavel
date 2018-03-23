package com.epam.brest.course.rest;

import com.epam.brest.course.dto.DepartmentDTO;
import com.epam.brest.course.model.Department;
import com.epam.brest.course.service.DepartmentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 *
 */
@RestController
public class DepartmentRestController {

    private  static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private DepartmentService departmentService;

    @GetMapping(value = "/departments")
    Collection<DepartmentDTO> departments(){

        LOGGER.debug("departments()");
        return departmentService.getDepartmentDTOs();
    }

    @GetMapping(value = "/departments/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    Department departmentById(@PathVariable Integer id){
        LOGGER.debug("departmentById({})", id);
        return departmentService.getDepartmentById(id);
    }

    @PostMapping(value = "/departments")
    @ResponseStatus(HttpStatus.CREATED)
    Department addDepartmernt(@RequestBody Department department){

        LOGGER.debug("addDepartmernt({})", department);
        return departmentService.addDepartment(department);
    }

    @DeleteMapping(value = "/departments/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    void deleteDepartment(@PathVariable Integer id){

        LOGGER.debug("deleteDepartment()");
        departmentService.deleteDepartmentById(id);
    }
}
