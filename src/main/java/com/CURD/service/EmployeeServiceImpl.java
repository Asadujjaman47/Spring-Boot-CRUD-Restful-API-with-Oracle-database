package com.CURD.service;

import com.CURD.exception.ResourceNotFoundException;
import com.CURD.model.Employee;
import com.CURD.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;


    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();

        return employee;
    }


    // another way to get employee by ID:
//    @Override
//    public Employee getEmployeeById2(Long employeeId) {
//        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
//
//        return optionalEmployee.get();
//    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Employee existingEmployee = employeeRepository.findById(employee.getId()).get();
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmailId(employee.getEmailId());

        Employee updatedEmployee = employeeRepository.save(existingEmployee);

        return updatedEmployee;
    }

    @Override
    public void deleteEmployee(Long employeeId) {

        employeeRepository.deleteById(employeeId);
    }

    // another way to delete:
//    @Override
//    public void deleteEmployee(Long employeeId) {
//        Employee employee = employeeRepository.findById(employeeId).get();
//
//        employeeRepository.delete(employee);
//
//    }

}
