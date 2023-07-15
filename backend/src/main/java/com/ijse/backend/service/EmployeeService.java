package com.ijse.backend.service;

import com.ijse.backend.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> getAllEmployees();

}
