package com.herb.bankapp.controller;

import com.herb.bankapp.dto.request.CardAddRequestDTO;
import com.herb.bankapp.dto.request.CardBalanceChangeRequestDTO;
import com.herb.bankapp.dto.request.CardBalanceRequestDTO;
import com.herb.bankapp.dto.request.CardStatusRequestDTO;
import com.herb.bankapp.dto.response.CardResponseDTO;
import com.herb.bankapp.service.CardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/card")
@Api(value = "Card Related APIs")
public class CardController {
    private final CardService service;

    @ApiOperation(value = "Add a card")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Cannot get user"),
            @ApiResponse(code = 500, message = "Unknown error")
    })
    @PostMapping("/add")
    public CardResponseDTO addCard(@RequestBody CardAddRequestDTO requestDTO) {
        return service.add(requestDTO);
    }

    @ApiOperation(value = "Get card by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Cannot get card"),
            @ApiResponse(code = 500, message = "Unknown error")
    })
    @GetMapping("/{id}")
    public CardResponseDTO getCardById(@PathVariable long id) {
        return service.getById(id);
    }

    @ApiOperation(value = "Get a list of all cards")
    @ApiResponse(code = 500, message = "Unknown error")
    @GetMapping("/all")
    public List<CardResponseDTO> getAllCards() {
        return service.getAll();
    }

    @ApiOperation(value = "Delete a card. Card becomes inactive")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Cannot get card"),
            @ApiResponse(code = 500, message = "Unknown error")
    })
    @DeleteMapping("/delete/{id}")
    public CardResponseDTO deleteCard(@PathVariable long id) {
        return service.delete(id);
    }

    @ApiOperation(value = "Add a balance to the specified card. Card request must be ACCEPTED")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Cannot get card"),
            @ApiResponse(code = 500, message = "Unknown error")
    })
    @PatchMapping("/deposit")
    public CardResponseDTO deposit(@RequestBody CardBalanceRequestDTO requestDTO) {
        return service.deposit(requestDTO);
    }

    @ApiOperation(value = "Withdraw from card to other specified card. Card request must be ACCEPTED")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Cannot get card"),
            @ApiResponse(code = 400, message = "Cannot withdraw from card"),
            @ApiResponse(code = 500, message = "Unknown error")
    })
    @PatchMapping("/withdrawal")
    public CardResponseDTO withdrawal(@RequestBody CardBalanceRequestDTO requestDTO) {
        return service.withdrawalBetweenCards(requestDTO);
    }

    @ApiOperation(value = "Change the balance of specified card. Can be changed by ADMIN")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Cannot get card"),
            @ApiResponse(code = 500, message = "Unknown error")
    })
    @PatchMapping("/balance")
    public CardResponseDTO changeCardBalance(@RequestBody CardBalanceChangeRequestDTO requestDTO) {
        return service.changeBalance(requestDTO);
    }

    @ApiOperation(value = "Review a CUSTOMER request. Can be reviewed by EMPLOYEE or ADMIN")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Cannot get card"),
            @ApiResponse(code = 500, message = "Unknown error")
    })
    @PatchMapping("/review")
    public CardResponseDTO cardRequestReview(@RequestBody CardStatusRequestDTO requestDTO) {
        return service.requestReview(requestDTO);
    }
}
