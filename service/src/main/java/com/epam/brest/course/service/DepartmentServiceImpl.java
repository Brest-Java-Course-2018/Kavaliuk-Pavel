package com.epam.brest.course.service;

import com.epam.brest.course.dao.DepartmentDao;
import com.epam.brest.course.dto.DepartmentDTO;
import com.epam.brest.course.model.Department;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;

/**
 * Interaction Service and DAO
 */
public class DepartmentServiceImpl implements DepartmentService {

    private static final Logger LOGGER = LogManager.getLogger();

    private DepartmentDao departmentDao;

    public DepartmentServiceImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    /**
     * Gets department from table with required id
     * @param departmentId department's id
     * @return department instance
     */
    @Override
    public Department getDepartmentById(Integer departmentId) {

        LOGGER.debug("getDepartmentById({})", departmentId);

        return departmentDao.getDepartmentById(departmentId);
    }

    /**
     *
     * @param departmentId id of required department
     * @param description new description
     */
    @Override
    public void updateDepartmentDescription(Integer departmentId, String description) {

        LOGGER.debug("updateDepartmentDescription({}, {})", departmentId, description);

        Department department = departmentDao.getDepartmentById(departmentId);
        department.setDescription(description);
        departmentDao.updateDepartment(department);
    }

    @Override
    public Collection<Department> getDepartment() {

        LOGGER.debug("getDepartment()");

        return departmentDao.getDepartment();
    }

    @Override
    public Collection<DepartmentDTO> getDepartmentDTOs() {
        LOGGER.debug("getDepartmentDTOs()");
        return departmentDao.getDepartmentDTOs();
    }
    @Override
    public void deleteDepartmentById(Integer id) {
        LOGGER.debug("deleteDepartmentById({})", id);
        departmentDao.deleteDepartmentById(id);
    }

    @Override
    public Department addDepartment(Department department) {
        LOGGER.debug("addDepartment()");

        return departmentDao.addDepartment(department);
    }

    @Override
    public void updateDepartment(Department department) {
        LOGGER.debug("updateDepartment({})", department);
        departmentDao.updateDepartment(department);
    }
}
