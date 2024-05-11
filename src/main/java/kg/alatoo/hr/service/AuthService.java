package kg.alatoo.hr.service;

import kg.alatoo.hr.dto.JwtRequest;
import kg.alatoo.hr.dto.JwtResponse;

public interface AuthService {
    JwtResponse login(JwtRequest loginRequest);
    JwtResponse refresh(String refreshToken);
}
