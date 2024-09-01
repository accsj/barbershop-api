package org.barbershop.api.core.DTO;

import org.barbershop.api.core.entity.Role;

import java.time.LocalDate;

public class UsuarioDTO {

    private Long id;

    private String nomeCompleto;

    private String email;

    private String celular;

    private LocalDate dataNascimento;

    private Boolean emailVerificado;

    private Boolean ativo;

    private Role role;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Long id, String nomeCompleto, String email, String celular, LocalDate dataNascimento, Boolean emailVerificado, Boolean ativo, Role role) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.celular = celular;
        this.dataNascimento = dataNascimento;
        this.emailVerificado = emailVerificado;
        this.ativo = ativo;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Boolean getEmailVerificado() {
        return emailVerificado;
    }

    public void setEmailVerificado(Boolean emailVerificado) {
        this.emailVerificado = emailVerificado;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
