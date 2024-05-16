package kg.alatoo.hr.auth;

import kg.alatoo.hr.auth.tokens.RefreshToken;
import kg.alatoo.hr.entity.Role;
import kg.alatoo.hr.entity.User;
import kg.alatoo.hr.repository.UserRepository;
import kg.alatoo.hr.service.RefreshTokenService;
import kg.alatoo.hr.service.impl.JwtService;
import kg.alatoo.hr.service.impl.RefreshTokenServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final RefreshTokenService refreshTokenService;

    public AuthenticationResponse register(RegisterRequest request) {
        User user = User.builder()
            .username(request.getUsername())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .role(Role.USER)
            .build();

        repository.save(user);
        String jwtToken = jwtService.generateToken(user,  new Date(System.currentTimeMillis() + 1000 * 5));
        return AuthenticationResponse.builder()
            .token(jwtToken)
            .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
            )
        );

        User user = repository.findByEmail(request.getEmail()).
            orElseThrow();

        String jwtToken = jwtService.generateToken(user, new Date(System.currentTimeMillis() + 1000 * 5));
        RefreshToken refreshToken = refreshTokenService.createRefreshToken(user.getUsername());

        return AuthenticationResponse.builder()
            .accessToken(jwtToken)
            .token(refreshToken.getToken())
            .build();
    }
}
