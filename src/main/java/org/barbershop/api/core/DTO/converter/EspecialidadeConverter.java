package org.barbershop.api.core.DTO.converter;

import org.barbershop.api.core.DTO.CadastroEspecialidadeDTO;
import org.barbershop.api.core.DTO.EspecialidadeDTO;
import org.barbershop.api.core.entity.Especialidade;

import java.util.List;
import java.util.stream.Collectors;

public class EspecialidadeConverter {

    public CadastroEspecialidadeDTO toCadastroEspecialidadeDTO (CadastroEspecialidadeDTO especialidade) {

        return new CadastroEspecialidadeDTO(
                especialidade.getId(),
                especialidade.getNome()
        );
    }

    public List<EspecialidadeDTO> toEspecialidadeDTO(List<Especialidade> especialidades) {
        if (especialidades == null) return null;
        return especialidades.stream()
                .map(especialidade -> new EspecialidadeDTO(
                        especialidade.getId(),
                        especialidade.getNome()
                ))
                .collect(Collectors.toList());
    }
}
