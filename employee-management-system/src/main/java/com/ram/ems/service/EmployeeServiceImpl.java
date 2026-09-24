package com.ram.ems.service;

import com.ram.ems.dto.EmployeeRequestDTO;
import com.ram.ems.dto.EmployeeResponseDTO;
import com.ram.ems.entity.Department;
import com.ram.ems.entity.Employee;
import com.ram.ems.excepction.ResourceNotFoundException;
import com.ram.ems.repository.DepartmentRepository;
import com.ram.ems.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public
class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public EmployeeResponseDTO save(EmployeeRequestDTO employeeRequestDTO) {
        Department department= departmentRepository.findById(employeeRequestDTO.getDepartmentId())
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + employeeRequestDTO.getDepartmentId()));

        Employee employee = new Employee();
        employee.setFirstName(employeeRequestDTO.getFirstName());
        employee.setLastName(employeeRequestDTO.getLastName());
        employee.setMobile(employeeRequestDTO.getMobile());
        employee.setEmail(employeeRequestDTO.getEmail());
        employee.setSalary(employeeRequestDTO.getSalary());

        employee.setDepartment(department);
        Employee savedEmployee = employeeRepository.save(employee);
        return new EmployeeResponseDTO(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail(),
                savedEmployee.getMobile(),
                savedEmployee.getSalary(),
                savedEmployee.getDepartment().getId(),
                savedEmployee.getDepartment().getName()
        );
    }

    @Override
    public List<EmployeeResponseDTO> getAllEmployee() {
        return employeeRepository.findAll().stream()
                .map(employee -> new EmployeeResponseDTO(
                        employee.getId(),
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getEmail(),
                        employee.getMobile(),
                        employee.getSalary(),
                        employee.getDepartment().getId(),
                        employee.getDepartment().getName()
                ))
                .toList();
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: "+ id));
    }

    @Override
    public Employee editEmployee(Long id, Employee employee) {
        Employee employee1 = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        employee1.setMobile(employee.getMobile());
        employee1.setEmail(employee.getEmail());
        employee1.setSalary(employee.getSalary());
        employee1.setDepartment(employee.getDepartment());
        return employeeRepository.save(employee1);
    }

    @Override
    public void DeleteEmployee(Long id) {
        Employee existingEmp = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        employeeRepository.delete(existingEmp);
    }

}
