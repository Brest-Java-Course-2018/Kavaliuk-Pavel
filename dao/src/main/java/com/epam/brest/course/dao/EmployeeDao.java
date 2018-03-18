package com.epam.brest.course.dao;

import com.epam.brest.course.model.Employee;

import java.util.Collection;

public interface EmployeeDao {
    /**
     * @return list with all employees
     */
    Collection<Employee> getEmployee();

    /**
     * @param employeeId id of required employee
     * @return employee with required id
     */
    Employee getEmployeeById(Integer employeeId);

    /**
     * @param employee employee to add
     * @return object of employee witch will be add into table
     */
    Employee addEmployee(Employee employee);

    /**
     * @param employee employee to update
     */
    void updateEmployee(Employee employee);

    /**
     * @param id id of employee witch will be delete
     */
    void deleteEmployeeById(Integer id);

    /**
     * Gets employees of required department with required id
     * @param departmentId department's id
     * @return list of employees
     */
    Collection<Employee> getEmployeesByDepartment(Integer departmentId);
}
