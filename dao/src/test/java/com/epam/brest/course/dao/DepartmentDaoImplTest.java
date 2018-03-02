package com.epam.brest.course.dao;

import com.epam.brest.course.model.Department;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-db-spring.xml",
        "classpath:test-dao.xml"})

public class DepartmentDaoImplTest {

    private final String RESIEVED_NAME = "";
    private final String RESIEVED_DESPRIPTION = "";
    private final int RESIEVED_ID = 0;

    @Autowired
    DepartmentDao departmentDao;

    Department departmentForTesting;

    @Test
    public void getDepartments() {
        List<Department> departments = departmentDao.getDepartment();
        Assert.assertFalse(departments.isEmpty());
    }

    @Test
    public void getDepartmentById() {

        Department department = departmentDao.getDepartmentById(1);

        Assert.assertNotNull(department);

        Assert.assertTrue(department.getDepartmentId().equals(1));
        Assert.assertTrue(department.getDepartmentName().equals("Distribution"));
        Assert.assertTrue(department.getDescription().equals("Distribution Department"));

    }

    @Test
    public void addDepartmentTest() {

        Department department = new Department();
        department.setDepartmentId(1);
        department.setDepartmentName("Test department");
        department.setDescription("Test department");
        departmentDao.addDepartment(department);
        departmentForTesting = departmentDao.addDepartment(department);
        Assert.assertTrue(departmentForTesting.getDepartmentName().equals("Test department"));
        Assert.assertTrue(departmentForTesting.getDescription().equals("Test department"));
    }

    @Test
    public void updateDepartmentTest() {
        Department department = new Department();
        department.setDepartmentId(1);
        department.setDepartmentName("Another one name");
        department.setDescription("Another one description");
        departmentDao.updateDepartment(department);
        departmentForTesting = departmentDao.addDepartment(department);
        Assert.assertTrue(departmentForTesting.getDepartmentName().equals("Another one name"));
        Assert.assertTrue(departmentForTesting.getDescription().equals("Another one description"));
    }

    @Test
    public void deleteDepartmentTest() {
        departmentDao.deleteDepartmentById(1);
        List<Department> departmentList = departmentDao.getDepartment();
        Assert.assertTrue(departmentList.isEmpty());
    }
}