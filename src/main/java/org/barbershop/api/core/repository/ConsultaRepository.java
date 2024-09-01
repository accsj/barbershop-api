package org.barbershop.api.core.repository;

import org.barbershop.api.core.entity.Consulta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    Optional<Consulta> findByIdAndAtivoTrue(Long id);
    @Query("SELECT c FROM Consulta c WHERE c.ativo = true")
    Page<Consulta> findAllByAtivoTrue(Pageable page);
    @Query("SELECT c FROM Consulta c WHERE c.id = :id AND c.ativo = true")
    Consulta findConsultaByIdAndAtivoTrue(Long id);
}
