package org.barbershop.api.service;

import org.barbershop.api.core.DTO.CadastroEspecialidadeDTO;
import org.barbershop.api.core.DTO.EspecialidadeDTO;
import org.barbershop.api.core.DTO.VincularEspecialidadeDTO;
import org.barbershop.api.core.entity.Especialidade;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

public interface EspecialidadeService {
    Especialidade save(Especialidade especialidade);
    URI criarUriEspecialidade(Long id, UriComponentsBuilder uriBuilder);
    CadastroEspecialidadeDTO cadastrarEspecialidade(CadastroEspecialidadeDTO dados, UriComponentsBuilder uriBuilder);
    Optional<Especialidade> findByNome(String nome);
    Optional<Especialidade> findById(Long id);
    List<EspecialidadeDTO> buscarEspecialidades();
    List<Especialidade> findByNomeIn(List<String> nomes);
}
