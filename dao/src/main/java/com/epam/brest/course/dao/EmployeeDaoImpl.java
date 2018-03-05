package com.epam.brest.course.dao;

import com.epam.brest.course.model.Employee;
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

public class EmployeeDaoImpl implements EmployeeDao {

    @Value("${employees.getAllEmployees}")
    private String getAllEmployees;

    @Value("${employees.getEmployeeById}")
    private String getEmployeeById;

    @Value("${employees.checkEmployee}")
    private String checkEmployee;

    @Value("${employees.insertEmployee}")
    private String insertEmployee;

    @Value("${employees.updateEmployee}")
    private String updateEmployee;

    @Value("${employees.deleteEmployee}")
    private String deleteEmployee;

    /**
     * Allow use ":parameter" rather than "?" in requests.
     */
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    /**
     * This method get all notes from table.
     *
     * @return list of employees
     */
    @Override
    public List<Employee> getEmployee() {
        List<Employee> employees = namedParameterJdbcTemplate.
                getJdbcOperations().query(getAllEmployees,
                new EmployeeRowMapper());
        return employees;

    }

    /**
     * This method requests employee from table with some id.
     *
     * @param employeeId - id of employee
     * @return needed employee
     */
    @Override
    public Employee getEmployeeById(Integer employeeId) {
        SqlParameterSource sqlParameterSource =
                new MapSqlParameterSource("employeeId", employeeId);
        Employee employee = namedParameterJdbcTemplate.queryForObject
                (getEmployeeById, sqlParameterSource, BeanPropertyRowMapper
                        .newInstance(Employee.class));
        return employee;
    }

    /**
     * This method add employee into table.
     * If employee exist exception will be thrown.
     *
     * @param employee employee to add
     * @return added employee
     */
    @Override
    public Employee addEmployee(Employee employee) {
        MapSqlParameterSource namedParameter = new MapSqlParameterSource
                ("employeeName", employee.getEmployeeName());
        Integer result = namedParameterJdbcTemplate.queryForObject
                (checkEmployee, namedParameter, Integer.class);
        if (result == 0) {
            namedParameter = new MapSqlParameterSource();
            namedParameter.addValue("employeeName", employee
                    .getEmployeeName());
            namedParameter.addValue("salary", employee.getSalary());
            namedParameter.addValue("departmentFatherId", employee
                    .getDepartmentFatherId());

            KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
            namedParameterJdbcTemplate.update(insertEmployee,
                    namedParameter, generatedKeyHolder);
            employee.setEmployeeId(generatedKeyHolder.getKey().intValue());
        } else {
            throw new IllegalArgumentException
                    ("Employee with the same name already exist");
        }
        return employee;
    }

    /**
     * Just updates employee with needed id.
     *
     * @param employee employee ti update
     */
    @Override
    public void updateEmployee(Employee employee) {
        SqlParameterSource namedParameter =
                new BeanPropertySqlParameterSource(employee);
        namedParameterJdbcTemplate
                .update(updateEmployee, namedParameter);
    }

    /**
     * Just deletes needed employee.
     *
     * @param employeeId id of employee
     */
    @Override
    public void deleteEmployeeById(Integer employeeId) {

        namedParameterJdbcTemplate.getJdbcOperations().update(deleteEmployee, employeeId);
    }

    private class EmployeeRowMapper implements RowMapper<Employee> {

        @Override
        public Employee mapRow(ResultSet resultSet, int i)
                throws SQLException {

            Employee employee = new Employee();
            employee.setEmployeeId(resultSet.getInt("employeeId"));
            employee.setEmployeeName(resultSet.getString("employeeName"));
            employee.setSalary(resultSet.getInt("salary"));
            employee.setDepartmentFatherId(resultSet.getInt("departmentFatherId"));
            return employee;

        }
    }
}
