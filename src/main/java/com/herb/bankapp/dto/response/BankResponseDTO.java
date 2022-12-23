package com.herb.bankapp.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankResponseDTO {
    @ApiModelProperty(notes = "Bank name")
    private String name = "AFB BANK";
    @ApiModelProperty(notes = "Bank description")
    private String description = "AFB Bank OJSC, licensed  №253 by the Central Bank of Azerbaijan on November 28, " +
            "2008, has been operating since February 16, 2009. Pursuant to Article 19 of the Law on Banks, AFB Bank " +
            "was established as an Open Joint Stock Company as a Bank. As one of the subjects of the Azerbaijani " +
            "banking market, AFB Bank Open Joint Stock Company, in addition to supporting the country's economy and " +
            "the monetary policy of our government, always prefers efficient and restrained, low-risk and measured " +
            "activities aimed at dynamic development. The term of the bank is not limited in time.The Bank is " +
            "engaged in all types of activities not prohibited by the banking license obtained from the Central Bank " +
            "of the Republic of Azerbaijan.";
}
