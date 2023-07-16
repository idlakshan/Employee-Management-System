package com.ijse.backend.controller;

import com.ijse.backend.dto.EmployeeDto;
import com.ijse.backend.dto.EmployeeUpdateDto;
import com.ijse.backend.service.EmployeeService;
import com.ijse.backend.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
@CrossOrigin("*")
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

    @GetMapping("{id}")
    public ResponseEntity<StandardResponse> getEmployeeById(@PathVariable long id){
        EmployeeDto employeeDto=employeeService.getEmployeeById(id);
        return new ResponseEntity<>(new StandardResponse(200,"Success..!",employeeDto),
                HttpStatus.OK );

    }

    @PutMapping("{id}")
    public ResponseEntity<StandardResponse> updateEmployee(@RequestBody EmployeeUpdateDto employeeUpdateDto, @PathVariable long id){
        EmployeeUpdateDto updateEmployee = employeeService.updateEmployee(employeeUpdateDto, id);
        return new ResponseEntity<>(new StandardResponse(201,"Updated..!",updateEmployee),
                HttpStatus.CREATED );
    }

    @DeleteMapping("{id}")
    public ResponseEntity<StandardResponse> deleteEmployee(@PathVariable long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(new StandardResponse(204,"Deleted..!",null),
                HttpStatus.NO_CONTENT );
    }

}
