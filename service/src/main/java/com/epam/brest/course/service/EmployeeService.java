package com.epam.brest.course.service;

import com.epam.brest.course.model.Employee;

import java.util.Collection;

public interface EmployeeService {

    /**
     * Gets collection of employees
     * @return collection of employees
     */
    Collection<Employee> getAllEmployees();

    /**
     * Deletes required employee
     * @param employeeId employee's id
     */
    void deleteEmployeeById(Integer employeeId);

    /**
     * Adds new employee
     * @param employee instance of the new employee
     * @return instance of added employee
     */
    Employee addEmployee(Employee employee);

    /**
     *Updates parameters of employee
     * @param employee instance
     */
    void updateEmployee(Employee employee);

    /**
     * Gets employee by id from table
     * @param employeeId employee's id
     * @return required employee instance
     */
    Employee getEmployeeById(Integer employeeId);

    /**
     * Gets employees of required department with required id
     * @param departmentId department's id
     * @return list of employees
     */
    Collection<Employee> getEmployeesByDepartment(Integer departmentId);
}
