package org.barbershop.api.service;

import org.barbershop.api.core.DTO.ListagemUsuarioDTO;
import org.barbershop.api.core.DTO.UsuarioDTO;
import org.barbershop.api.core.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

public interface UsuarioService {
    UserDetails findByEmail (String email);
    Usuario obterUsuario(Long id);
    Usuario save(Usuario usuario);
    Optional<Usuario> findById(Long id);
    URI criarUriUsuario(Long id, UriComponentsBuilder uriBuilder);
    ListagemUsuarioDTO detalhar(Long id);
}
