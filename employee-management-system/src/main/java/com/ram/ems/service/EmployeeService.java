package com.ram.ems.service;
import com.ram.ems.entity.Employee;

import java.util.List;

public interface EmployeeService {
     public Employee save(Employee employee);
     List<Employee>getAllEmployee();
     public  Employee findById(Long id);
     public Employee editEmployee(Long id, Employee employee);
     public void DeleteEmployee(Long id);
}
