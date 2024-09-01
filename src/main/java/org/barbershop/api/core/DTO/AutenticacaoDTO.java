package org.barbershop.api.core.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AutenticacaoDTO {

    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 8)
    private String senha;

    public AutenticacaoDTO() {
    }

    public AutenticacaoDTO(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }
}
