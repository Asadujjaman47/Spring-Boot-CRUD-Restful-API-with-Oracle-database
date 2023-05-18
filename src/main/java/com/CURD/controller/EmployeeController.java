package com.CURD.controller;

import com.CURD.exception.ResourceNotFoundException;
import com.CURD.model.Employee;
import com.CURD.repository.EmployeeRepository;
import com.CURD.service.EmployeeService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/test")
    public String GetList(){
        return "Hello World";
    }

    @PostMapping("/employees")
    public Employee createEmployee(@Validated @RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }


    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }


    // normal way:
//    @GetMapping("/employees/{id}")
//    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId){
//        Employee employee = employeeService.getEmployeeById(employeeId);
//
//        return ResponseEntity.ok().body(employee);
//    }

//    @GetMapping("/employees/{id}")
//    public Employee getEmployeeById(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException {
//        return employeeService.getEmployeeById(employeeId);
//    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable(value = "id") Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }


    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                   @Validated @RequestBody Employee employeeDetails)
            {

        employeeDetails.setId(employeeId);
        Employee updatedEmployee = employeeService.updateEmployee(employeeDetails);

        return ResponseEntity.ok(updatedEmployee);
    }


//    @DeleteMapping("/employees/{id}")
//    public ResponseEntity<String> deleteUser(@PathVariable("id") Long employeeId) {
//        employeeService.deleteEmployee(employeeId);
//
//        return ResponseEntity.ok("employee deleted successfully!");
//    }

    // another way
    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId){

        employeeService.deleteEmployee(employeeId);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}
