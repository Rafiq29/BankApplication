package com.herb.bankapp.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponseDTO {
    @ApiModelProperty(notes = "Transaction Method")
    private String method;
    @ApiModelProperty(notes = "Transaction Description")
    private String description;
    @ApiModelProperty(notes = "Transaction Date")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime date;
    @ApiModelProperty(notes = "Transaction Status")
    private Boolean status;
    @ApiModelProperty(notes = "User that made Transaction")
    private UserResponseDTO user;
}
