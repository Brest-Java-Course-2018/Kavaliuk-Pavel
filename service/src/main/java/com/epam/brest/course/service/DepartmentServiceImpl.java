package com.epam.brest.course.service;

import com.epam.brest.course.dao.DepartmentDao;
import com.epam.brest.course.model.Department;
import org.springframework.beans.factory.annotation.Autowired;


public class DepartmentServiceImpl implements DepartmentService {


    @Autowired
    private DepartmentDao departmentDao;

    public DepartmentServiceImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public Department getDepartmentById(Integer departmentId) {

        return departmentDao.getDepartmentById(departmentId);
    }

    @Override
    public void updateDepartmentDescription(Integer departmentId, String description) {

        Department department = departmentDao.getDepartmentById(departmentId);
        department.setDescription(description);
        departmentDao.updateDepartment(department);
    }

}
