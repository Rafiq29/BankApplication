package com.herb.bankapp.controller;

import com.herb.bankapp.dto.request.AccountRequestDTO;
import com.herb.bankapp.dto.request.AccountStatusRequestDTO;
import com.herb.bankapp.dto.response.AccountResponseDTO;
import com.herb.bankapp.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {
    private final AccountService service;

    @PostMapping("/add")
    public AccountResponseDTO addAccount(@RequestBody AccountRequestDTO requestDTO) {
        return service.add(requestDTO);
    }

    @PatchMapping("/review")
    public AccountResponseDTO accountRequestReview(@RequestBody AccountStatusRequestDTO requestDTO) {
        return service.requestReview(requestDTO);
    }

    @GetMapping("/{id}")
    public AccountResponseDTO getAccountById(@PathVariable long id) {
        return service.getById(id);
    }

    @GetMapping("/all")
    public List<AccountResponseDTO> getAllAccounts() {
        return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public AccountResponseDTO deleteAccount(@PathVariable long id) {
        return service.delete(id);
    }
}
