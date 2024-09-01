package org.barbershop.api.service;

import org.barbershop.api.core.DTO.CadastroClienteDTO;
import org.barbershop.api.core.DTO.CadastroUsuarioDTO;
import org.barbershop.api.core.DTO.ListagemClienteDTO;
import org.barbershop.api.core.DTO.ListagemFuncionarioDTO;
import org.barbershop.api.core.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

public interface ClienteService {
    Cliente save(Cliente cliente);
    Optional<Cliente> findById(Long id);
    Cliente obterCliente(Long id);
    ListagemClienteDTO detalhar(Long id);
    Page<ListagemClienteDTO> listarTodosClientes(Pageable page);
    CadastroClienteDTO cadastrarCliente(CadastroClienteDTO dados, UriComponentsBuilder uriBuilder);
}
