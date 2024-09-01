package org.barbershop.api.service.impl;

import org.barbershop.api.core.DTO.CadastroEnderecoDTO;
import org.barbershop.api.core.entity.Endereco;
import org.barbershop.api.core.entity.Usuario;
import org.barbershop.api.core.repository.EnderecoRepository;
import org.barbershop.api.service.EnderecoService;
import org.barbershop.api.service.TokenService;
import org.barbershop.api.service.UsuarioService;
import org.barbershop.api.service.validator.UsuarioValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;

@Component
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    @Autowired
    @Lazy
    private TokenService tokenService;

    @Autowired
    @Lazy
    private UsuarioService usuarioService;

    @Autowired
    @Lazy
    private UsuarioValidatorService usuarioValidatorService;

    @Override
    public Endereco save(Endereco endereco) {
        return repository.save(endereco);
    }

    @Override
    public URI criarUriEndereco(Long id, UriComponentsBuilder uriBuilder) {
        return uriBuilder.path("/enderecos/{id}").buildAndExpand(id).toUri();
    }

    @Override
    public CadastroEnderecoDTO cadastrarEndereco(CadastroEnderecoDTO dados, UriComponentsBuilder uriBuilder, String authorizationHeader) {
        Long idUsuario = tokenService.obterIdUsuarioDoHeader(authorizationHeader);

        Usuario usuario = usuarioService.findById(idUsuario)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado para o ID: " + idUsuario));

        usuarioValidatorService.validarQuantidadeEnderecos(usuario);

        Endereco endereco = new Endereco(dados, usuario);
        save(endereco);

        if (usuario.getEnderecos() == null) {
            usuario.setEnderecos(new ArrayList<>());
        }

        usuario.getEnderecos().add(endereco);
        usuarioService.save(usuario);

        dados.setId(endereco.getId());

        return dados;
    }
}
