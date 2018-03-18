package com.epam.brest.course.service;

import com.epam.brest.course.dao.EmployeeDao;
import com.epam.brest.course.model.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;

/**
 * Interaction service and DAO
 */
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = LogManager.getLogger();

    private EmployeeDao employeeDao;

    /**
     * Constructor
     * @param employeeDao DAO's instance
     */
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    /**
     * Gets all employees from table
     * @return list of employees
     */
    @Override
    public Collection<Employee> getAllEmployees() {

        LOGGER.debug("getAllEmployees()");
        Collection<Employee> employees = employeeDao.getEmployee();
        return employees;
    }

    /**
     * Finds employee by id in table and deletes his
     * @param employeeId employee's id
     */
    @Override
    public void deleteEmployeeById(Integer employeeId) {

        LOGGER.debug("deleteEmployeeById({})", employeeId);
        employeeDao.deleteEmployeeById(employeeId);
    }

    /**
     * Gets all employees of required department
     * @param departmentId department's id
     * @return list with employees
     */
    @Override
    public Collection<Employee> getEmployeesByDepartment(Integer departmentId) {

        LOGGER.debug("getEmployeeByDepartment({})", departmentId);

        Collection<Employee> employees = employeeDao.getEmployeesByDepartment(departmentId);
        return employees;
    }

    /**
     * Adds new employee into table
     * @param employee instance of the new employee
     * @return instance of added employee
     */
    @Override
    public Employee addEmployee(Employee employee) {
        LOGGER.debug("New employee: name {}, salary {}, department{}",
                employee.getEmployeeName(), employee.getSalary(),
                employee.getDepartmentFatherId());

        return employeeDao.addEmployee(employee);
    }

    /**
     * Updates employee's parameters
     * @param employee instance
     */
    @Override
    public void updateEmployee(Employee employee) {

        LOGGER.debug("New parameters: name {}, salary {}, department: {}",
                employee.getEmployeeName(), employee.getSalary(),
                employee.getDepartmentFatherId());
        employeeDao.updateEmployee(employee);
    }

    /**
     * Finds and gets employee in table by id
     * @param employeeId employee's id
     * @return employee instance
     */
    @Override
    public Employee getEmployeeById(Integer employeeId) {

        LOGGER.debug("getEmployeeById({})", employeeId);
        Employee employee = employeeDao.getEmployeeById(employeeId);
        return employee;
    }
}
