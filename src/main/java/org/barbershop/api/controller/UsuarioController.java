package org.barbershop.api.controller;


import org.barbershop.api.core.DTO.ListagemUsuarioDTO;
import org.barbershop.api.service.UsuarioService;
import org.barbershop.api.utils.HasRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private static final HasRole hasRole = new HasRole();

    @Autowired
    private UsuarioService service;

    @GetMapping("/{id}")
    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ListagemUsuarioDTO> detalhar(@PathVariable Long id) {
        var usuario= service.detalhar(id);

        return ResponseEntity.ok(usuario);
    }

}
