package org.barbershop.api.controller;


import jakarta.validation.Valid;
import org.barbershop.api.core.DTO.*;
import org.barbershop.api.service.FuncionarioService;
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
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private static final String AUTHORIZATION = "Authorization";

    @Autowired
    private FuncionarioService service;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastrar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CadastroFuncionarioDTO> cadastrarFuncionario(@RequestBody @Valid CadastroFuncionarioDTO dados, UriComponentsBuilder uriBuilder) {
        var dadosCadastrados = service.cadastrarFuncionario(dados, uriBuilder);
        var uri = usuarioService.criarUriUsuario(dadosCadastrados.getId(), uriBuilder);

        return ResponseEntity.created(uri).body(dadosCadastrados);
    }

    @GetMapping("/{id}")
    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ListagemFuncionarioDTO> detalhar(@PathVariable Long id) {
        var funcionario = service.detalhar(id);

        return ResponseEntity.ok(funcionario);
    }

    @PutMapping("/especialidade")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<FuncionarioDTO> adicionarEspecialidade(@RequestBody @Valid VincularEspecialidadeDTO dados) {
        var especialidadeAtualizada = service.vincularEspecialidade(dados);

        return ResponseEntity.ok(especialidadeAtualizada);
    }

    @GetMapping("/listar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Page<ListagemFuncionarioDTO>> listarTodosFuncionarios(
            @PageableDefault(size = 8, sort = {"id"}, direction = Sort.Direction.DESC) Pageable page) {
        Page<ListagemFuncionarioDTO> pageList = service.listarTodosFuncionarios(page);

        return ResponseEntity.ok(pageList);
    }
}
