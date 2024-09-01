package org.barbershop.api.service.validator;

import org.barbershop.api.core.entity.Usuario;

public interface UsuarioValidatorService {
    void validarUsuarioCliente(Usuario usuario);
    void validarUsuarioFuncionario(Usuario usuario);
    void validarQuantidadeEnderecos(Usuario usuario);
    void validarEmail(String email);
}
