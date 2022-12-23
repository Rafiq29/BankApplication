package com.herb.bankapp.controller;

import com.herb.bankapp.dto.response.BankResponseDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class BankController {

    @ApiOperation("Get Bank Information")
    @ApiResponse(code = 500, message = "Unknown error")
    @GetMapping("/info")
    public BankResponseDTO info() {
        return new BankResponseDTO();
    }
}
