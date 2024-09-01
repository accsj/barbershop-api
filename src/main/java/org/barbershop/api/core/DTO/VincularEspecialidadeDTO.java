package org.barbershop.api.core.DTO;

import jakarta.validation.constraints.NotNull;

public class VincularEspecialidadeDTO {

    @NotNull
    private Long idFuncionario;
    @NotNull
    private Long idEspecialidade;

    public VincularEspecialidadeDTO() {
    }

    public VincularEspecialidadeDTO(Long idFuncionario, Long idEspecialidade) {
        this.idFuncionario = idFuncionario;
        this.idEspecialidade = idEspecialidade;
    }

    public Long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Long getIdEspecialidade() {
        return idEspecialidade;
    }

    public void setIdEspecialidade(Long idEspecialidade) {
        this.idEspecialidade = idEspecialidade;
    }
}
