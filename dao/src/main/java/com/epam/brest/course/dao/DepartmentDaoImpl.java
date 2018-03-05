package com.epam.brest.course.dao;

import com.epam.brest.course.model.Department;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {

    private static final String DEPARTMENT_ID = "departmentId";
    private static final String DEPARTMENT_NAME = "departmentName";
    private static final String DESCRIPTION = "description";

    @Value("${department.select}")
    private String departmentSelect;

    @Value("${department.selectById}")
    private String departmentSelectById;

    @Value("${department.checkDepartment}")
    private String departmentCheck;

    @Value("${department.insert}")
    private String departmentInsert;

    @Value("${department.update}")
    private String departmentUpdate;

    @Value("${department.delete}")
    private String departmentDelete;

    /**
     * Class for make easy working with DB.
     * In this case it make requests to database.
     */

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    /**
     * Allow use ":parameter" rather than "?" in requests.
     */
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * @return list of departments.
     */
    @Override
    public List<Department> getDepartment() {

        List<Department> departments = namedParameterJdbcTemplate.getJdbcOperations().query(departmentSelect,
                new DepartmentRowMapper());
        return departments;
    }

    @Override
    public Department getDepartmentById(Integer departmentId) {

        SqlParameterSource sqlParameterSource =
                new MapSqlParameterSource(DEPARTMENT_ID, departmentId);
        Department department = namedParameterJdbcTemplate.queryForObject
                (departmentSelectById, sqlParameterSource,
                        BeanPropertyRowMapper.newInstance(Department.class));

        return department;
    }

    /**
     * Method for adding new department into table.
     *
     * @param department - ready to transact object.
     * @return department object.
     */
    @Override
    public Department addDepartment(Department department) {

        MapSqlParameterSource namedParameter = new MapSqlParameterSource(DEPARTMENT_NAME, department.getDepartmentName());
        Integer result = namedParameterJdbcTemplate.queryForObject(departmentCheck, namedParameter, Integer.class);

        if (result == 0) {

            namedParameter = new MapSqlParameterSource();
            namedParameter.addValue(DEPARTMENT_NAME, department.getDepartmentName());
            namedParameter.addValue(DESCRIPTION, department.getDescription());

            KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
            namedParameterJdbcTemplate.update(departmentInsert, namedParameter, generatedKeyHolder);
            department.setDepartmentId(generatedKeyHolder.getKey().intValue());
        } else {
            throw new IllegalArgumentException("Department with the same name already exist");
        }


//        SqlParameterSource sqlParameterSource =
//                new MapSqlParameterSource("departmentName",
//                        department.getDepartmentName())
//                        .addValue("description",
//                                department.getDescription());
//        namedParameterJdbcTemplate.update(PoolOfQuery.ADD_DEPARTMENT, sqlParameterSource);

        return department;
    }

    @Override
    public void updateDepartment(Department department) {

        SqlParameterSource namedParameter =
                new BeanPropertySqlParameterSource(department);
        namedParameterJdbcTemplate
                .update(departmentUpdate, namedParameter);


//        SqlParameterSource sqlParameterSource =
//                new MapSqlParameterSource(DEPARTMENT_ID,
//                        department.getDepartmentId())
//                        .addValue(DEPARTMENT_NAME,
//                                department.getDepartmentName())
//                        .addValue(DESCRIPTION,
//                                department.getDescription());
//        namedParameterJdbcTemplate.update
//                (PoolOfQuery.UPDATE_DEPARTMENT, sqlParameterSource);
    }

    @Override
    public void deleteDepartmentById(Integer departmentId) {

        namedParameterJdbcTemplate.getJdbcOperations().update(departmentDelete, departmentId);

//        SqlParameterSource sqlParameterSource =
//                new MapSqlParameterSource(DEPARTMENT_ID, id);
//        namedParameterJdbcTemplate.update
//                (PoolOfQuery.DELETE_DEPARTMENT, sqlParameterSource);
    }


    private class DepartmentRowMapper implements RowMapper<Department> {

        @Override
        public Department mapRow(ResultSet resultSet, int i)
                throws SQLException {

            Department department = new Department();
            department.setDepartmentId(resultSet.getInt(DEPARTMENT_ID));
            department.setDepartmentName(resultSet.getString(DEPARTMENT_NAME));
            department.setDescription(resultSet.getString(DESCRIPTION));
            return department;

        }
    }
}
