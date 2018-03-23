package com.epam.brest.course.client.rest;

import com.epam.brest.course.dto.DepartmentDTO;
import com.epam.brest.course.model.Department;
import com.epam.brest.course.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;

public class DepartmentConsumerRest implements DepartmentService {


    private String url;

    private RestTemplate restTemplate;

    public DepartmentConsumerRest(String url, RestTemplate restTemplate) {
        this.url = url;
        this.restTemplate = restTemplate;
    }

    /**
     * Gets department with required id
     *
     * @param departmentId department's id
     * @return department instance
     */
    @Override
    public Department getDepartmentById(Integer departmentId) {

        ResponseEntity responseEntity = restTemplate.postForEntity(url + "/", departmentId, Department.class);
        Department department = (Department) responseEntity.getBody();
        return department;
    }

    /**
     * Sets new description to required department
     *
     * @param departmentId id of required department
     * @param description  new description
     */
    @Override
    public void updateDepartmentDescription(Integer departmentId, String description) {

    }

    /**
     * Gets all writes from department's table
     *
     * @return department's collection
     */
    @Override
    public Collection<Department> getDepartment() {
        return null;
    }

    /**
     * Gets department's DTO
     *
     * @return collection with params
     */
    @Override
    @SuppressWarnings("unchecked")
    public Collection<DepartmentDTO> getDepartmentDTOs() {

        ResponseEntity responseEntity = restTemplate.getForEntity(url, List.class);
        List<DepartmentDTO> departments = (List<DepartmentDTO>) responseEntity.getBody();
        return departments;
    }

    @Override
    public void deleteDepartmentById(Integer id) {

    }

    /**
     * Adds write into table
     *
     * @param department instance of department,
     *                   which will be added
     * @return instance of added department
     */
    @Override
    public Department addDepartment(Department department) {

        ResponseEntity responseEntity = restTemplate.postForEntity(url, department, Department.class);
        Department result = (Department) responseEntity.getBody();
        return result;
    }

    /**
     * Update department.
     *
     * @param department department
     */
    @Override
    public void updateDepartment(Department department) {

    }
}
