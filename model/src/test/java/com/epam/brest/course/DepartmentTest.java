package com.epam.brest.course;

import com.epam.brest.course.model.Department;
import org.junit.Assert;
import org.junit.Test;

/**
 * Department class test
 */
public class DepartmentTest {

    private static final int DEPARTMENT_ID = 2;
    private static final String TEST_NAME = "Test name";
    private static final String TEST_TOSTRING = "Department{"
            + "departmentId=2"
            + ", departmentName='Test name" + '\''
            + ", description='Test name" + '\''
            + '}';

    /**
     * Creates department's instance and sets his id,
     * than check it
     */
    @Test
    public void getDepartmentId(){

        Department department = new Department();
        department.setDepartmentId(DEPARTMENT_ID);
        Assert.assertTrue(department.getDepartmentId().equals(DEPARTMENT_ID));
    }

    /**
     * Creates department's instance and sets his name,
     * than check it
     */
    @Test
    public void getDepartmentName(){

        Department department = new Department();
        department.setDepartmentName(TEST_NAME);
        Assert.assertTrue(department.getDepartmentName().equals(TEST_NAME));
    }

    /**
     * Creates department's instance and sets his description,
     * than check it
     */
    @Test
    public void getDepartmentDescription(){

        Department department = new Department();
        department.setDescription(TEST_NAME);
        Assert.assertTrue(department.getDescription().equals(TEST_NAME));
    }

    /**
     * Creates department's instance and sets his parameters,
     * than check it
     */
    @Test
    public void toStringTest(){

        Department department = new Department();
        department.setDepartmentId(DEPARTMENT_ID);
        department.setDepartmentName(TEST_NAME);
        department.setDescription(TEST_NAME);
        Assert.assertTrue(department.toString().equals(TEST_TOSTRING));
    }

    /**
     * Creates department's instance via constructor with parameters,
     * than check it
     */
    @Test
    public void constructorWithParamsTest(){
        Department department = new Department(TEST_NAME, TEST_NAME
                + TEST_NAME);
        Assert.assertTrue(department.getDepartmentName().equals(TEST_NAME));
        Assert.assertTrue(department.getDescription().equals(TEST_NAME
                + TEST_NAME));
    }
}