package com.CURD.service;

import com.CURD.exception.ResourceNotFoundException;
import com.CURD.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long employeeId);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(Long employeeId);

}
