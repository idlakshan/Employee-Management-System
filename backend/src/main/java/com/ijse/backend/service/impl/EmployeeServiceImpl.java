package com.ijse.backend.service.impl;

import com.ijse.backend.dto.EmployeeDto;
import com.ijse.backend.dto.EmployeeUpdateDto;
import com.ijse.backend.entity.Employee;
import com.ijse.backend.exception.ResourceNotFoundException;
import com.ijse.backend.repo.EmployeeRepo;
import com.ijse.backend.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        employeeRepo.save(employee);
        return employeeDto;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employeeList = employeeRepo.findAll();
        if (employeeList.size()>0){
            List<EmployeeDto> employeeDtos = modelMapper.map(employeeList, new TypeToken<List<EmployeeDto>>() {
            }.getType());
            return employeeDtos;
        }
       throw new ResourceNotFoundException("Not Employees found");
    }

    @Override
    public EmployeeDto getEmployeeById(long id) {
        if(employeeRepo.existsById(id)){
            Employee employee = employeeRepo.getReferenceById(id);
            EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
            return employeeDto;
        }
     throw new ResourceNotFoundException("Employee Not Found");
    }

    @Override
    public EmployeeUpdateDto updateEmployee(EmployeeUpdateDto employeeUpdateDto, long id) {
        if (employeeRepo.existsById(id)){
            Employee employee = employeeRepo.getReferenceById(id);
            modelMapper.map(employeeUpdateDto,employee);
            employeeRepo.save(employee);

            return employeeUpdateDto;
        }
        throw new ResourceNotFoundException("Employee Not Found");
    }

    @Override
    public void deleteEmployee(long id) {
         employeeRepo.deleteById(id);
    }
}
