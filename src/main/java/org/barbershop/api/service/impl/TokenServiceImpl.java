package org.barbershop.api.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.barbershop.api.core.entity.Usuario;
import org.barbershop.api.service.AutenticacaoService;
import org.barbershop.api.service.TokenService;
import org.barbershop.api.utils.ObterPrimeirasPalavras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
public class TokenServiceImpl implements TokenService {

    private static ObterPrimeirasPalavras obter = new ObterPrimeirasPalavras();

    @Value("${ohana.security.token.secret}")
    private String secretKey;

    @Autowired
    private AutenticacaoService autenticacaoService;

    @Override
    public String gerarToken(Usuario usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            String usuarioNome = obter.primeiroNome(usuario.getNomeCompleto());

            boolean emailVerificado = autenticacaoService.verificarEmail(usuario);

            String token = JWT.create()
                    .withIssuer("API Barbershop")
                    .withSubject(usuario.getEmail())
                    .withClaim("id", usuario.getId())
                    .withClaim("nome", usuarioNome)
                    .withClaim("role", usuario.getRole().getNome())
                    .withClaim("primeiroLogin", usuario.getPrimeiroLogin())
                    .withClaim("emailVerificado", emailVerificado)
                    .withExpiresAt(dataExpiracao())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token", exception);
        }
    }

    public String validarToken(String tokenJWT) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("API Barbershop")
                    .build();
            String decodedJWT = verifier.verify(tokenJWT).getSubject();
            return decodedJWT;
        } catch (JWTVerificationException exception){
            throw new RuntimeException("Erro ao validar token");
        }
    }

    @Override
    public Long obterIdUsuario(String tokenJWT) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            JWTVerifier verifier = JWT.require(algorithm)
                    .build();
            DecodedJWT decodedJWT = verifier.verify(tokenJWT);
            Claim idClaim = decodedJWT.getClaim("id");
            if (idClaim.isNull()) {
                throw new RuntimeException("ID da empresa não encontrado no token");
            }
            return idClaim.asLong();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Erro ao validar token", exception);
        }
    }


    @Override
    public Long obterIdUsuarioDoHeader(String authorizationHeader) {
        String tokenJWT = authorizationHeader.replace("Bearer ", "");
        return obterIdUsuario(tokenJWT);
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
