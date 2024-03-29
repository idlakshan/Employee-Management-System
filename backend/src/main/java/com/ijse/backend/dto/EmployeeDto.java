package com.ijse.backend.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class EmployeeDto {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
}
