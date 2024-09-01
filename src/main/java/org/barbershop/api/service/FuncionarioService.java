package org.barbershop.api.service;

import org.barbershop.api.core.DTO.*;
import org.barbershop.api.core.entity.Funcionario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

public interface FuncionarioService {
    Funcionario save (Funcionario funcionario);
    boolean existsByRgCpf(String rgcpf);
    Optional<Funcionario> findById(Long id);
    Funcionario obterFuncionario(Long id);
    ListagemFuncionarioDTO detalhar(Long id);
    Page<ListagemFuncionarioDTO> listarTodosFuncionarios(Pageable page);
    CadastroFuncionarioDTO cadastrarFuncionario(CadastroFuncionarioDTO dados, UriComponentsBuilder uriBuilder);
    FuncionarioDTO vincularEspecialidade(VincularEspecialidadeDTO dados);

}
