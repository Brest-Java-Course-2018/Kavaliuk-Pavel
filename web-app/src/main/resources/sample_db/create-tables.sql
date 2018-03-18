DROP TABLE IF EXISTS department;
CREATE TABLE department (
  departmentId   INT          NOT NULL AUTO_INCREMENT,
  departmentName VARCHAR(255) NOT NULL,
  description    VARCHAR(255) NULL,
  PRIMARY KEY (departmentId)
);

DROP TABLE IF EXISTS employees;
CREATE TABLE employees (
  employeeId         INT          NOT NULL AUTO_INCREMENT,
  employeeName       VARCHAR(255) NOT NULL,
  salary             INT          NOT NULL,
  departmentFatherId INT          NOT NULL,
  PRIMARY KEY (employeeId),
  FOREIGN KEY (departmentFatherId) REFERENCES department (departmentId)
);