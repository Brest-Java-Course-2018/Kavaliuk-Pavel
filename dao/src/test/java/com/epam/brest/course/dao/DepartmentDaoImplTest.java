package com.epam.brest.course.dao;

import com.epam.brest.course.model.Department;
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
        "classpath:test-dao.xml", "classpath:dao.xml"})
/**
 * Откатывает все транзакции
 */
@Rollback

@Transactional

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
//    @Test
//    public void addDepartmentTest() {
//
//
//        Department department = new Department();
//        department.setDepartmentId();
//        department.setDepartmentName(TEST_NAME);
//        department.setDescription(TEST_NAME);
//        departmentDao.addDepartment(department);
//
//        departmentDao.addDepartment(department);
//        departmentForTesting = departmentDao.getDepartmentById(3);
//        Assert.assertTrue(departmentForTesting.getDepartmentName()
//                .equals(TEST_NAME));
//        Assert.assertTrue(departmentForTesting.getDescription()
//                .equals(TEST_NAME));
//    }

    /**
     * This test create a new department object and
     * add it into table. After it, test make changes
     * into fields of this object and send request for
     * updating this note.
     */
    @Test
    public void updateDepartmentTest() {

        Department department = new Department("Test name", "Test descr");

        Department newDepartment = departmentDao.addDepartment(department);
        newDepartment.setDepartmentName("New name");
        newDepartment.setDescription("New description");
        departmentDao.updateDepartment(newDepartment);
        Department updatedDepartnment = departmentDao.getDepartmentById(newDepartment.getDepartmentId());
        Assert.assertTrue(newDepartment.getDepartmentId().equals(updatedDepartnment.getDepartmentId()));
        Assert.assertTrue(newDepartment.getDepartmentName().equals(updatedDepartnment.getDepartmentName()));
        Assert.assertTrue(newDepartment.getDescription().equals(updatedDepartnment.getDescription()));


//        Department department = new Department();
//
//        department.setDepartmentId(1);
//        department.setDepartmentName(TEST_NAME);
//        department.setDescription(TEST_NAME);
//        departmentDao.addDepartment(department);
//
//        department.setDepartmentName(TEST_NAME + TEST_NAME);
//        department.setDescription(TEST_NAME + TEST_NAME);
//        departmentDao.updateDepartment(department);
//
//        departmentForTesting = departmentDao.getDepartmentById(1);
//        Assert.assertTrue(departmentForTesting.getDepartmentName()
//                .equals(TEST_NAME + TEST_NAME));
//        Assert.assertTrue(departmentForTesting.getDescription()
//                .equals(TEST_NAME + TEST_NAME));
    }

    /**
     * This test get all notes from table and get id of every note.
     * After it, test does delete all notes with fetched ids.
     */
    @Test
    public void deleteDepartmentTest() {
        Department department =
                new Department("Test name", "Test descr");
        department = departmentDao.addDepartment(department);

        List<Department> departments = departmentDao.getDepartment();
        int sizeBefore = departments.size();
        departmentDao.deleteDepartmentById(department.getDepartmentId());
        Assert.assertTrue((sizeBefore - 1) == departmentDao.getDepartment().size());

//        List<Department> departmentList = departmentDao.getDepartment();
//        for (Department dep : departmentList) {
//            departmentDao.deleteDepartmentById(dep.getDepartmentId());
//        }
//        Assert.assertTrue(departmentDao.getDepartment().isEmpty());
    }

    @Test
    public void addDepartmentTest() {
        List<Department> departments = departmentDao.getDepartment();
        int sizeBefore = departments.size();
        Department dep = new Department("Test name", "Test descr");

        Department dep1 = departmentDao.addDepartment(dep);
        Assert.assertNotNull(dep1.getDepartmentId());
        Assert.assertTrue(dep1.getDepartmentName().equals(dep.getDepartmentName()));
        Assert.assertTrue(dep1.getDescription().equals(dep.getDescription()));
        Assert.assertTrue(sizeBefore < departmentDao.getDepartment().size());

    }
}