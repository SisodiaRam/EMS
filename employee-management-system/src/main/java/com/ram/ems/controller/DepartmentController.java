package com.ram.ems.controller;

import com.ram.ems.entity.Department;
import com.ram.ems.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(
        name = "Department Management",
        description = "APIs for managing departments")
@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
   @Operation(
              summary = "Create a new department",
                description = "Creates a new department in the system"
   )
    @PostMapping
    public Department addDepartment(@RequestBody Department department){
        return departmentService.addDepartment(department);
    }
    @Operation(
            summary = "Get all departments",
            description = "Retrieves a list of all departments in the system"
    )
    @GetMapping
    public List<Department>getDepartment(){
        return departmentService.getDepartment();
    }
    @Operation(
            summary = "Get department by ID",
            description = "Retrieves a department by their unique identifier"
    )
    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable Long id){
        return departmentService.findDepartmentById(id);
    }
    @Operation(
            summary = "Update department",
            description = "Updates the details of an existing department"
    )
    @PutMapping("/{id}")
    public Department updatedepartment(@PathVariable Long id, @RequestBody Department department){
        return departmentService.updatedepartment(id,department);
    }
    @Operation(
            summary = "Delete department",
            description = "Deletes a department by their unique identifier"
    )
    @DeleteMapping("/{id}")
    public String deleteDept(@PathVariable Long id){
        departmentService.deleteDepartment(id);
        return "department delete successfully";
    }
}
