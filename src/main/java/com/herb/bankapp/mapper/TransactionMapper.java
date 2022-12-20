package com.herb.bankapp.mapper;

import com.herb.bankapp.dto.response.TransactionResponseDTO;
import com.herb.bankapp.entity.Transaction;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TransactionMapper {
    Transaction toTransaction(TransactionResponseDTO responseDTO);

    TransactionResponseDTO toDto(Transaction transaction);
}
