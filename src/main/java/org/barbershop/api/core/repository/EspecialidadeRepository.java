package org.barbershop.api.core.repository;

import org.barbershop.api.core.DTO.EspecialidadeDTO;
import org.barbershop.api.core.entity.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long> {
    Optional<Especialidade> findByNome(String nome);
    Optional<Especialidade> findById(Long id);
    List<Especialidade> findAll();
    List<Especialidade> findByNomeIn(List<String> nomes);
}
