package com.academy.Day3ExerciseTDDSCM.serviceTest;

import com.academy.Day3ExerciseTDDSCM.repository.EmployeeRepository;
import com.academy.Day3ExerciseTDDSCM.service.EmployeeService;
import com.academy.Day3ExerciseTDDSCM.model.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService = new EmployeeService();

    Employee wayne = new Employee("Wayne", 30, 50000d, "Tech Lead");
    Employee alejandro = new Employee("alejandro",20,20000d,"JR Software Engineer");
    Employee don = new Employee("Don",23,23000d,"JR Software Engineer");

    List<Employee> employees = List.of(wayne,alejandro,don);

    @Test
    @DisplayName("Given employees from repository with the setup above " +
            "WHEN getAllEmployeesThaAreEarningMoreThan is executed with input 49000" +
            "THEN result should return wayne")
    void testEmployeesEarningMoreThanAmount() {
        //arrange
        Mockito.when(employeeRepository.getAllEmployees()).thenReturn(employees);
        //act
        List<Employee> filteredEmployees = employeeService.getAllEmployeesThatAreEarningMoreThan(49000d);
        //assert
        assertThat(filteredEmployees).contains(wayne);
    }

    @Test
    @DisplayName("Given employees from repository with the setup above"+
            "WHEN getAllEmployeesExceedingAgeLimit is executed with input 29"+
            "THEN result should return wayne")
    public void testEmployeesExceedingAgeLimit() {
        //ARRANGE
        Mockito.when(employeeRepository.getAllEmployees()).thenReturn(employees);
        //ACT
        List<Employee> filteredEmployees = employeeService.getAllEmployeesExceedingAgeLimit(29);
        //ASSERT
        assertThat(filteredEmployees).contains(wayne);
    }

    @Test
    @DisplayName("Given employees from repository with the setup above " +
            "WHEN getAllEmployeesThatHaveMatchingPosition is executed with input JR Software Engineer" +
            "THEN result should return alejandro & don")
    public void testAllEmployeesWithMatchingPosition() {
        //ARRANGE
        Mockito.when(employeeRepository.getAllEmployees()).thenReturn(employees);
        //ACT
        List<Employee> filteredEmployees = employeeService.getAllEmployeesWithMatchingPosition("JR Software Engineer");
        //ASSERT
        assertThat(filteredEmployees).contains(alejandro,don);
    }

    @Test
    @DisplayName("Given employees from repository with the setup above " +
            "WHEN getEmployeeWithHighestSalary is executed" +
            "THEN result should return wayne")
    public void testAllEmployeeWithHighestSalary() {
        //ARRANGE
        Mockito.when(employeeRepository.getAllEmployees()).thenReturn(employees);
        //ACT
        List<Employee> filteredEmployees = employeeService.getEmployeeWithHighestSalary();
        //ASSERT
        assertThat(filteredEmployees).contains(wayne);
    }
}
