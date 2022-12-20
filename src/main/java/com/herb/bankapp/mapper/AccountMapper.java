package com.herb.bankapp.mapper;

import com.herb.bankapp.dto.request.AccountRequestDTO;
import com.herb.bankapp.dto.response.AccountResponseDTO;
import com.herb.bankapp.entity.Account;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface AccountMapper {
    Account toAccount(AccountRequestDTO requestDTO);

    Account toAccount(AccountResponseDTO responseDTO);

    AccountResponseDTO toDto(Account account);
}
