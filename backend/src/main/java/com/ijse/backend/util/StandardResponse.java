package com.ijse.backend.util;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StandardResponse {
    private int code;
    private String message;
    private Object data;
}
