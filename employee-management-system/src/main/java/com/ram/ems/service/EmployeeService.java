package com.ram.ems.service;
import com.ram.ems.dto.EmployeeRequestDTO;
import com.ram.ems.dto.EmployeeResponseDTO;
import com.ram.ems.entity.Employee;

import java.util.List;

public interface EmployeeService {
     public EmployeeResponseDTO save(EmployeeRequestDTO employeeRequestDTO);
     List<EmployeeResponseDTO>getAllEmployee();
     public  Employee findById(Long id);
     public Employee editEmployee(Long id, Employee employee);
     public void DeleteEmployee(Long id);
}
