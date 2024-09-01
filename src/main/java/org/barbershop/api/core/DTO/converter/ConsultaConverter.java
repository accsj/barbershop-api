package org.barbershop.api.core.DTO.converter;

import org.barbershop.api.core.DTO.*;
import org.barbershop.api.core.entity.Consulta;
import org.barbershop.api.utils.DateTimeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConsultaConverter {

    private static final ClienteConverter clienteConverter = new ClienteConverter();
    private static final FuncionarioConverter funcionarioConverter = new FuncionarioConverter();

    public List<ConsultaSimplesDTO> toListConsultaSimplesDTO(List<Consulta> consultas) {
        if (consultas == null) return new ArrayList<>();

        return consultas.stream()
                .map(consulta -> new ConsultaSimplesDTO(
                        consulta.getId(),
                        consulta.getDataConsulta(),
                        consulta.getRemarcada(),
                        consulta.getAtivo()
                ))
                .collect(Collectors.toList());
    }

    public List<ConsultaDTO> toListConsultaDTO(List<Consulta> consultas) {
        if (consultas == null) return new ArrayList<>();

        return consultas.stream()
                .map(consulta -> {
                    ClienteSimplesDTO clienteDTO = consulta.getCliente() != null
                            ? clienteConverter.toClienteSimplesDTO(consulta.getCliente())
                            : null;

                    FuncionarioSimplesDTO funcionarioDTO = consulta.getFuncionario() != null
                            ? funcionarioConverter.toFuncionarioSimplesDTO(consulta.getFuncionario())
                            : null;

                    return new ConsultaDTO(
                            consulta.getId(),
                            consulta.getDataConsulta(),
                            consulta.getRemarcada(),
                            consulta.getAtivo(),
                            clienteDTO,
                            funcionarioDTO
                    );
                })
                .collect(Collectors.toList());
    }


    public ConsultaDTO toConsultaDTO(Consulta consulta) {
        if (consulta == null) return null;

        ClienteSimplesDTO clienteDTO = consulta.getCliente() != null
                ? clienteConverter.toClienteSimplesDTO(consulta.getCliente())
                : null;

        FuncionarioSimplesDTO funcionarioDTO = consulta.getFuncionario() != null
                ? funcionarioConverter.toFuncionarioSimplesDTO(consulta.getFuncionario())
                : null;

    return new ConsultaDTO(
            consulta.getId(),
            consulta.getDataConsulta(),
            consulta.getRemarcada(),
            consulta.getAtivo(),
            clienteDTO,
            funcionarioDTO
    );
    }
}
