package org.barbershop.api.core.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.barbershop.api.core.entity.Funcionario;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CadastroUsuarioDTO {

    private Long id;

    @NotBlank
    private String nomeCompleto;

    @NotBlank
    private String email;

    private String celular;

    @NotNull
    @Past
    private LocalDate dataNascimento;

    @NotBlank
    private String senha;

    private CadastroEnderecoDTO endereco;

    public CadastroUsuarioDTO() {
    }

    public CadastroUsuarioDTO(Long id, String nomeCompleto, String email, String celular, LocalDate dataNascimento, String senha, CadastroEnderecoDTO endereco) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.celular = celular;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(@NotBlank String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public @NotBlank String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public @NotNull @Past LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(@NotNull @Past LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public @NotBlank String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank String senha) {
        this.senha = senha;
    }

    public CadastroEnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(CadastroEnderecoDTO endereco) {
        this.endereco = endereco;
    }

}
