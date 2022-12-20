package com.herb.bankapp.service;

import com.herb.bankapp.dto.request.UserRequestDTO;
import com.herb.bankapp.dto.request.UserRoleChangeRequestDTO;
import com.herb.bankapp.dto.response.TransactionResponseDTO;
import com.herb.bankapp.dto.response.UserResponseDTO;
import com.herb.bankapp.entity.User;
import com.herb.bankapp.error.CustomException;
import com.herb.bankapp.mapper.TransactionMapper;
import com.herb.bankapp.mapper.UserMapper;
import com.herb.bankapp.repo.TransactionRepo;
import com.herb.bankapp.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepo repo;
    private final PasswordEncoder encoder;
    private final UserMapper mapper;
    private final TransactionRepo transactionRepo;
    private final TransactionMapper transactionMapper;

    public UserResponseDTO add(UserRequestDTO requestDTO) {
        User user;
        if (repo.findUserByUsername(requestDTO.getUsername()).isEmpty()) {
            user = mapper.toUser(requestDTO);
            user.setPassword(encoder.encode(requestDTO.getPassword()));
        } else {
            logger.error("User already exists");
            throw new CustomException("User already exists");
        }
        repo.save(user);
        return mapper.toDto(user);
    }

    public UserResponseDTO getById(long id) {
        User user = repo
                .findById(id)
                .filter(User::getStatus)
                .orElseThrow(() -> new CustomException("Cannot get user!"));
        return mapper.toDto(user);
    }

    public List<UserResponseDTO> getAll() {
        return repo.findAll()
                .stream()
                .filter(User::getStatus)
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public UserResponseDTO delete(long id) {
        User user = repo.findById(id).orElseThrow(() -> new CustomException("Cannot get user!"));
        user.setStatus(false);
        repo.save(user);
        return mapper.toDto(user);
    }

    public List<TransactionResponseDTO> history() {
        return transactionRepo.findAll()
                .stream()
                .map(transactionMapper::toDto)
                .collect(Collectors.toList());
    }

    public UserResponseDTO changeRole(UserRoleChangeRequestDTO requestDTO) {
        User user = repo.findById(requestDTO.getId()).orElseThrow(() -> new CustomException("Cannot get user!"));
        user.setRole(requestDTO.getRole());
        return mapper.toDto(user);
    }
}
