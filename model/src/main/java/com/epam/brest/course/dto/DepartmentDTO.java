package com.epam.brest.course.dto;

public class DepartmentDTO {

    /**
     * This is department's id
     */
    private Integer departmentId;
    /**
     *
     * This is department's name
     */
    private String departmentName;

    private Integer avgSalary;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getAvgSalary() {
        return avgSalary;
    }

    public DepartmentDTO() {
    }

    public void setAvgSalary(Integer avgSalary) {
        this.avgSalary = avgSalary;
    }
}
