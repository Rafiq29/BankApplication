package com.herb.bankapp.dto.response;

import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponseDTO {
    private HttpStatus status;
    private String error;
    private String message;
    private String path;
}
