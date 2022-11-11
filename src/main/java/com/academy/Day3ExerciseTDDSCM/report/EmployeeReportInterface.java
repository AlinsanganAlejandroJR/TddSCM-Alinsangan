package com.academy.Day3ExerciseTDDSCM.report;

import com.academy.Day3ExerciseTDDSCM.model.Employee;

import java.util.List;

public interface EmployeeReportInterface {
    List<Employee> getEmployeesEarningMoreThan (Double amount);
    List<Employee> getAllEmployees ();
    List<Employee> getAllEmployeesExceedingAgeLimit(Integer age);
}
