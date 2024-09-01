package org.barbershop.api.service.impl;

import org.barbershop.api.core.entity.Usuario;
import org.barbershop.api.service.AutenticacaoService;
import org.barbershop.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class AutenticacaoServiceImpl implements AutenticacaoService {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String email) {
        var empresa = usuarioService.findByEmail(email);

        if (empresa == null) {
            throw new UsernameNotFoundException("Empresa não encontrada com email: " + email);
        }

        return empresa;
    }

    @Override
    public boolean primeiroLogin(Long id) {
        Usuario usuario = usuarioService.obterUsuario(id);
        boolean primeiroLogin = usuario.getPrimeiroLogin();

        if (primeiroLogin) {
            usuario.setPrimeiroLogin(false);
            usuarioService.save(usuario);
        }
        return primeiroLogin;
    }

    @Override
    public boolean verificarEmail(Usuario usuario) {
        return usuario.getEmailVerificado();
    }
}
