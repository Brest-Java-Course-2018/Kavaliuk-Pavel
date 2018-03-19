package com.epam.brest.course.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * POJO Department for model.
 */

public class Department {

    /**
     * This is department's id
     */
    //@NotNull
    private Integer departmentId;
    /**
     *
     * This is department's name
     */

    @NotNull
    @Size(min = 2, max = 50)
    private String departmentName;
    /**
     *
     * This is department's description
     */
    private String description;
    /**
     * Empty constructor
     * Do nosing as fact
     */
    public Department() {

    }

    /**
     * Constructor with parameters.
     * @param departmentName - name of department
     * @param description - description of department
     */
    public Department(final String departmentName, final String description) {
        this.departmentName = departmentName;
        this.description = description;
    }

    /**
     * Overriding toString method. Include id, name and description
     * of department
     * @return custom toString string
     */
    @Override
    public String toString() {
        return "Department{"
                + "departmentId=" + departmentId
                + ", departmentName='" + departmentName + '\''
                + ", description='" + description + '\''
                + '}';
    }

    /**
     * Get department's id
     * @return department's id
     */
    public Integer getDepartmentId() {
        return departmentId;
    }

    /**
     * Set department's id
     * @param departmentId id which will be department's id
     */
    public void setDepartmentId(final Integer departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * Get department's name
     * @return name of department
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * Set department's name
     * @param departmentName string which will be department's name
     */
    public void setDepartmentName(final String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * Get department's description
     * @return string with description of department
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set department's description
     * @param description string which will be department's description
     */
    public void setDescription(final String description) {
        this.description = description;
    }
}
