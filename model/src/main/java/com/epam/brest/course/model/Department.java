package com.epam.brest.course.model;

/**
 * POJO Department for model.
 */


public class Department {
    /**
     * This is department's id
     */
    private Integer departmentId;
    /**
     * This is department's name
     */
    private String departmentName;
    /**
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
    public Department(String departmentName, String description) {
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
                +", description='" + description + '\''
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
    public void setDepartmentId(Integer departmentId) {
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
    public void setDepartmentName(String departmentName) {
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
    public void setDescription(String description) {
        this.description = description;
    }
}
