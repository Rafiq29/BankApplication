package com.herb.bankapp.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequestDTO {
    @ApiModelProperty(notes = "Account Number")
    private int number;
    @ApiModelProperty(notes = "Account Iban Number")
    private int iban;
    @ApiModelProperty(notes = "Account Swift Number")
    private String swift;
    @ApiModelProperty(notes = "Account Holder First Name")
    private String holder_firstname;
    @ApiModelProperty(notes = "Account Holder Last Name")
    private String holder_lastname;
}
