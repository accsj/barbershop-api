package org.barbershop.api.controller;

import jakarta.validation.Valid;
import org.barbershop.api.core.DTO.*;
import org.barbershop.api.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    private static final String AUTHORIZATION = "Authorization";

    @Autowired
    private ConsultaService service;

    @PostMapping("/cadastrar")
    @Transactional
    @PreAuthorize("hasAnyRole('CLIENTE', 'FUNCIONARIO', 'ADMIN')")
    public ResponseEntity<CadastroConsultaDTO> cadastrar(@RequestBody @Valid CadastroConsultaDTO dados,
                                                         UriComponentsBuilder uriBuilder,
                                                         @RequestHeader(AUTHORIZATION) String authorizationHeader) {
        var dadosCadastrados = service.cadastrarConsulta(dados, uriBuilder, authorizationHeader);
        var uri = service.criarUriConsulta(dadosCadastrados.getId(), uriBuilder);

        return ResponseEntity.created(uri).body(dadosCadastrados);
    }

    @GetMapping("/{id}")
    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ConsultaDTO> detalhar(@PathVariable Long id) {
        var consulta = service.detalhar(id);

        return ResponseEntity.ok(consulta);
    }

    @GetMapping("/listar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Page<ConsultaDTO>> listarTodasConsultas(
            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.DESC) Pageable page) {
        Page<ConsultaDTO> pageList = service.listarTodasConsultas(page);

        return ResponseEntity.ok(pageList);
    }

    @PutMapping("/remarcar")
    @Transactional
    @PreAuthorize("hasAnyRole('CLIENTE', 'FUNCIONARIO', 'ADMIN')")
    public ResponseEntity<ConsultaDTO> remarcarConsulta(@RequestBody RemarcarConsultaDTO dados,
                                                        @RequestHeader(AUTHORIZATION) String authorizationHeader) {
        var consultaRemarcada = service.remarcarConsulta(dados, authorizationHeader);

        return ResponseEntity.ok(consultaRemarcada);
    }

    @PutMapping("/cancelar")
    @Transactional
    @PreAuthorize("hasAnyRole('CLIENTE', 'FUNCIONARIO', 'ADMIN')")
    public ResponseEntity<ConsultaDTO> cancelarConsulta(@RequestBody CancelarConsultaDTO dados,
                                                        @RequestHeader(AUTHORIZATION) String authorizationHeader) {
        var consultaCancelada = service.cancelarConsulta(dados, authorizationHeader);

        return ResponseEntity.ok(consultaCancelada);
    }
}
