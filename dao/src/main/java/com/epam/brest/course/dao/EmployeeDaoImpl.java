package com.epam.brest.course.dao;

import com.epam.brest.course.model.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import java.util.Collection;

public class EmployeeDaoImpl implements EmployeeDao {

    private static final Logger LOGGER = LogManager.getLogger();

    private static final String EMPLOYEE_ID = "employeeId";
    private static final String EMPLOYEE_NAME = "employeeName";
    private static final String SALARY = "salary";
    private static final String DEPARTMENT_FATHER_ID = "departmentFatherId";

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

    @Value("${employees.getEmployeesByDepartment}")
    private String getEmployeesByDepartment;

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
    public Collection<Employee> getEmployee() {
        LOGGER.debug("getEmployee()");

        Collection<Employee> employees = namedParameterJdbcTemplate.
                getJdbcOperations().query(getAllEmployees,
                new EmployeeRowMapper());
        LOGGER.debug("count = {}", employees.size());
        return employees;

    }

    /**
     * This method requests employee from table with some id.
     *
     * @param employeeId - id of employee
     * @return needed employee
     */
    @Override
    public Employee getEmployeeById(final Integer employeeId) {

        LOGGER.debug("getEmployeeById({})", employeeId);

        SqlParameterSource sqlParameterSource =
                new MapSqlParameterSource(EMPLOYEE_ID, employeeId);
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
    public Employee addEmployee(final Employee employee) {
        LOGGER.debug("addEmployee({})", employee);

        MapSqlParameterSource namedParameter = new MapSqlParameterSource
                ("employeeName", employee.getEmployeeName());
        Integer result = namedParameterJdbcTemplate.queryForObject
                (checkEmployee, namedParameter, Integer.class);
        LOGGER.debug("result({})", result);

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
    public void updateEmployee(final Employee employee) {

        LOGGER.debug("updateEmployee({})", employee);

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
    public void deleteEmployeeById(final Integer employeeId) {

        LOGGER.debug("deleteEmployeeById({})", employeeId);

        namedParameterJdbcTemplate.getJdbcOperations()
                .update(deleteEmployee, employeeId);
    }

    /**
     * Gets employees of required department with required id
     *
     * @param departmentFatherId department's id
     * @return list of employees
     */
    @Override
    public Collection<Employee> getEmployeesByDepartment(final Integer departmentFatherId) {

        LOGGER.debug("getEmployeesByDepartment({})", departmentFatherId);

        Collection<Employee> employees = namedParameterJdbcTemplate
                .getJdbcOperations().query(getEmployeesByDepartment,
                        new Object[]{departmentFatherId},
                        BeanPropertyRowMapper.newInstance(Employee.class));
        return employees;
    }

    /**
     * mapper for employee
     */
    private class EmployeeRowMapper implements RowMapper<Employee> {
        /**
         * method
         * @param resultSet set of results
         * @param i required parameter
         * @return employee instance
         * @throws SQLException some exception
         */
        @Override
        public Employee mapRow(ResultSet resultSet, int i)
                throws SQLException {

            Employee employee = new Employee();
            employee.setEmployeeId(resultSet.getInt(EMPLOYEE_ID));
            employee.setEmployeeName(resultSet.getString(EMPLOYEE_NAME));
            employee.setSalary(resultSet.getInt(SALARY));
            employee.setDepartmentFatherId(resultSet.getInt(DEPARTMENT_FATHER_ID));
            return employee;

        }
    }
}
