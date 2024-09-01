package org.barbershop.api.service;

import org.barbershop.api.core.entity.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AutenticacaoService extends UserDetailsService {
    UserDetails loadUserByUsername(String email);
    boolean primeiroLogin(Long id);
    boolean verificarEmail(Usuario usuario);
}