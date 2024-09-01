package org.barbershop.api.service.impl;

import org.barbershop.api.core.DTO.*;
import org.barbershop.api.core.DTO.converter.ConsultaConverter;
import org.barbershop.api.core.entity.*;
import org.barbershop.api.core.repository.ConsultaRepository;
import org.barbershop.api.service.*;
import org.barbershop.api.service.validator.ConsultaValidatorService;
import org.barbershop.api.service.validator.UsuarioValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Optional;

@Component
public class ConsultaServiceImpl implements ConsultaService {

    private static final ConsultaConverter consultaConverter = new ConsultaConverter();

    @Autowired
    private ConsultaRepository repository;

    @Autowired
    @Lazy
    private ConsultaValidatorService consultaValidatorService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    @Lazy
    private UsuarioValidatorService usuarioValidatorService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private FuncionarioService funcionarioService;

    @Override
    public Consulta save(Consulta consulta) {
        return repository.save(consulta);
    }

    @Override
    public Optional<Consulta> findById(Long id) {
        return repository.findByIdAndAtivoTrue(id);
    }

    @Override
    public ConsultaDTO detalhar(Long id) {
        Consulta consulta = repository.findConsultaByIdAndAtivoTrue(id);
        return consultaConverter.toConsultaDTO(consulta);
    }

    @Override
    public URI criarUriConsulta(Long id, UriComponentsBuilder uriBuilder) {
        return uriBuilder.path("/consultas/{id}").buildAndExpand(id).toUri();
    }

    @Override
    @Transactional
    public CadastroConsultaDTO cadastrarConsulta(CadastroConsultaDTO dados, UriComponentsBuilder uriBuilder, String authorizationHeader) {
        Long idUsuario = tokenService.obterIdUsuarioDoHeader(authorizationHeader);

        Usuario usuario = usuarioService.findById(idUsuario)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado para o ID: " + idUsuario));

        usuarioValidatorService.validarUsuarioCliente(usuario);

        Cliente cliente = usuario.getCliente();

        Funcionario funcionario = funcionarioService.findById(dados.getIdFuncionario())
                .orElseThrow(() -> new IllegalArgumentException("Funcionario não encontrado para o ID: " + dados.getIdFuncionario()));

        Consulta consulta = new Consulta(dados);
        consulta.setCliente(cliente);
        consulta.setFuncionario(funcionario);
        save(consulta);

        if (cliente.getConsultas() == null) {
            cliente.setConsultas(new ArrayList<>());
        }

        cliente.getConsultas().add(consulta);
        usuarioService.save(usuario);
        dados.setIdCliente(cliente.getId());

        if (funcionario.getConsultas() == null) {
            funcionario.setConsultas(new ArrayList<>());
        }

        funcionario.getConsultas().add(consulta);
        funcionarioService.save(funcionario);

        dados.setId(consulta.getId());

        return dados;
    }

    @Override
    public Page<ConsultaDTO> listarTodasConsultas(Pageable page) {
        Page<Consulta> consultas = repository.findAllByAtivoTrue(page);
        return consultas.map(consultaConverter::toConsultaDTO);
    }

    @Override
    @Transactional
    public ConsultaDTO remarcarConsulta(RemarcarConsultaDTO dados, String authorizationHeader) {

        Long idUsuario = tokenService.obterIdUsuarioDoHeader(authorizationHeader);

        Usuario usuario = usuarioService.findById(idUsuario)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado para o ID: " + idUsuario));

        usuarioValidatorService.validarUsuarioCliente(usuario);

        consultaValidatorService.validarIdConsultaDTO(dados.getIdConsulta());

        Consulta consulta = findById(dados.getIdConsulta())
                .orElseThrow(() -> new IllegalArgumentException("Consulta não encontrada para o ID: " + dados.getIdConsulta()));

        Cliente cliente = usuario.getCliente();
        consultaValidatorService.validarConsultaDoCliente(consulta, cliente);

        consultaValidatorService.validarConsultaRemarcada(consulta);

        consulta.setDataConsulta(dados.getDataRemarcada());
        consulta.setRemarcada(true);

        save(consulta);

        return consultaConverter.toConsultaDTO(consulta);
    }

    @Override
    public ConsultaDTO cancelarConsulta(CancelarConsultaDTO dados, String authorizationHeader) {

        Long idUsuario = tokenService.obterIdUsuarioDoHeader(authorizationHeader);

        Usuario usuario = usuarioService.findById(idUsuario)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado para o ID: " + idUsuario));

        usuarioValidatorService.validarUsuarioCliente(usuario);

        if (dados.getIdConsulta() == null) {
            throw new IllegalArgumentException("ID da consulta não pode ser nulo.");
        }

        Consulta consulta = findById(dados.getIdConsulta())
                .orElseThrow(() -> new IllegalArgumentException("Consulta não encontrada para o ID: " + dados.getIdConsulta()));

        Cliente cliente = usuario.getCliente();
        consultaValidatorService.validarConsultaDoCliente(consulta, cliente);

        consulta.setAtivo(false);
        save(consulta);

        return null;
    }

}
