package kg.alatoo.hr.auth;
import kg.alatoo.hr.auth.tokens.RefreshToken;
import kg.alatoo.hr.service.RefreshTokenService;
import kg.alatoo.hr.service.impl.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final RefreshTokenService refreshTokenService;
    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
        @RequestBody RegisterRequest request
    ) {
        System.out.println("Request is coming!");
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
        @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @PostMapping("/refreshToken")
    public ResponseEntity<AuthenticationResponse> refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){

        return ResponseEntity.ok(refreshTokenService.findByToken(refreshTokenRequest.getToken())
            .map(refreshTokenService::verifyExpiration)
            .map(RefreshToken::getUser)
            .map(userInfo -> {
                String accessToken = jwtService.generateToken(userInfo, new Date(System.currentTimeMillis() + 1000 * 5));
                return AuthenticationResponse.builder()
                    .accessToken(accessToken)
                    .token(refreshTokenRequest.getToken()).build();
            }).orElseThrow(() ->new RuntimeException("Refresh Token is not in DB..!!")));
    }
}
