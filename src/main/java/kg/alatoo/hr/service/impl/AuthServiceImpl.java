package kg.alatoo.hr.service.impl;

import kg.alatoo.hr.dto.JwtRequest;
import kg.alatoo.hr.dto.JwtResponse;
import kg.alatoo.hr.service.AuthService;

public class AuthServiceImpl implements AuthService {
    @Override
    public JwtResponse login(JwtRequest loginRequest) {
        return null;
    }

    @Override
    public JwtResponse refresh(String refreshToken) {
        return null;
    }
}
