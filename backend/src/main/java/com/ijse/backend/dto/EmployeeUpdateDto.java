package com.ijse.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeUpdateDto {
    private String firstName;
    private String lastName;
    private String email;
}
