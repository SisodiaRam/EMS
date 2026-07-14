package com.ram.ems.service;

import com.ram.ems.entity.Employee;
import com.ram.ems.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public
class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("This id does not exist"));
    }

    @Override
    public Employee editEmployee(Long id, Employee employee) {
       Employee employee1= employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Employee not found with this ID: "+id));
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
        Employee existingEmp = employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("employee not found with this Id: "+id));
        employeeRepository.delete(existingEmp);
    }


}
