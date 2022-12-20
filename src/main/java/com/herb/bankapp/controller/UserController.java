package com.herb.bankapp.controller;

import com.herb.bankapp.dto.request.UserRoleChangeRequestDTO;
import com.herb.bankapp.dto.response.TransactionResponseDTO;
import com.herb.bankapp.dto.response.UserResponseDTO;
import com.herb.bankapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService service;

    @GetMapping("/{id}")
    public UserResponseDTO getUserById(@PathVariable long id) {
        return service.getById(id);
    }

    @GetMapping("/all")
    public List<UserResponseDTO> getAllUsers() {
        return service.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public UserResponseDTO deleteUser(@PathVariable long id) {
        return service.delete(id);
    }

    @GetMapping("/history")
    public List<TransactionResponseDTO> getUserHistory() {
        return service.history();
    }

    @PatchMapping("/role")
    public UserResponseDTO changeUserRole(@RequestBody UserRoleChangeRequestDTO requestDTO) {
        return service.changeRole(requestDTO);
    }
}
