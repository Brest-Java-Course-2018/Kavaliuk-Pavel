package com.epam.brest.course.service;

import com.epam.brest.course.model.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:service-test.xml",
        "classpath:test-db-spring.xml", "classpath:dao.xml"})
@Rollback
@Transactional

public class EmployeeServiceImplTest {


    private static final String TEST_NAME = "Test name";
    private static final Integer SALARY = 200;
    private static final Integer PARENT_FATHER_ID = 1;

    @Autowired
    private EmployeeService employeeService;

    /**
     * Test adds a two new writes into table and after it,
     * gets all writes from table and compare count of elements with
     * expected employee's count
     */
    @Test
    public void getAllEmployeesTest(){

        Employee employee = new Employee(TEST_NAME, SALARY, PARENT_FATHER_ID);
        employeeService.addEmployee(employee);
        employee = new Employee(TEST_NAME + TEST_NAME, SALARY + SALARY,
                PARENT_FATHER_ID);
        employeeService.addEmployee(employee);
        Assert.assertNotNull(employeeService.getAllEmployees());
        Assert.assertTrue((((Integer) employeeService.getAllEmployees().size()).equals(3)));
    }

    /**
     * Create a few new employee's instances and check in equals
     * old count end new count of employees
     */
    @Test
    public void addEmployeeTest(){

        Integer counterOfEmployeesBeforeAdding = employeeService.getAllEmployees().size();
        Employee employee = new Employee(TEST_NAME, SALARY, PARENT_FATHER_ID);
        employeeService.addEmployee(employee);
        employee = new Employee(TEST_NAME + TEST_NAME, SALARY + SALARY,
                PARENT_FATHER_ID);
        employeeService.addEmployee(employee);
        Assert.assertNotNull(employeeService.getAllEmployees());
        Assert.assertFalse(counterOfEmployeesBeforeAdding.equals(employeeService.
                getAllEmployees().size()));
    }

    /**
     * Delete first element, which exist in default and check isEmpty method
     *
     */
    @Test
    public void deleteEmployeeByIdTest(){
        employeeService.deleteEmployeeById(1);
        Assert.assertTrue(employeeService.getAllEmployees().isEmpty());
    }
}
