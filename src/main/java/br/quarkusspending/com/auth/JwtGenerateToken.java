package br.quarkusspending.com.auth;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;

import javax.enterprise.context.ApplicationScoped;

import br.quarkusspending.com.model.Users;
import io.smallrye.jwt.build.Jwt;

@ApplicationScoped
public class JwtGenerateToken {
    public String generateToken(Users users, int expires) {
        String token = Jwt.issuer("quarkusspending.com.br")
                .upn(String.valueOf(users.getId()))
                .groups(new HashSet<>(Arrays.asList(users.getProfile().toString())))
                .expiresIn(Duration.ofDays(expires))
                .sign();

        return token;
    }
}
