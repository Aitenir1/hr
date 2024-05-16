package kg.alatoo.hr.service.impl;

import kg.alatoo.hr.auth.tokens.RefreshToken;
import kg.alatoo.hr.entity.User;
import kg.alatoo.hr.repository.RefreshTokenRepository;
import kg.alatoo.hr.repository.UserRepository;
import kg.alatoo.hr.service.RefreshTokenService;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class RefreshTokenServiceImpl implements RefreshTokenService {

    RefreshTokenRepository refreshTokenRepository;

    UserRepository userRepository;

    public RefreshToken createRefreshToken(String username) {
        RefreshToken refreshToken = RefreshToken.builder()
            .user(userRepository.findByEmail(username).orElseThrow(() ->  new UsernameNotFoundException("User not found!")))
            .token(UUID.randomUUID().toString())
            .expiryDate(Instant.now().plusMillis(600000)) // set expiry of refresh token to 10 minutes - you can configure it application.properties file
            .build();
        return refreshTokenRepository.save(refreshToken);
    }

    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

    public RefreshToken verifyExpiration(RefreshToken token) {
        if(token.getExpiryDate().compareTo(Instant.now())<0){
            refreshTokenRepository.delete(token);
            throw new RuntimeException(token.getToken() + " Refresh token is expired. Please make a new login..!");
        }
        return token;
    }

}
