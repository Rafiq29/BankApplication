package com.herb.bankapp.dto.request;

import com.herb.bankapp.entity.enums.RequestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountStatusRequestDTO {
    private long id;
    private RequestStatus requestStatus;
}
