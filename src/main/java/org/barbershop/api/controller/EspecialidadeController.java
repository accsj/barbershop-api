package org.barbershop.api.controller;

import jakarta.validation.Valid;
import org.barbershop.api.core.DTO.CadastroEspecialidadeDTO;
import org.barbershop.api.core.DTO.EspecialidadeDTO;
import org.barbershop.api.service.EspecialidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadeController {

    @Autowired
    private EspecialidadeService service;

    @PostMapping("/cadastrar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CadastroEspecialidadeDTO> cadastrarEspecialidade(@RequestBody @Valid CadastroEspecialidadeDTO dados, UriComponentsBuilder uriBuilder) {
        var dadosCadastrados = service.cadastrarEspecialidade(dados, uriBuilder);
        var uri = service.criarUriEspecialidade(dadosCadastrados.getId(), uriBuilder);

        return ResponseEntity.created(uri).body(dadosCadastrados);
    }

    @GetMapping("/listar")
    @PreAuthorize("hasRole('ADMIN')")
    public List<EspecialidadeDTO> listarEspecialidades() {
        return service.buscarEspecialidades();
    }

}
