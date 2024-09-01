package org.barbershop.api.controller;


import jakarta.validation.Valid;
import org.barbershop.api.core.DTO.AutenticacaoDTO;
import org.barbershop.api.core.DTO.TokenDTO;
import org.barbershop.api.core.entity.Usuario;
import org.barbershop.api.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    @PreAuthorize("permitAll()")
    public ResponseEntity efetuarLogin(@RequestBody @Valid AutenticacaoDTO dados) {

        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.getEmail(), dados.getSenha());
        var auth = manager.authenticate(authenticationToken);
        var tokenJWT = tokenService.gerarToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new TokenDTO(tokenJWT));
    }
}
