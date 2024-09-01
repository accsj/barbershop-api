package org.barbershop.api.core.repository;

import org.barbershop.api.core.DTO.ListagemUsuarioDTO;
import org.barbershop.api.core.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByEmail (String email);
    Optional<Usuario> findById(Long id);
}
