package com.ijse.backend.controller;

import com.ijse.backend.dto.EmployeeDto;
import com.ijse.backend.service.EmployeeService;
import com.ijse.backend.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
@CrossOrigin
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<StandardResponse> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto saveEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(new StandardResponse(201,"Saved..!",saveEmployee),
                HttpStatus.CREATED );
    }

    @GetMapping
    public ResponseEntity<StandardResponse> getAllEmployee(){
        List<EmployeeDto> allEmployees = employeeService.getAllEmployees();
        return new ResponseEntity<>(new StandardResponse(200,"Saved..!",allEmployees),
                HttpStatus.OK );
    }
}
