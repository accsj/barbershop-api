package org.barbershop.api.service;

import org.barbershop.api.core.entity.Usuario;

public interface TokenService {

    String gerarToken(Usuario usuario);

    String validarToken(String tokenJWT);

    Long obterIdUsuario(String tokenJWT);

    Long obterIdUsuarioDoHeader(String authorizationHeader);

}

