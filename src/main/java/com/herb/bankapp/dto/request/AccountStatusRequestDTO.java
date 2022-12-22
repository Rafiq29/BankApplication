package com.herb.bankapp.dto.request;

import com.herb.bankapp.entity.enums.RequestStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountStatusRequestDTO {
    @ApiModelProperty(notes = "Account ID")
    private long id;
    @ApiModelProperty(notes = "Account Request Status (REJECTED, WAITING, ACCEPTED)")
    private RequestStatus requestStatus;
}
