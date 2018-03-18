package com.epam.brest.course.service;

import com.epam.brest.course.model.Department;
import org.springframework.stereotype.Service;

/**
 * Department Service interface
 */
@Service
public interface DepartmentService {

    /**
     * Gets department with required id
     * @param departmentId department's id
     * @return department instance
     */
    Department getDepartmentById(Integer departmentId);

    /**
     * Sets new description to required department
     * @param departmentId id of required department
     * @param description new description
     */
    void updateDepartmentDescription(Integer departmentId, String description);
}
