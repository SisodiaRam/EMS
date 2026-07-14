package com.ram.ems.controller;

import com.ram.ems.entity.Department;
import com.ram.ems.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public Department addDepartment(Department department){
        return departmentService.addDepartment(department);
    }
    @GetMapping
    public List<Department>getDepartment(){
        return departmentService.getDepartment();
    }
}
