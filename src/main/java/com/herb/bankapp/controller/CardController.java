package com.herb.bankapp.controller;

import com.herb.bankapp.dto.request.AccountRequestDTO;
import com.herb.bankapp.dto.response.AccountResponseDTO;
import com.herb.bankapp.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {
    private final AccountService service;

    @PostMapping
    public String addAccount(@RequestBody AccountRequestDTO requestDTO) {
        service.add(requestDTO);
        return "User created!";
    }

    @GetMapping("/{id}")
    public AccountResponseDTO getAccountById(@PathVariable long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<AccountResponseDTO> getAllAccounts() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable long id) {
        service.delete(id);
        return "User deleted!";
    }
}
