package com.herb.bankapp.controller;

import com.herb.bankapp.dto.request.CardAddRequestDTO;
import com.herb.bankapp.dto.request.CardBalanceChangeRequestDTO;
import com.herb.bankapp.dto.request.CardBalanceRequestDTO;
import com.herb.bankapp.dto.request.CardStatusRequestDTO;
import com.herb.bankapp.dto.response.CardResponseDTO;
import com.herb.bankapp.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/card")
public class CardController {
    private final CardService service;

    @PostMapping("/add")
    public CardResponseDTO addCard(@RequestBody CardAddRequestDTO requestDTO) {
        return service.add(requestDTO);
    }

    @GetMapping("/{id}")
    public CardResponseDTO getCardById(@PathVariable long id) {
        return service.getById(id);
    }

    @GetMapping("/all")
    public List<CardResponseDTO> getAllCards() {
        return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public CardResponseDTO deleteCard(@PathVariable long id) {
        return service.delete(id);
    }

    @PatchMapping("/deposit")
    public CardResponseDTO deposit(@RequestBody CardBalanceRequestDTO requestDTO) {
        return service.deposit(requestDTO);
    }

    @PatchMapping("/withdrawal")
    public CardResponseDTO withdrawal(@RequestBody CardBalanceRequestDTO requestDTO) {
        return service.withdrawalBetweenCards(requestDTO);
    }

    @PatchMapping("/balance")
    public CardResponseDTO changeCardBalance(@RequestBody CardBalanceChangeRequestDTO requestDTO) {
        return service.changeBalance(requestDTO);
    }

    @PatchMapping("/review")
    public CardResponseDTO cardRequestReview(@RequestBody CardStatusRequestDTO requestDTO) {
        return service.requestReview(requestDTO);
    }
}
