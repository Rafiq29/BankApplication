package com.herb.task.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExceptionResponseDTO {
    private HttpStatus status;
    private String error;
    private String message;
    private String path;
}
