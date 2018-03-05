package com.epam.brest.course.model;

/**
 * POJO Employee for model.
 */

public class Employee {

    private Integer employeeId;
    private String employeeName;
    private Integer salary;
    private Integer departmentFatherId;

    public Employee(String employeeName, Integer salary, Integer departmentFatherId) {
        this.employeeName = employeeName;
        this.salary = salary;
        this.departmentFatherId = departmentFatherId;
    }

    public Employee() {

    }


    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", salary=" + salary +
                ", departmentFatherId=" + departmentFatherId +
                '}';
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getDepartmentFatherId() {
        return departmentFatherId;
    }

    public void setDepartmentFatherId(Integer departmentId) {
        this.departmentFatherId = departmentId;
    }
}
