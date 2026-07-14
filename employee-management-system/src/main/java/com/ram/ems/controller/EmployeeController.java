package com.ram.ems.controller;

import com.ram.ems.entity.Employee;
import com.ram.ems.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
       return employeeService.save(employee);
    }
    @GetMapping
    public List<Employee> getEmployee(){
        return employeeService.getAllEmployee();
    }
    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id){
        return employeeService.findById(id);
    }
    @PutMapping("/{id}")
    public Employee editEmployee(@PathVariable Long id, @RequestBody Employee employee){
        return employeeService.editEmployee(id,employee);
    }
    @DeleteMapping("/{id}")
    public String deleteEmp(@PathVariable Long id){
        employeeService.DeleteEmployee(id);
        return "Employee delete successfully";
    }
}
