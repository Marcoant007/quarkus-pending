package br.quarkusspending.com.auth;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;

import javax.enterprise.context.ApplicationScoped;

import io.smallrye.jwt.build.Jwt;

@ApplicationScoped
public class JwtGenerateToken {
    public String generateToken(int id, int expires) {
        String token = Jwt.issuer("quarkusspending.com.br")
                .upn(String.valueOf(id))
                .groups(new HashSet<>(Arrays.asList("User", "Admin")))
                .expiresIn(Duration.ofDays(expires))
                .sign();

        return token;
    }
}
