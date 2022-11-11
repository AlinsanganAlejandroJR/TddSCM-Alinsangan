package com.academy.Day3ExerciseTDDSCM.report;

import com.academy.Day3ExerciseTDDSCM.model.Employee;
import com.academy.Day3ExerciseTDDSCM.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeReport implements EmployeeReportInterface{
    @Autowired
    EmployeeService employeeService;

    @Override
    @GetMapping
    public List<Employee> getAllEmployees() {
        List<Employee> allEmployees= employeeService.getAllEmployees();
        return allEmployees;
    }


    @Override
    @GetMapping("/amount/{amount}")
    public List<Employee> getEmployeesEarningMoreThan(@PathVariable Double amount) {
        List<Employee> employeesEarningMoreThan= employeeService.getAllEmployeesThatAreEarningMoreThan(amount);
        return  employeesEarningMoreThan;
    }



    @Override
    @GetMapping("/age/{age}")
    public List<Employee> getAllEmployeesExceedingAgeLimit(@PathVariable Integer age) {
        List<Employee> employeesExceedingAgeLimit= employeeService.getAllEmployeesExceedingAgeLimit(age);
        return employeesExceedingAgeLimit;
    }
}
