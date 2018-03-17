package com.epam.brest.course.service;

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
}