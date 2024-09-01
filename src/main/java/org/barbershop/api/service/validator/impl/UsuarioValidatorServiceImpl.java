package org.barbershop.api.service.validator.impl;

import org.barbershop.api.core.entity.Usuario;
import org.barbershop.api.infra.exception.EmailJaExistenteException;
import org.barbershop.api.service.UsuarioService;
import org.barbershop.api.service.validator.UsuarioValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioValidatorServiceImpl implements UsuarioValidatorService {

    @Autowired
    private UsuarioService service;

    @Override
    public void validarUsuarioCliente(Usuario usuario) {
        if (usuario.getCliente() == null) {
            throw new RuntimeException("O usuário não é um cliente.");
        }
    }

    @Override
    public void validarUsuarioFuncionario(Usuario usuario) {
        if (usuario.getFuncionario() == null) {
            throw new RuntimeException("O usuário não é um funcionário.");
        }
    }

    @Override
    public void validarQuantidadeEnderecos(Usuario usuario) {
        if (usuario.getEnderecos() != null && usuario.getEnderecos().size() >= 2) {
            throw new RuntimeException("O usuário já possui o número máximo de endereços permitido.");
        }
    }

    @Override
    public void validarEmail(String email) {
        if (service.findByEmail(email) != null) {
            throw new EmailJaExistenteException("Já existe um usuário com o email cadastrado.");
        }
    }
}
