package com.herb.bankapp.service;

import com.herb.bankapp.dto.request.CardAddRequestDTO;
import com.herb.bankapp.dto.request.CardBalanceChangeRequestDTO;
import com.herb.bankapp.dto.request.CardBalanceRequestDTO;
import com.herb.bankapp.dto.request.CardStatusRequestDTO;
import com.herb.bankapp.dto.response.CardResponseDTO;
import com.herb.bankapp.entity.Account;
import com.herb.bankapp.entity.Card;
import com.herb.bankapp.entity.Transaction;
import com.herb.bankapp.entity.User;
import com.herb.bankapp.entity.enums.RequestStatus;
import com.herb.bankapp.error.CustomException;
import com.herb.bankapp.mapper.CardMapper;
import com.herb.bankapp.repo.AccountRepo;
import com.herb.bankapp.repo.CardRepo;
import com.herb.bankapp.repo.TransactionRepo;
import com.herb.bankapp.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardService {
    private static final Logger logger = LoggerFactory.getLogger(CardService.class);
    private final CardRepo repo;
    private final CardMapper mapper;
    private final UserRepo userRepo;
    private final AccountRepo accountRepo;
    private final TransactionRepo transactionRepo;

    public CardResponseDTO add(CardAddRequestDTO requestDTO) {
        User user = userRepo.findUserByFirstnameAndLastname(requestDTO.getHolder_firstname(),
                requestDTO.getHolder_lastname()).orElseThrow(() -> new CustomException("Cannot get user!"));
        Account account = accountRepo.findAccountByUser(user);
        Card card = mapper.toCard(requestDTO);
        card.setAccount(account);
        repo.save(card);
        return mapper.toDto(card);
    }

    public CardResponseDTO requestReview(CardStatusRequestDTO requestDTO) {
        Card card = repo.findById(requestDTO.getId()).orElseThrow(() -> new CustomException("Cannot get card!"));
        card.setRequestStatus(requestDTO.getRequestStatus());
        repo.save(card);
        return mapper.toDto(card);
    }

    public CardResponseDTO getById(long id) {
        Card card = repo.findById(id)
                .filter(Card::getStatus)
                .orElseThrow(() -> new CustomException("Cannot get card!"));
        return mapper.toDto(card);
    }

    public List<CardResponseDTO> getAll() {
        return repo.findAll()
                .stream()
                .filter(Card::getStatus)
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public CardResponseDTO delete(long id) {
        Card card = repo.findById(id).orElseThrow(() -> new CustomException("Cannot get card!"));
        card.setStatus(false);
        repo.save(card);
        return mapper.toDto(card);
    }

    @Transactional(rollbackFor = CustomException.class)
    public CardResponseDTO deposit(CardBalanceRequestDTO requestDTO) {
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        Card card = repo.findById(requestDTO.getDestination_id())
                .filter(c -> c.getRequestStatus() == RequestStatus.ACCEPTED)
                .orElseThrow(() -> new CustomException("Cannot get card!"));
        double cardBalance = card.getBalance();
        card.setBalance(cardBalance + requestDTO.getBalance());
        repo.save(card);
        Transaction balanceAdded = new Transaction(
                card.getAccount().getUser(),
                nameofCurrMethod,
                "Balance added");
        transactionRepo.save(balanceAdded);
        return mapper.toDto(card);
    }

    @Transactional(rollbackFor = CustomException.class)
    public CardResponseDTO withdrawalBetweenCards(CardBalanceRequestDTO requestDTO) {
        String nameofCurrMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        Card cardFrom = repo.findById(requestDTO.getSource_id())
                .filter(c -> c.getRequestStatus() == RequestStatus.ACCEPTED)
                .orElseThrow(() -> new CustomException("Cannot get card!"));
        double fromBalance = cardFrom.getBalance() - requestDTO.getBalance();
        Transaction balanceWithdrawal = new Transaction(cardFrom.getAccount().getUser(), nameofCurrMethod,
                "Balance withdrawal");
        if (fromBalance >= 0) {
            cardFrom.setBalance(fromBalance);
            deposit(requestDTO);
        } else {
            logger.error("Cannot withdraw from card {}", cardFrom);
            balanceWithdrawal.setStatus(false);
            throw new CustomException("Cannot withdraw from card");
        }
        transactionRepo.save(balanceWithdrawal);
        return mapper.toDto(cardFrom);
    }

    @Transactional(rollbackFor = CustomException.class)
    public CardResponseDTO changeBalance(CardBalanceChangeRequestDTO requestDTO) {
        Card card = repo.findById(requestDTO.getId()).orElseThrow(() -> new CustomException("Cannot get card!"));
        card.setBalance(requestDTO.getBalance());
        repo.save(card);
        return mapper.toDto(card);
    }
}
