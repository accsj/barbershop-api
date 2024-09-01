package org.barbershop.api.service;

import org.barbershop.api.core.DTO.CadastroClienteDTO;
import org.barbershop.api.core.DTO.CadastroEnderecoDTO;
import org.barbershop.api.core.entity.Endereco;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public interface EnderecoService {
    Endereco save (Endereco endereco);
    URI criarUriEndereco(Long id, UriComponentsBuilder uriBuilder);
    CadastroEnderecoDTO cadastrarEndereco(CadastroEnderecoDTO dados, UriComponentsBuilder uriBuilder, String authorizationHeader);
}
