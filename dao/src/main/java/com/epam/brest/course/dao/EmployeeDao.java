package com.epam.brest.course.dao;

import com.epam.brest.course.model.Employee;

import java.util.List;

public interface EmployeeDao {
    /**
     * @return list with all employees
     */
    List<Employee> getEmployee();

    /**
     * @param employeeId id of required employee
     * @return employee with required id
     */
    Employee getEmployeeById(Integer employeeId);

    /**
     * @param employee employee to add
     * @return object of eployee witch will be add into table
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
}
