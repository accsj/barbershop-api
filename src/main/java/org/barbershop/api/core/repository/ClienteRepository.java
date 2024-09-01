package org.barbershop.api.core.repository;

import org.barbershop.api.core.entity.Cliente;
import org.barbershop.api.core.entity.Funcionario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findById(Long id);
    @Query("SELECT c FROM Cliente c WHERE c.usuario.ativo = true")
    Page<Cliente> findAllByUsuarioAtivoTrue(Pageable page);
    @Query("SELECT c FROM Cliente c WHERE c.id = :id AND c.usuario.ativo = true")
    Cliente findClienteAtivoById(Long id);
}
