package com.academy.Day3ExerciseTDDSCM.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Employee;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class EmployeeRepositoryFromJSON implements EmployeeRepository{
    @Override
    public List<Employee> getAllEmployees() {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream is = classLoader.getResourceAsStream("employee.json");
            ObjectMapper mapper = new ObjectMapper();
            List<Employee> employee = mapper.readValue(is, new TypeReference<List<Employee>>() {});
            return employee;

        }catch (IOException e){
            return null;
        }
    }
}
