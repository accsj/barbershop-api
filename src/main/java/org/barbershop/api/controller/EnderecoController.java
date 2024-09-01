package org.barbershop.api.controller;


import jakarta.validation.Valid;
import org.barbershop.api.core.DTO.CadastroEnderecoDTO;
import org.barbershop.api.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    private static final String AUTHORIZATION = "Authorization";

    @Autowired
    private EnderecoService service;

    @PostMapping("/cadastrar")
    @PreAuthorize("hasAnyRole('CLIENTE', 'FUNCIONARIO', 'ADMIN')")
    public ResponseEntity<CadastroEnderecoDTO> cadastrar(@RequestBody @Valid CadastroEnderecoDTO dados,
                                                         UriComponentsBuilder uriBuilder,
                                                         @RequestHeader(AUTHORIZATION) String authorizationHeader) {
        var dadosCadastrados = service.cadastrarEndereco(dados, uriBuilder, authorizationHeader);
        var uri = service.criarUriEndereco(dadosCadastrados.getId(), uriBuilder);

        return ResponseEntity.created(uri).body(dadosCadastrados);
    }
}
