package org.barbershop.api.service.validator.impl;

import org.barbershop.api.infra.exception.RgCpfJaExistenteException;
import org.barbershop.api.service.FuncionarioService;
import org.barbershop.api.service.validator.FuncionarioValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioValidatorServiceImpl implements FuncionarioValidatorService {

    @Autowired
    private FuncionarioService service;

    public void validarRgCpf(String rgcpf) {
        if (service.existsByRgCpf(rgcpf)) {
            throw new RgCpfJaExistenteException("Já existe um funcionário com o RG ou CPF cadastrado.");
        }
    }
}
