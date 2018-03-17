package com.epam.brest.course.dao;

import com.epam.brest.course.model.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-db-spring.xml",
        "classpath:test-employee-dao.xml", "classpath:dao.xml"})
/**
 * Rolls back all transactions
 */
@Rollback

@Transactional

public class EmployeeDaoImplTest {

    public static final String TEST_NAME = "Test name";

    @Autowired
    EmployeeDao employeeDao;

    /**
     * This test get all notes from table of employees.
     */
    @Test
    public void getEmployeesTest() {
        List<Employee> employeeList = employeeDao.getEmployee();
        Assert.assertFalse(employeeList.isEmpty());
    }

    /**
     * This test get exist note from table.
     */

    @Test
    public void getEmployeeByIdTest() {

        Employee employee = employeeDao.getEmployeeById(1);
        Assert.assertNotNull(employee);
        Assert.assertTrue(employee.getEmployeeId().equals(1));
        Assert.assertTrue(employee.getEmployeeName()
                .equals("Ivan Ivanov"));
        Assert.assertTrue(employee.getSalary().equals(300));
        Assert.assertTrue(employee.getDepartmentFatherId().equals(1));
    }

    /**
     * This test get all notes from table. After it, test adds
     * new employee into table and check valid of parameters.
     */
    @Test
    public void addEmployeeTest() {
        List<Employee> employees = employeeDao.getEmployee();
        int sizeBefore = employees.size();
        Employee employee = new Employee(TEST_NAME, 100, 1);

        Employee newEmployee = employeeDao.addEmployee(employee);
        Assert.assertNotNull(newEmployee);
        Assert.assertTrue(newEmployee.getEmployeeName()
                .equals(employee.getEmployeeName()));
        Assert.assertTrue(newEmployee.getSalary().equals(employee.getSalary()));
        Assert.assertTrue(newEmployee.getDepartmentFatherId().equals(employee
                .getDepartmentFatherId()));
        Assert.assertTrue(sizeBefore < employeeDao.getEmployee().size());
    }

    /**
     * Test adds new employee into table.
     * After it, test rewrites some parameters and update added write.
     */
    @Test
    public void updateEmployeeTest() {
        Employee employee = new Employee(TEST_NAME, 500, 1);

        Employee newEmployee = employeeDao.addEmployee(employee);

        newEmployee.setEmployeeName("New name");
        newEmployee.setSalary(600);
        newEmployee.setDepartmentFatherId(1);
        employeeDao.updateEmployee(newEmployee);

        Employee updatedEmployee = employeeDao.getEmployeeById
                (newEmployee.getEmployeeId());

        Assert.assertTrue(newEmployee.getEmployeeId().equals
                (updatedEmployee.getEmployeeId()));
        Assert.assertTrue(newEmployee.getEmployeeName()
                .equals(updatedEmployee.getEmployeeName()));
        Assert.assertTrue(newEmployee.getSalary()
                .equals(updatedEmployee.getSalary()));
        Assert.assertTrue(newEmployee.getDepartmentFatherId()
                .equals(updatedEmployee.getDepartmentFatherId()));
    }

    /**
     * This test add new write into table. After it, test
     * deletes this write and check deleting.
     */
    @Test
    public void deleteEmployeeTest() {
        Employee employee =
                new Employee(TEST_NAME, 500, 1);
        employee = employeeDao.addEmployee(employee);

        List<Employee> employees = employeeDao.getEmployee();
        int sizeBefore = employees.size();
        employeeDao.deleteEmployeeById(employee.getEmployeeId());
        Assert.assertTrue((sizeBefore - 1) == employeeDao.getEmployee().size());
    }

    /**
     *This test creates new employee's instance and adds it into table.
     * After it, method compares expected number of employees in
     * list with expected
     */
    @Test
    public void getEmployeesByDepartmentTest(){

        Employee employee = new Employee(TEST_NAME, 200, 1);
        employeeDao.addEmployee(employee);
        employee = new Employee(TEST_NAME + TEST_NAME, 200, 1);
        employeeDao.addEmployee(employee);
        List<Employee> department = employeeDao.getEmployeesByDepartment(1);
        Assert.assertTrue(department.size() == 3);
    }
}
