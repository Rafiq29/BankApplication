package com.herb.bankapp.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthResponseDTO {
    @ApiModelProperty(notes = "User Username")
    private String username;
    @ApiModelProperty(notes = "User Password")
    private String password;
}
