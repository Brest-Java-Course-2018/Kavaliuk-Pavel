package com.epam.brest.course.dao;

import com.epam.brest.course.model.Department;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {


    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public DepartmentDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate =
                new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<
            Department> getDepartment() {
        List<Department> departments = jdbcTemplate.query(PoolOfQuery.GET_DEPARTMENTS_SQL,
                new DepartmentRowMapper());
        return departments;
    }

    @Override
    public Department getDepartmentById(Integer departmentId) {

        SqlParameterSource sqlParameterSource =
                new MapSqlParameterSource("departmentId", departmentId);
        Department department = namedParameterJdbcTemplate.queryForObject
                (PoolOfQuery.GET_DEPARTMENTS_BY_ID, sqlParameterSource,
                        new DepartmentRowMapper());

        return department;
    }

    /**
     * Method for adding new department into table.
     *
     * @param department - ready to transact object.
     * @return
     */
    @Override
    public Department addDepartment(Department department) {

        SqlParameterSource sqlParameterSource =
                new MapSqlParameterSource("departmentName",
                        department.getDepartmentName())
                        .addValue("description",
                                department.getDescription());
        namedParameterJdbcTemplate.update(PoolOfQuery.ADD_DEPARTMENT, sqlParameterSource);

        return department;
    }

    @Override
    public void updateDepartment(Department department) {

        SqlParameterSource sqlParameterSource =
                new MapSqlParameterSource("departmentId",
                        department.getDepartmentId())
                        .addValue("departmentName",
                                department.getDepartmentName())
                        .addValue("description",
                                department.getDescription());
        namedParameterJdbcTemplate.update
                (PoolOfQuery.UPDATE_DEPARTMENT, sqlParameterSource);
    }

    @Override
    public void deleteDepartmentById(Integer id) {

        SqlParameterSource sqlParameterSource =
                new MapSqlParameterSource("departmentId", id);
        namedParameterJdbcTemplate.update
                (PoolOfQuery.DELETE_DEPARTMENT, sqlParameterSource);
    }

    private class PoolOfQuery {
        private static final String GET_DEPARTMENTS_SQL = "SELECT departmentId,"
                + " departmentName, description FROM department";

        private static final String GET_DEPARTMENTS_BY_ID = "SELECT departmentId,"
                + " departmentName, description FROM department "
                + "WHERE departmentId = :departmentId";

        private static final String ADD_DEPARTMENT = "INSERT INTO department "
                + "(departmentName, Description) " +
                "VALUES(:departmentName, :description)";

        private static final String UPDATE_DEPARTMENT = "UPDATE department SET " +
                "departmentName = :departmentName, " +
                "description = :description " +
                "WHERE departmentId = :departmentId";

        private static final String DELETE_DEPARTMENT =
                "DELETE FROM department WHERE departmentId = :departmentId";
    }


    private class DepartmentRowMapper implements RowMapper<Department> {

        @Override
        public Department mapRow(ResultSet resultSet, int i)
                throws SQLException {
            Department department = new Department();
            department.setDepartmentId(resultSet.getInt(1));
            department.setDepartmentName(resultSet.getString(2));
            department.setDescription(resultSet.getString(3));
            return department;

        }
    }
}
