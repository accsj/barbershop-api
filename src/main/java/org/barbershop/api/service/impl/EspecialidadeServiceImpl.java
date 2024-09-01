package org.barbershop.api.service.impl;

import org.barbershop.api.core.DTO.CadastroEspecialidadeDTO;
import org.barbershop.api.core.DTO.EspecialidadeDTO;
import org.barbershop.api.core.entity.Especialidade;
import org.barbershop.api.core.repository.EspecialidadeRepository;
import org.barbershop.api.service.EspecialidadeService;
import org.barbershop.api.service.TokenService;
import org.barbershop.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EspecialidadeServiceImpl implements EspecialidadeService {

    @Autowired
    private EspecialidadeRepository repository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public Especialidade save(Especialidade especialidade) {
        return repository.save(especialidade);
    }

    @Override
    public URI criarUriEspecialidade(Long id, UriComponentsBuilder uriBuilder) {
        return uriBuilder.path("/especialidade/{id}").buildAndExpand(id).toUri();
    }

    @Override
    public CadastroEspecialidadeDTO cadastrarEspecialidade(CadastroEspecialidadeDTO dados, UriComponentsBuilder uriBuilder) {

        if (findByNome(dados.getNome()).isPresent()) {
            throw new RuntimeException("Especialidade já cadastrada.");
        }

        Especialidade especialidade = new Especialidade(dados);
        Especialidade especialidadeSalva =  save(especialidade);
        dados.setId(especialidadeSalva.getId());

        return dados;
    }

    @Override
    public Optional<Especialidade> findByNome(String nome) {
        return repository.findByNome(nome);
    }

    @Override
    public Optional<Especialidade> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<EspecialidadeDTO> buscarEspecialidades() {
        List<Especialidade> especialidades = repository.findAll();
        return especialidades.stream()
                .map(tipo -> new EspecialidadeDTO(tipo.getId(), tipo.getNome()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Especialidade> findByNomeIn(List<String> nomes) {
        return repository.findByNomeIn(nomes);
    }

}
