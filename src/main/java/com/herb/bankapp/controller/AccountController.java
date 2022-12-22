package com.herb.bankapp.controller;

import com.herb.bankapp.dto.request.AccountRequestDTO;
import com.herb.bankapp.dto.request.AccountStatusRequestDTO;
import com.herb.bankapp.dto.response.AccountResponseDTO;
import com.herb.bankapp.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
@Api(value = "Account Related APIs")
public class AccountController {
    private final AccountService service;

    @ApiOperation(value = "Create an account")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Cannot get user"),
            @ApiResponse(code = 500, message = "Unknown error")
    })
    @PostMapping("/add")
    public AccountResponseDTO addAccount(@RequestBody AccountRequestDTO requestDTO) {
        return service.add(requestDTO);
    }

    @ApiOperation(value = "Review a CUSTOMER request. Can be reviewed by EMPLOYEE or ADMIN")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Cannot get account"),
            @ApiResponse(code = 500, message = "Unknown error")
    })
    @PatchMapping("/review")
    public AccountResponseDTO accountRequestReview(@RequestBody AccountStatusRequestDTO requestDTO) {
        return service.requestReview(requestDTO);
    }

    @ApiOperation(value = "Get an account by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Cannot get account"),
            @ApiResponse(code = 500, message = "Unknown error")
    })
    @GetMapping("/{id}")
    public AccountResponseDTO getAccountById(@PathVariable long id) {
        return service.getById(id);
    }

    @ApiOperation(value = "Get a list of all accounts")
    @GetMapping("/all")
    public List<AccountResponseDTO> getAllAccounts() {
        return service.getAll();
    }

    @ApiOperation(value = "Delete an account. Account becomes inactive")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Cannot get account"),
            @ApiResponse(code = 500, message = "Unknown error")
    })
    @DeleteMapping("/delete/{id}")
    public AccountResponseDTO deleteAccount(@PathVariable long id) {
        return service.delete(id);
    }
}
