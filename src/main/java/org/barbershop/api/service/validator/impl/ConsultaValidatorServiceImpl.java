package org.barbershop.api.service.validator.impl;

import org.barbershop.api.core.entity.Cliente;
import org.barbershop.api.core.entity.Consulta;
import org.barbershop.api.service.validator.ConsultaValidatorService;
import org.springframework.stereotype.Component;

@Component
public class ConsultaValidatorServiceImpl implements ConsultaValidatorService {


    @Override
    public void validarConsultaRemarcada(Consulta consulta) {
        if (consulta.getRemarcada()) {
            throw new RuntimeException("Esta consulta já foi remarcada e não pode ser remarcada novamente.");
        }
    }

    @Override
    public void validarConsultaDoCliente(Consulta consulta, Cliente cliente) {
        if (!consulta.getCliente().getId().equals(cliente.getId())) {
            throw new RuntimeException("Esta consulta não pertence ao cliente associado ao usuário.");
        }
    }

    @Override
    public void validarIdConsultaDTO(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID da consulta não pode ser nulo.");
        }
    }
}
