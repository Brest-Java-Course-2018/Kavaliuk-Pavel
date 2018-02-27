package com.epam.brest.cource;

import com.epam.brest.cource.model.Employee;
import org.junit.Assert;
import org.junit.Test;

public class EmployeeTest {

    public static final String GENA = "Gena";

    @Test
    public void getEmployeeName() {

        Employee employee = new Employee();
        employee.setEmployeeName(GENA);
        Assert.assertTrue(employee.getEmployeeName().equals(GENA));
        Assert.assertEquals(GENA, employee.getEmployeeName());

    }
}