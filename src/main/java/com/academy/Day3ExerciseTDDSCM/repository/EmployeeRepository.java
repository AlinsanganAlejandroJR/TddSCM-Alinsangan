package com.academy.Day3ExerciseTDDSCM.repository;

import com.academy.Day3ExerciseTDDSCM.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository {
    List<Employee> getAllEmployees();
}
