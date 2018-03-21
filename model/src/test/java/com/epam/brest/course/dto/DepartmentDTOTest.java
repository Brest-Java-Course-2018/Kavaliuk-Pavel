package com.epam.brest.course.dto;

import org.junit.Assert;
import org.junit.Test;

public class DepartmentDTOTest {

    private static final String TEST_NAME = "TEST NAME";
    private static final Integer TEST_ID = 10;
    private static final Integer TEST_SALARY = 1000;

    @Test
    public void accessorsDepartmentTest(){
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setDepartmentId(TEST_ID);
        departmentDTO.setDepartmentName(TEST_NAME);
        departmentDTO.setAvgSalary(TEST_SALARY);
        Assert.assertTrue(departmentDTO.getDepartmentName().equals(TEST_NAME));
        Assert.assertTrue(departmentDTO.getDepartmentId().equals(TEST_ID));
        Assert.assertTrue(departmentDTO.getAvgSalary().equals(TEST_SALARY));
    }
}
