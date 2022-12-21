package com.herb.bankapp.service;

import com.herb.bankapp.config.ResourceBundleConfiguration;
import com.herb.bankapp.dto.response.UserAuthResponseDTO;
import com.herb.bankapp.entity.User;
import com.herb.bankapp.error.CustomException;
import com.herb.bankapp.mapper.UserMapper;
import com.herb.bankapp.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AuthService implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private UserRepo repo;
    @Autowired
    private UserMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findUserByUsername(username)
                .orElseThrow(() -> new CustomException(ResourceBundleConfiguration.getMessage("error.user")));
        return new User(user.getUsername(), user.getPassword(), user.getRole());
    }

    public List<UserAuthResponseDTO> getAll() {
        return repo.findAll()
                .stream()
                .filter(User::getStatus)
                .map(mapper::toAuthDto)
                .collect(Collectors.toList());
    }

    public Authentication authenticate(String username, String password) {
        Authentication authenticate = null;
        try {
            authenticate = manager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            logger.error("User Disabled: {}", e.getMessage());
        } catch (BadCredentialsException e) {
            logger.error("Invalid Credentials: {}", e.getMessage());
        }
        return authenticate;
    }
}
