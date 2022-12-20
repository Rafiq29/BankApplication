package com.herb.bankapp.mapper;

import com.herb.bankapp.dto.request.UserRequestDTO;
import com.herb.bankapp.dto.response.UserAuthResponseDTO;
import com.herb.bankapp.dto.response.UserResponseDTO;
import com.herb.bankapp.entity.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    User toUser(UserRequestDTO requestDTO);

    User toUser(UserResponseDTO responseDTO);

    UserResponseDTO toDto(User user);

    UserAuthResponseDTO toAuthDto(User user);
}
