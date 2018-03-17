package com.epam.brest.course;

import com.epam.brest.course.model.Employee;
import org.junit.Assert;
import org.junit.Test;

/**
 * Employee class test
 */
public class EmployeeTest {
    /**
     * default name
     */
    private static final String GENA = "Gena";

    /**
     * Creates employee with defined name and than compares this name
     * to employee's name
     */
    @Test
    public void getEmployeeName() {

        Employee employee = new Employee();
        employee.setEmployeeName(GENA);
        Assert.assertTrue(employee.getEmployeeName().equals(GENA));
        Assert.assertEquals(GENA, employee.getEmployeeName());
    }
}