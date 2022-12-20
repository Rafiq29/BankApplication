package com.herb.bankapp.mapper;

import com.herb.bankapp.dto.request.CardAddRequestDTO;
import com.herb.bankapp.dto.response.CardResponseDTO;
import com.herb.bankapp.entity.Card;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CardMapper {
    Card toCard(CardAddRequestDTO requestDTO);

    Card toCard(CardResponseDTO requestDTO);

    CardResponseDTO toDto(Card card);
}
