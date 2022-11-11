package com.academy.Day3ExerciseTDDSCM.service;

import com.academy.Day3ExerciseTDDSCM.repository.EmployeeRepository;
import com.academy.Day3ExerciseTDDSCM.repository.EmployeeRepositoryFromJSON;
import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository = new EmployeeRepositoryFromJSON();

    public List<Employee> getAllEmployees(){
        return employeeRepository.getAllEmployees();
    }
    public List<Employee> getAllEmployeesThatAreEarningMoreThan(Double amount) {
        return employeeRepository.getAllEmployees().stream().filter(employee -> employee.getSalary() > amount)
                .collect(Collectors.toList());
    }

    public List<Employee> getAllEmployeesExceedingAgeLimit(int age) {
        return employeeRepository.getAllEmployees().stream().filter((employee -> employee.getAge() >= age)).collect(Collectors.toList());
    }

    public List<Employee> getAllEmployeesWithMatchingPosition(String position){
        return employeeRepository.getAllEmployees().stream().filter((employee -> employee.getPosition().equals(position))).collect(Collectors.toList());
    }

    public List<Employee> getEmployeeWithHighestSalary(){
        Double maxSalary  = employeeRepository.getAllEmployees().stream().map(Employee::getSalary).max(Double::compare).get();
        Stream<Employee> employee = employeeRepository.getAllEmployees().stream().filter(emp -> emp.getSalary() == maxSalary);
        return employee.toList();
    }
}
