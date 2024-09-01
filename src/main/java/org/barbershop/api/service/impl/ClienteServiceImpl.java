package org.barbershop.api.service.impl;

import org.barbershop.api.core.DTO.*;
import org.barbershop.api.core.DTO.converter.ClienteConverter;
import org.barbershop.api.core.entity.*;
import org.barbershop.api.core.repository.ClienteRepository;
import org.barbershop.api.service.ClienteService;
import org.barbershop.api.service.EnderecoService;
import org.barbershop.api.service.RoleService;
import org.barbershop.api.service.UsuarioService;
import org.barbershop.api.service.validator.UsuarioValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Component
public class ClienteServiceImpl implements ClienteService {

    private static ClienteConverter clienteConverter = new ClienteConverter();

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    @Lazy
    private UsuarioValidatorService usuarioValidatorService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private EnderecoService enderecoService;

    @Override
    public Cliente save(Cliente cliente) {

        return repository.save(cliente);
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Cliente obterCliente(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public ListagemClienteDTO detalhar(Long id) {

        Cliente cliente = repository.findClienteAtivoById(id);
        return clienteConverter.toListagemClienteDTO(cliente);
    }

    @Override
    public Page<ListagemClienteDTO> listarTodosClientes(Pageable page) {
        Page<Cliente> clientes = repository.findAllByUsuarioAtivoTrue(page);
        return clientes.map(cliente -> clienteConverter.toListagemClienteDTO(cliente));
    }

    @Override
    @Transactional
    public CadastroClienteDTO cadastrarCliente(CadastroClienteDTO dados, UriComponentsBuilder uriBuilder) {

        usuarioValidatorService.validarEmail(dados.getEmail());

        Usuario usuario = new Usuario(dados, null, null, null);
        Role roleCliente = roleService.findByNome("CLIENTE");
        usuario.setRole(roleCliente);
        Usuario usuarioSalvo = usuarioService.save(usuario);
        dados.setId(usuarioSalvo.getId());

        usuarioValidatorService.validarQuantidadeEnderecos(usuario);

        if (dados.getEndereco() != null) {
            Endereco endereco = new Endereco(dados.getEndereco(), usuarioSalvo);
            enderecoService.save(endereco);
            dados.getEndereco().setId(endereco.getId());
        }

        Cliente cliente = new Cliente(dados, usuarioSalvo);
        Cliente clienteSalvo = save(cliente);
        dados.setIdCliente(clienteSalvo.getId());

        return dados;
    }
}
