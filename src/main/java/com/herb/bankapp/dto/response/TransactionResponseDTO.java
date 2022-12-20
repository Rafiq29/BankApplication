package com.herb.bankapp.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private String method;
    private String description;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime date;
    private Boolean status;
    private UserResponseDTO user;
}
