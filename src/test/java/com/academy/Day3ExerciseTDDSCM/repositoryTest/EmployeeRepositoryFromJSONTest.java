package com.academy.Day3ExerciseTDDSCM.repositoryTest;

import com.academy.Day3ExerciseTDDSCM.repository.EmployeeRepository;
import com.academy.Day3ExerciseTDDSCM.repository.EmployeeRepositoryFromJSON;

import model.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeRepositoryFromJSONTest {

    @Test
    @DisplayName("GIVEN a JSON in employee.json"+
                "WHEN EmployeeRepositoryFromJSON is executed"+
                "THEN it should return valid Employee objects")
    public void getAllEmployeesFromJSON() {
        //ARRANGE
        EmployeeRepository employeeRepository = new EmployeeRepositoryFromJSON();
        //ACT
        List<Employee> expectedEmployees = List.of(new Employee("Wayne",30,100000d,"Tech Lead"),
                new Employee("Alejandro",20,20000d,"JR Software Engineer"),
                new Employee("Don",23,23000d,"JR Software Engineer"));

        List<Employee> employeesFromJSON = employeeRepository.getAllEmployees();

        //ASSERT
        assertEquals(expectedEmployees,employeesFromJSON);
    }
}
