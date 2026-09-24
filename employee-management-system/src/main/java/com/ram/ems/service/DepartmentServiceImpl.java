package com.ram.ems.service;

import com.ram.ems.entity.Department;
import com.ram.ems.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findDepartmentById(Long id) {
        return departmentRepository.findById(id).orElseThrow(()-> new RuntimeException("this id does not exist:"+id));
    }

    @Override
    public Department updatedepartment(Long id, Department department) {
        Department existingDepartment= departmentRepository.findById(id).orElseThrow(()-> new RuntimeException("This Id does not exist:"+id));
        existingDepartment.setName(department.getName());
        existingDepartment.setLocation(department.getLocation());
        return departmentRepository.save(existingDepartment);
    }

    @Override
    public void deleteDepartment(Long id) {
        Department previoudDepartment =departmentRepository.findById(id).orElseThrow(()-> new RuntimeException(" Department not found:"+id));
        if (!previoudDepartment.getEmployees().isEmpty()){
            throw new RuntimeException("department cannot be deleted because employee are assign to :");
        }
        departmentRepository.delete(previoudDepartment);
    }
}
