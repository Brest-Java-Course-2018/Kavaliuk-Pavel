package com.epam.brest.course;

import com.epam.brest.course.model.Employee;
import org.junit.Assert;
import org.junit.Test;

/**
 * Employee class test
 */
public class EmployeeTest {
    /**
     * Constants
     */
    private static final String GENA = "Gena";
    private static final int EMPLOYEE_ID = 2;
    private static final int SALARY = 200;
    private static final String EMAIL = "voorhis365@mail.ru";
    private static final String TEST_TOSTRING = "Employee{" +
            "employeeId=2" +
            ", employeeName='Gena" + '\'' +
            ", salary=200" +
            ", departmentFatherId=2" +
            ", email='voorhis365@mail.ru'" +
            '}';


    /**
     * Creates employee with defined name and than compares this name
     * to employee's name
     */
    @Test
    public void getEmployeeName() {

        Employee employee = new Employee();
        employee.setEmployeeName(GENA);
        Assert.assertTrue(employee.getEmployeeName().equals(GENA));
    }

    /**
     * Creates employee's instance and sets his id,
     * than check it
     */
    @Test
    public void getEmployeeId() {

        Employee employee = new Employee();
        employee.setEmployeeId(EMPLOYEE_ID);
        Assert.assertTrue(employee.getEmployeeId().equals(EMPLOYEE_ID));
    }

    /**
     * Creates employee's instance and sets his salary,
     * than check it
     */
    @Test
    public void getEmployeeSalaryTest() {

        Employee employee = new Employee();
        employee.setSalary(SALARY);
        Assert.assertTrue(employee.getSalary().equals(SALARY));
    }

    /**
     * Creates employee's instance and sets his department father id,
     * than check it
     */
    @Test
    public void getDepartmentFatheId() {

        Employee employee = new Employee();
        employee.setDepartmentFatherId(EMPLOYEE_ID);
        Assert.assertTrue(employee.getDepartmentFatherId().
                equals(EMPLOYEE_ID));
    }

    /**
     * Creates employee's instance and sets his parameters,
     * than check it
     */
    @Test
    public void toStringTest() {

        Employee employee = new Employee();
        employee.setEmployeeId(EMPLOYEE_ID);
        employee.setEmployeeName(GENA);
        employee.setSalary(SALARY);
        employee.setDepartmentFatherId(EMPLOYEE_ID);
        employee.setEmail(EMAIL);
        Assert.assertTrue(employee.toString().equals(TEST_TOSTRING));
    }

    /**
     * Creates employee's instance via constructor with parameters,
     * than check it
     */
    @Test
    public void constructorWithParamsTest() {

        Employee employee = new Employee(GENA, SALARY, EMPLOYEE_ID, EMAIL);
        Assert.assertTrue(employee.getEmployeeName().equals(GENA));
        Assert.assertTrue(employee.getSalary().equals(SALARY));
        Assert.assertTrue(employee.getDepartmentFatherId()
                .equals(EMPLOYEE_ID));
    }

    @Test
    public void getEmailTest() {
        Employee employee = new Employee();
        employee.setEmail(EMAIL);
        Assert.assertTrue(employee.getEmail().equals(EMAIL));
    }
}