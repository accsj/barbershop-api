package org.barbershop.api.service.impl;

import org.barbershop.api.core.DTO.*;
import org.barbershop.api.core.DTO.converter.FuncionarioConverter;
import org.barbershop.api.core.entity.*;
import org.barbershop.api.core.repository.FuncionarioRepository;
import org.barbershop.api.service.*;
import org.barbershop.api.service.validator.FuncionarioValidatorService;
import org.barbershop.api.service.validator.UsuarioValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@Component
public class FuncionarioServiceImpl implements FuncionarioService {

    private static FuncionarioConverter funcionarioConverter = new FuncionarioConverter();

    @Autowired
    private FuncionarioRepository repository;

    @Autowired
    @Lazy
    private FuncionarioValidatorService funcionarioValidatorService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    @Lazy
    private UsuarioValidatorService usuarioValidatorService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private EspecialidadeService especialidadeService;

    @Autowired
    private TokenService tokenService;

    @Override
    public Funcionario save(Funcionario funcionario) {
        return repository.save(funcionario);
    }

    @Override
    public boolean existsByRgCpf(String rgcpf) {
        return repository.findByRgcpf(rgcpf).isPresent();
    }

    @Override
    public Optional<Funcionario> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Funcionario obterFuncionario(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public ListagemFuncionarioDTO detalhar(Long id) {

        Funcionario funcionario = repository.findFuncionarioAtivoById(id);
        return funcionarioConverter.toListagemFuncionarioDTO(funcionario);
    }

    @Override
    public Page<ListagemFuncionarioDTO> listarTodosFuncionarios(Pageable page) {
        Page<Funcionario> funcionarios = repository.findAllByUsuarioAtivoTrue(page);
        return funcionarios.map(funcionario -> funcionarioConverter.toListagemFuncionarioDTO(funcionario));
    }

    @Override
    @Transactional
    public CadastroFuncionarioDTO cadastrarFuncionario(CadastroFuncionarioDTO dados,
                                                       UriComponentsBuilder uriBuilder) {
        usuarioValidatorService.validarEmail(dados.getEmail());

        funcionarioValidatorService.validarRgCpf(dados.getRgcpf());

        Usuario usuario = new Usuario(dados, null, null, null);
        Role roleFuncionario = roleService.findByNome("FUNCIONARIO");
        usuario.setRole(roleFuncionario);
        Usuario usuarioSalvo = usuarioService.save(usuario);
        dados.setId(usuarioSalvo.getId());

        usuarioValidatorService.validarQuantidadeEnderecos(usuario);

        if (dados.getEndereco() != null) {
            Endereco endereco = new Endereco(dados.getEndereco(), usuarioSalvo);
            enderecoService.save(endereco);
            dados.getEndereco().setId(endereco.getId());
        }

        Funcionario funcionario = new Funcionario(dados, usuarioSalvo);

        if (dados.getEspecialidade() != null && !dados.getEspecialidade().isEmpty()) {
            List<Especialidade> especialidades = especialidadeService.findByNomeIn(dados.getEspecialidade());
            funcionario.setEspecialidades(especialidades);
        }

        Funcionario funcionarioSalvo =  save(funcionario);
        dados.setIdFuncionario(funcionarioSalvo.getId());

        return dados;
    }

    @Override
    public FuncionarioDTO vincularEspecialidade(VincularEspecialidadeDTO dados) {

        Funcionario funcionario = findById(dados.getIdFuncionario())
                .orElseThrow(() -> new RuntimeException("Funcionario não encontrado"));

        Especialidade especialidade = especialidadeService.findById(dados.getIdEspecialidade())
                .orElseThrow(() -> new RuntimeException("Especialidade não encontrado"));


        funcionario.getEspecialidades().add(especialidade);

        Funcionario funcionarioAtualizado = save(funcionario);

        return funcionarioConverter.toFuncionarioDTO(funcionarioAtualizado);
    }

}
