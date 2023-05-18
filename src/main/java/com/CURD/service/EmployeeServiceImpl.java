package com.CURD.service;

import com.CURD.exception.ResourceNotFoundException;
import com.CURD.model.Employee;
import com.CURD.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
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


//    -------------------------------------------------------------------------------------------------------------
//    @Override
//    public Employee getEmployeeById(Long employeeId) {
//        Employee employee = employeeRepository.findById(employeeId).get();
//
//        return employee;
//    }

    // another way to get employee by ID:
//    @Override
//    public Employee getEmployeeById2(Long employeeId) {
//        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
//
//        return optionalEmployee.get();
//    }
//    -------------------------------------------------------------------------------------------------------------


    //1st: functional way:
//    @Override
//    public Employee getEmployeeById(Long employeeId) {
//        Employee employee = employeeRepository.findById(employeeId)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
//
//        return employee;
//    }



    //2nd: using try catch way:
//    @Override
//    public Employee getEmployeeById(Long employeeId) {
//        Employee employee = null;
//        try {
//            employee = employeeRepository.findById(employeeId)
//                    .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
//        } catch (ResourceNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//
//        return employee;
//    }

    //3rd: Sneaky way:
    @SneakyThrows
    @Override
    public Employee getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        return employee;
    }



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
