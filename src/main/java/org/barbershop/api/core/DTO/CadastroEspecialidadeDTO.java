package org.barbershop.api.core.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CadastroEspecialidadeDTO {

    @NotNull
    private Long id;
    @NotBlank
    private String nome;

    public CadastroEspecialidadeDTO() {
    }

    public CadastroEspecialidadeDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotBlank String nome) {
        this.nome = nome;
    }
}
