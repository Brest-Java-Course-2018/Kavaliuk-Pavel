package com.epam.brest.course.service;

import com.epam.brest.course.dto.DepartmentDTO;
import com.epam.brest.course.model.Department;
import org.springframework.stereotype.Service;

import java.util.Collection;

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

    /**
     * Gets all writes from department's table
     * @return department's collection
     */
    Collection<Department> getDepartment();

    /**
     * Gets department's DTO
     * @return collection with params
     */
    Collection<DepartmentDTO> getDepartmentDTOs();

    void deleteDepartmentById(Integer id);

    /**
     * Adds write into table
     * @param department instance of department,
     * which will be added
     * @return instance of added department
     */
    Department addDepartment(Department department);

    /**
     * Update department.
     *
     * @param department department
     */
    void updateDepartment(Department department);

}
