package com.herb.bankapp.service;

import com.herb.bankapp.dto.request.AccountRequestDTO;
import com.herb.bankapp.dto.request.AccountStatusRequestDTO;
import com.herb.bankapp.dto.response.AccountResponseDTO;
import com.herb.bankapp.entity.Account;
import com.herb.bankapp.entity.User;
import com.herb.bankapp.error.CustomException;
import com.herb.bankapp.mapper.AccountMapper;
import com.herb.bankapp.repo.AccountRepo;
import com.herb.bankapp.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepo repo;
    private final AccountMapper mapper;
    private final UserRepo userRepo;

    public AccountResponseDTO add(AccountRequestDTO requestDTO) {
        Account account = mapper.toAccount(requestDTO);
        User user = userRepo.findUserByFirstnameAndLastname(requestDTO.getHolder_firstname(),
                requestDTO.getHolder_lastname()).orElseThrow(() -> new CustomException("Cannot get user!"));
        account.setUser(user);
        repo.save(account);
        return mapper.toDto(account);
    }

    public AccountResponseDTO requestReview(AccountStatusRequestDTO requestDTO) {
        Account account = repo.findById(requestDTO.getId())
                .orElseThrow(() -> new CustomException("Cannot get account!"));
        account.setRequestStatus(requestDTO.getRequestStatus());
        repo.save(account);
        return mapper.toDto(account);
    }

    public AccountResponseDTO getById(long id) {
        Account account = repo.findById(id)
                .filter(Account::getStatus)
                .orElseThrow(() -> new CustomException("Cannot get account!"));
        return mapper.toDto(account);
    }

    public List<AccountResponseDTO> getAll() {
        return repo.findAll()
                .stream()
                .filter(Account::getStatus)
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public AccountResponseDTO delete(long id) {
        Account account = repo.findById(id).orElseThrow(() -> new CustomException("Cannot get account!"));
        account.setStatus(false);
        repo.save(account);
        return mapper.toDto(account);
    }
}
