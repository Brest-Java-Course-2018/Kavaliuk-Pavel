package com.epam.brest.course.dto;

/**
 * Class for shrinking transmitted parameters
 */
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
     * Sets department name
     * @param departmentName department's name
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * Gets average salary
     * @return average salary
     */
    public Integer getAvgSalary() {
        return avgSalary;
    }

    /**
     * Empty constructor
     * Create clean instance of class
     */
    public DepartmentDTO() {
    }

    /**
     * Sets average salary
     * @param avgSalary average salary
     */
    public void setAvgSalary(Integer avgSalary) {
        this.avgSalary = avgSalary;
    }
}
