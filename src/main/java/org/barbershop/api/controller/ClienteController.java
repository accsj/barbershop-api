package org.barbershop.api.controller;


import jakarta.validation.Valid;
import org.barbershop.api.core.DTO.*;
import org.barbershop.api.service.ClienteService;
import org.barbershop.api.service.UsuarioService;
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
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastrar")
    @PreAuthorize("permitAll()")
    public ResponseEntity<CadastroClienteDTO> cadastrarCliente(@RequestBody @Valid CadastroClienteDTO dados, UriComponentsBuilder uriBuilder) {
        var dadosCadastrados = service.cadastrarCliente(dados, uriBuilder);
        var uri = usuarioService.criarUriUsuario(dadosCadastrados.getId(), uriBuilder);

        return ResponseEntity.created(uri).body(dadosCadastrados);
    }

    @GetMapping("/{id}")
    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ListagemClienteDTO> detalhar(@PathVariable Long id) {
        var cliente = service.detalhar(id);

        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/listar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Page<ListagemClienteDTO>> listarTodoosClientes(
            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.DESC) Pageable page) {
        Page<ListagemClienteDTO> pageList = service.listarTodosClientes(page);

        return ResponseEntity.ok(pageList);
    }
}
