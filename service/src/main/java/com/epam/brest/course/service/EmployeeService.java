package com.epam.brest.course.service;

import com.epam.brest.course.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    void deleteEmployee(Integer employeeId);

    Employee addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    Employee getEmployeeById(Integer employeeId);
}
