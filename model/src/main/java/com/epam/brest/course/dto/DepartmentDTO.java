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

    /**
     * This is average salary
     */
    private Integer avgSalary;

    /**
     * Get department's id
     * @return id
     */
    public Integer getDepartmentId() {
        return departmentId;
    }

    /**
     * Sets department's id
     * @param departmentId required id
     */
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * Gets department's name
     * @return department's name
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     *
     * @param departmentName
     */
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
