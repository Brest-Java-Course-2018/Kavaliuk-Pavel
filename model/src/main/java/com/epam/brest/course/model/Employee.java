package com.epam.brest.course.model;

/**
 * POJO Employee for model.
 */

public class Employee {
    /**
     * This is employee's id
     */
    private Integer employeeId;
    /**
     * This is employee's name
     */
    private String employeeName;
    /**
     * This is employee's salary
     */
    private Integer salary;
    /**
     * This is id of department which employee belongs
     */
    private Integer departmentFatherId;

    /**
     * Employee's email
     */
    private String email;

    /**
     * Constructor with parameters
     * @param employeeName name of employee
     * @param salary employee's salary
     * @param departmentFatherId department's id which employee belongs
     * @param email email
     */
    public Employee(String employeeName, Integer salary,
                    Integer departmentFatherId, String email) {
        this.employeeName = employeeName;
        this.salary = salary;
        this.departmentFatherId = departmentFatherId;
        this.email = email;
    }

    /**
     * Empty constructor
     * Do nothing as fact
     */
    public Employee() {

    }

    /**
     * Custom toString method
     * @return string which contains id, name, salary
     * and department's id which employee belongs
     */
    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", salary=" + salary +
                ", departmentFatherId=" + departmentFatherId +
                ", email='" + email + '\'' +
                '}';
    }

    /**
     * Get employees's id
     * @return employee's id
     */
    public Integer getEmployeeId() {
        return employeeId;
    }

    /**
     * Set employee's id
     * @param employeeId id of employee
     */
    public void setEmployeeId(final Integer employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Get employee's name
     * @return name of employee
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * Set employee's name
     * @param employeeName name of employee
     */
    public void setEmployeeName(final String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * Get employee's salary
     * @return salary of employee
     */
    public Integer getSalary() {
        return salary;
    }

    /**
     * Set employee's salary
     * @param salary employee's salary
     */
    public void setSalary(final Integer salary) {
        this.salary = salary;
    }

    /**
     * Get department's id which employee belongs
     * @return department's id which employee belongs
     */
    public Integer getDepartmentFatherId() {
        return departmentFatherId;
    }

    /**
     * Set department's id which employee belongs
     * @param departmentId department's id which employee belongs
     */
    public void setDepartmentFatherId(final Integer departmentId) {
        this.departmentFatherId = departmentId;
    }

    /**
     * Gets employee's email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets employee's email
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
