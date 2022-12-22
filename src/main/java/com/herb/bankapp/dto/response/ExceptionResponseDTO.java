package com.herb.bankapp.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponseDTO {
    @ApiModelProperty("Exception Status")
    private HttpStatus status;
    @ApiModelProperty("Exception Error")
    private String error;
    @ApiModelProperty("Exception Message")
    private String message;
    @ApiModelProperty("Exception Path")
    private String path;
}
