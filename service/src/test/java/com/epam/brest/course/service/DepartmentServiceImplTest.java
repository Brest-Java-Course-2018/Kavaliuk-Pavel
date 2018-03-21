package com.epam.brest.course.service;

import com.epam.brest.course.dto.DepartmentDTO;
import com.epam.brest.course.model.Department;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Test of DepartmentServiceImpl
 * Test of interaction of service and DAO
 */
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = {"classpath:service-test.xml",
        "classpath:test-db-spring.xml", "classpath:dao.xml"})
public class DepartmentServiceImplTest {

    private static final Logger LOGGER = LogManager.getLogger();

    private static final int ID = 1;
    private static final String DESC = "Academic Department";

    @Autowired
    private DepartmentService departmentService;

    /**
     * Procedure gets department with required id and
     * sets new description. After it, method asks
     * write with required id and compares descriptions each other
     */
    @Test
    public void updateDepartmentDescription() {

        LOGGER.debug("updateDepartmentDescription()");
        departmentService.updateDepartmentDescription(ID, DESC);

        Department department = departmentService.getDepartmentById(ID);
        Assert.assertEquals(DESC, department.getDescription());
    }

    @Test
    public void getDepartmentTest(){
        LOGGER.debug("getDepartmentTest()");
        Collection<Department> departmentDTOS = departmentService
                .getDepartment();
        Assert.assertTrue(((Integer) departmentDTOS.size()).equals(1));
    }

    @Test
    public void getDepartmentDTOsTest(){
        LOGGER.debug("getDepartmentDTOsTest()");
        Collection<DepartmentDTO> departmentDTOS = departmentService
                .getDepartmentDTOs();
        Assert.assertTrue(((Integer) departmentDTOS.size()).equals(1));
    }

    @Test
    public void deleteDepartmentById(){
        LOGGER.debug("deleteDepartmentById()");
        Collection<Department> departments = departmentService.getDepartment();
        Integer counter = departments.size();
        departmentService.deleteDepartmentById(1);
        Assert.assertTrue(((Integer) departmentService.getDepartment()
                .size()).equals(counter - 1));

    }
}