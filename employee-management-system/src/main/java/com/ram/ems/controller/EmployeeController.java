package com.ram.ems.controller;

import com.ram.ems.dto.EmployeeRequestDTO;
import com.ram.ems.dto.EmployeeResponseDTO;
import com.ram.ems.entity.Employee;
import com.ram.ems.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Employee Management",
        description = "APIs for managing employees")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Operation(
            summary = "Create a new employee",
            description = "Creates a new employee and associates the employee with a department"
    )
    @PostMapping
    public EmployeeResponseDTO createEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO) {
        return employeeService.save(employeeRequestDTO);
    }

    @Operation(
            summary = "Get all employees",
            description = "Retrieves a list of all employees in the system"
    )
    @GetMapping
    public List<EmployeeResponseDTO> getEmployee() {
        return employeeService.getAllEmployee();
    }

    @Operation(
            summary = "Get employee by ID",
            description = "Retrieves an employee by their unique identifier"
    )
    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id) {
        return employeeService.findById(id);
    }

    @Operation(
            summary = "Update employee",
            description = "Updates the details of an existing employee"
    )
    @PutMapping("/{id}")
    public Employee editEmployee(@PathVariable Long id, @RequestBody Employee employee) {

        return employeeService.editEmployee(id, employee);
    }

    @Operation(
            summary = "Delete employee",
            description = "Deletes an employee by their unique identifier"
    )
    @DeleteMapping("/{id}")
    public String deleteEmp(@PathVariable Long id) {
        employeeService.DeleteEmployee(id);
        return "Employee delete successfully";
    }
}
