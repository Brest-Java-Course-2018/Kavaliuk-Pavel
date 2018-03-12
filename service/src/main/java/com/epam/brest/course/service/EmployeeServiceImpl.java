package com.epam.brest.course.service;

import com.epam.brest.course.dao.EmployeeDao;
import com.epam.brest.course.model.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    private EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }


    @Override
    public List<Employee> getAllEmployees() {


        List<Employee> employees = employeeDao.getEmployee();
        return employees;
    }

    @Override
    public void deleteEmployee(Integer employeeId) {

        LOGGER.debug("Id of employee: {}", employeeId);
        employeeDao.deleteEmployeeById(employeeId);
    }


    @Override
    public Employee addEmployee(Employee employee) {
        LOGGER.debug("New emploiee: name {}, salary {}, department{}",
                employee.getEmployeeName(), employee.getSalary(),
                employee.getDepartmentFatherId());
        Employee newEmployee = employeeDao.addEmployee(employee);
        return newEmployee;
    }

    @Override
    public void updateEmployee(Employee employee) {

        LOGGER.debug("New parameters: name {}, salary {}, department: {}",
                employee.getEmployeeName(), employee.getSalary(),
                employee.getDepartmentFatherId());
        employeeDao.updateEmployee(employee);
    }

    @Override
    public Employee getEmployeeById(Integer employeeId) {

        LOGGER.debug("Id: {}", employeeId);
        Employee employee = employeeDao.getEmployeeById(employeeId);
        return employee;
    }
}
