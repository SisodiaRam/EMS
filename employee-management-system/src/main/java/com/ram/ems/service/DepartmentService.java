package com.ram.ems.service;

import com.ram.ems.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department addDepartment(Department department);
    public List<Department> getDepartment();
    public Department findDepartmentById(Long id);
    public Department updatedepartment(Long id, Department department);
    public void deleteDepartment(Long id);
}
