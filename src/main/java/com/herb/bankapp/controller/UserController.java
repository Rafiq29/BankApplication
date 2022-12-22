package com.herb.bankapp.controller;

import com.herb.bankapp.dto.request.UserRoleChangeRequestDTO;
import com.herb.bankapp.dto.response.TransactionResponseDTO;
import com.herb.bankapp.dto.response.UserResponseDTO;
import com.herb.bankapp.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Api(value = "User Related APIs")
public class UserController {
    private final UserService service;

    @ApiOperation(value = "Get user by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Cannot get user"),
            @ApiResponse(code = 500, message = "Unknown error")
    })
    @GetMapping("/{id}")
    public UserResponseDTO getUserById(@PathVariable long id) {
        return service.getById(id);
    }

    @ApiOperation(value = "Get a list of all users by their names and roles")
    @ApiResponse(code = 500, message = "Unknown error")
    @GetMapping("/all")
    public List<UserResponseDTO> getAllUsers() {
        return service.getAll();
    }

    @ApiOperation(value = "Delete a user. User becomes inactive")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Cannot get user"),
            @ApiResponse(code = 500, message = "Unknown error")
    })
    @DeleteMapping("/delete/{id}")
    public UserResponseDTO deleteUser(@PathVariable long id) {
        return service.delete(id);
    }

    @ApiOperation(value = "Get all user specific transactions")
    @ApiResponse(code = 500, message = "Unknown error")
    @GetMapping("/history")
    public List<TransactionResponseDTO> getUserHistory() {
        return service.history();
    }

    @ApiOperation(value = "Change role of specified user. Can be changed by ADMIN")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Cannot get user"),
            @ApiResponse(code = 500, message = "Unknown error")
    })
    @PatchMapping("/role")
    public UserResponseDTO changeUserRole(@RequestBody UserRoleChangeRequestDTO requestDTO) {
        return service.changeRole(requestDTO);
    }
}
