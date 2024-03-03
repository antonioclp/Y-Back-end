package com.y.back.services;

import com.y.back.models.entity.Person;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/*
 * Token service.
 */
@Service
public class TokenService {
  @Value("${api.security.token.secret}")
  private String secret;

  public String generateToken(Person person) {
    Algorithm algorithm = Algorithm.HMAC256(secret);
    return JWT.create()
        .withIssuer("pass")
        .withSubject(person.getUsername())
        .withExpiresAt(generateExpirationDate())
        .sign(algorithm);
  }

  private Instant generateExpirationDate() {
    return LocalDateTime.now()
        .plusDays(1)
        .toInstant(ZoneOffset.of("-03:00"));
  }

  public String validateToken(String token) {
    Algorithm algorithm = Algorithm.HMAC256(secret);
    return JWT.require(algorithm)
        .withIssuer("pass")
        .build()
        .verify(token)
        .getSubject();
  }
}
