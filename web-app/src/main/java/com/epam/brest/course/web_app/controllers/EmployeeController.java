package com.epam.brest.course.web_app.controllers;

import com.epam.brest.course.dto.DepartmentDTO;
import com.epam.brest.course.model.Employee;
import com.epam.brest.course.service.DepartmentService;
import com.epam.brest.course.service.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

/**
 * Employee's controller
 */
@Controller
public class EmployeeController {

    private List<DepartmentDTO> departmentDTOs;

    private Collection<Employee> employees;

    private static final Logger LOGGER = LogManager.getLogger();

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;


    /**
     * If exist /employees in address
     * @param model model of employees
     * @return employees page
     */
    @GetMapping(value = "employees")
    public String getEmployees(Model model) {
        LOGGER.debug("getEmployees()");
        employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);

        return "employees";
    }

    /**
     * If exist /department in address
     * @param model model of department
     * @return view
     */
    @GetMapping(value = "/employee/{id}")
    public String getEmployeeById(@PathVariable Integer id, Model model) {

        Employee employee = employeeService.getEmployeeById(id);
        departmentDTOs =
                (List<DepartmentDTO>) departmentService.getDepartmentDTOs();


        for(DepartmentDTO departmentDTO : departmentDTOs){

            if(departmentDTO.getDepartmentId() == employee
                    .getDepartmentFatherId()){
                model.addAttribute("departmentName",departmentDTO
                        .getDepartmentName());
            }
        }
        for(Employee foo : employees){
            if(foo.getEmployeeId() == id) {
                employee.setEmail(foo.getEmail());
            }
        }
        model.addAttribute("listOfDepartments", departmentDTOs);
        model.addAttribute("employee", employee);
        model.addAttribute("isNew", false);

        return "employee";
    }

    @PostMapping(value = "/employee/{id}")
    public String updateEmployee(@PathVariable Integer id,
                                 @Valid Employee employee,
                                 BindingResult result, Model model){


        if(employee.getEmployeeId() == null) employee.setEmployeeId(id);

        LOGGER.debug("updateEmployee({}, {})", employee, result);
        if (result.hasErrors()) {
            model.addAttribute("listOfDepartments", departmentDTOs);
            return "employee";
        } else {
            this.employeeService.updateEmployee(employee);
            return "redirect:/employees";
        }

    }

    /**
     * Delete department.
     *
     * @return view name
     */
    @GetMapping(value = "/employee/{id}/delete")
    public final String deleteEmployeeById(@PathVariable Integer id, Model model) {
        LOGGER.debug("deleteEmployeeById({},{})", id, model);
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees";
    }

    /**
     *
     * @param model m
     * @return k
     */
    @GetMapping(value = "/employee")
    public final String gotoAddEmployeePage(Model model) {
        LOGGER.debug("gotoAddEmployee({})", model);

        List<DepartmentDTO> departmentDTOs =
                (List<DepartmentDTO>) departmentService.getDepartmentDTOs();

        Employee employee = new Employee();
        model.addAttribute("listOfDepartments", departmentDTOs);
        model.addAttribute("isNew", true);
        model.addAttribute("employee", employee);

        return "employee";
    }



    /**
     * Add
     * @param employee department's to add
     * @param result report about errors
     * @return departments if OK or
     * department is something wrong
     */
    @PostMapping(value = "/employee")
    public String addEmployee(@Valid Employee employee,
                                BindingResult result) {

        LOGGER.debug("addEmployee({}, {})", employee, result);

        if (result.hasErrors()) {
            return "employee";
        } else {
            this.employeeService.addEmployee(employee);
            return "redirect:/employees";
        }
    }
}
