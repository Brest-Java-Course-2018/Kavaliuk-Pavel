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
    /**
     * Field for eliminating magic strings.
     */
    private final String TEST_NAME = "TEST DEP";

    @Autowired
    DepartmentDao departmentDao;

    Department departmentForTesting;

    /**
     * This test create object of department
     * and adds it into table. After it, test fetch
     * all notes from table.
     */
    @Test
    public void getDepartmentsTest() {
        departmentForTesting = new Department();
        departmentForTesting.setDepartmentName(TEST_NAME);
        departmentForTesting.setDescription(TEST_NAME);
        departmentDao.addDepartment(departmentForTesting);
        List<Department> departments = departmentDao.getDepartment();
        Assert.assertFalse(departments.isEmpty());
    }

    /**
     * This test get note with id = 1.
     * It note exist, because it defined above.
     */
    @Test
    public void getDepartmentByIdTest() {

        Department department = departmentDao.getDepartmentById(1);
        Assert.assertNotNull(department);
        Assert.assertTrue(department.getDepartmentId().equals(1));
        Assert.assertTrue(department.getDepartmentName()
                .equals("Distribution"));
        Assert.assertTrue(department.getDescription()
                .equals("Distribution Department"));
    }

    /**
     * This test create a new department object and
     * add it into table. After it, test does request
     * note with needed id.
     */
    @Test
    public void addDepartmentTest() {

        Department department = new Department();
        department.setDepartmentId(3);
        department.setDepartmentName(TEST_NAME);
        department.setDescription(TEST_NAME);
        departmentDao.addDepartment(department);

        departmentDao.addDepartment(department);
        departmentForTesting = departmentDao.getDepartmentById(3);
        Assert.assertTrue(departmentForTesting.getDepartmentName()
                .equals(TEST_NAME));
        Assert.assertTrue(departmentForTesting.getDescription()
                .equals(TEST_NAME));
    }

    /**
     * This test create a new department object and
     * add it into table. After it, test make changes
     * into fields of this object and send request for
     * updating this note.
     */
    @Test
    public void updateDepartmentTest() {

        Department department = new Department();

        department.setDepartmentId(2);
        department.setDepartmentName(TEST_NAME);
        department.setDescription(TEST_NAME);
        departmentDao.addDepartment(department);

        department.setDepartmentName(TEST_NAME + TEST_NAME);
        department.setDescription(TEST_NAME + TEST_NAME);
        departmentDao.updateDepartment(department);

        departmentForTesting = departmentDao.getDepartmentById(2);
        Assert.assertTrue(departmentForTesting.getDepartmentName()
                .equals(TEST_NAME + TEST_NAME));
        Assert.assertTrue(departmentForTesting.getDescription()
                .equals(TEST_NAME + TEST_NAME));
    }

    /**
     * This test get all notes from table and get id of every note.
     * After it, test does delete all notes with fetched ids.
     */
    @Test
    public void deleteDepartmentTest() {

        List<Department> departmentList = departmentDao.getDepartment();
        for (Department dep : departmentList) {
            departmentDao.deleteDepartmentById(dep.getDepartmentId());
        }
        Assert.assertTrue(departmentDao.getDepartment().isEmpty());
    }
}