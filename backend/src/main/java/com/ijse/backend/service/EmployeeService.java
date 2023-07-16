package com.ijse.backend.service;

import com.ijse.backend.dto.EmployeeDto;
import com.ijse.backend.dto.EmployeeUpdateDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto getEmployeeById(long id);

    EmployeeUpdateDto updateEmployee(EmployeeUpdateDto employeeUpdateDto, long id);

    void deleteEmployee(long id);

}
