package com.epam.brest.course.dao;

import com.epam.brest.course.dto.DepartmentDTO;
import com.epam.brest.course.model.Department;

import java.util.Collection;

/**
 * Department DAO Interface.
 */

public interface DepartmentDao {
    /**
     * Gets all writes from department's table
     * @return department's collection
     */
    Collection<Department> getDepartment();

    /**
     * Gets write with required id
     * @param departmentId required id
     * @return department's instance
     */
    Department getDepartmentById(Integer departmentId);

    /**
     * Adds write into table
     * @param department instance of department,
     * which will be added
     * @return instance of added department
     */
    Department addDepartment(Department department);

    /**
     * Updates required write
     * @param department instance of department, which will be updated
     */
    void updateDepartment(Department department);

    /**
     * Deletes write with required id
     * @param id id of required department
     */
    void deleteDepartmentById(Integer id);

    /**
     * Gets department's DTO
     * @return collection with params
     */
    Collection<DepartmentDTO> getDepartmentDTOs();



}
