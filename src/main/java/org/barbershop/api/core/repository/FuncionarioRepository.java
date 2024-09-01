package org.barbershop.api.core.repository;

import org.barbershop.api.core.entity.Cliente;
import org.barbershop.api.core.entity.Funcionario;
import org.barbershop.api.core.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Optional<Funcionario> findByRgcpf(String rgcpf);
    Optional<Funcionario> findById(Long id);
    @Query("SELECT f FROM Funcionario f WHERE f.usuario.ativo = true")
    Page<Funcionario> findAllByUsuarioAtivoTrue(Pageable page);
    @Query("SELECT f FROM Funcionario f WHERE f.id = :id AND f.usuario.ativo = true")
    Funcionario findFuncionarioAtivoById(Long id);
}
