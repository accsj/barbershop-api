package org.barbershop.api.service.validator;

import org.barbershop.api.core.entity.Cliente;
import org.barbershop.api.core.entity.Consulta;

public interface ConsultaValidatorService {

    void validarConsultaRemarcada(Consulta consulta);

    void validarConsultaDoCliente(Consulta consulta, Cliente cliente);

    void validarIdConsultaDTO(Long id);
}
