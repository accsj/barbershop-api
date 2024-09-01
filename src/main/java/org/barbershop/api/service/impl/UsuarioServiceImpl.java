package org.barbershop.api.service.impl;

import org.barbershop.api.core.DTO.*;
import org.barbershop.api.core.DTO.converter.UsuarioConverter;
import org.barbershop.api.core.entity.*;
import org.barbershop.api.core.repository.UsuarioRepository;
import org.barbershop.api.service.EnderecoService;
import org.barbershop.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Component
public class UsuarioServiceImpl implements UsuarioService {

    private static final UsuarioConverter usuarioConverter = new UsuarioConverter();

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private EnderecoService enderecoService;

    @Override
    public UserDetails findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Usuario obterUsuario(Long id) {

        return repository.getReferenceById(id);
    }

    @Override
    public Usuario save(Usuario usuario) {

        return repository.save(usuario);
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public URI criarUriUsuario(Long id, UriComponentsBuilder uriBuilder) {
        return uriBuilder.path("/usuarios/{id}").buildAndExpand(id).toUri();
    }

    @Override
    public ListagemUsuarioDTO detalhar (Long id) {

        Usuario usuario = obterUsuario(id);

        return usuarioConverter.toListagemUsuarioDTO(usuario);
    }

}
