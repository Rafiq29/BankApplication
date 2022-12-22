package com.herb.bankapp.dto.response;

import com.herb.bankapp.entity.enums.RequestStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponseDTO {
    @ApiModelProperty(notes = "Account IBAN")
    private int iban;
    @ApiModelProperty(notes = "Account Number")
    private int number;
    @ApiModelProperty(notes = "Account Holder First Name")
    private String holder_firstname;
    @ApiModelProperty(notes = "Account Holder Last Name")
    private String holder_lastname;
    @ApiModelProperty(notes = "Cards Attached to Account")
    private List<CardResponseDTO> cards;
    @ApiModelProperty(notes = "User Attached to Account")
    private UserResponseDTO user;
    @ApiModelProperty(notes = "Account Request Status (REJECTED, WAITING, ACCEPTED)")
    private RequestStatus requestStatus;
}
