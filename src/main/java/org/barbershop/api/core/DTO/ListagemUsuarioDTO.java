package org.barbershop.api.core.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.barbershop.api.core.entity.Role;

import java.time.LocalDate;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ListagemUsuarioDTO {

    private Long id;

    private String nomeCompleto;

    private String email;

    private String celular;

    private LocalDate dataNascimento;

    private Boolean emailVerificado;

    private Boolean ativo;

    private Role role;

    private ClienteDTO cliente;

    private FuncionarioDTO funcionario;

    private List<EnderecoDTO> enderecos;

    public ListagemUsuarioDTO() {
    }

    public ListagemUsuarioDTO(Long id, String nomeCompleto, String celular, String email, LocalDate dataNascimento, Boolean emailVerificado, Boolean ativo, Role role, ClienteDTO cliente, FuncionarioDTO funcionario, List<EnderecoDTO> enderecos) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.celular = celular;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.emailVerificado = emailVerificado;
        this.ativo = ativo;
        this.role = role;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.enderecos = enderecos;
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

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public FuncionarioDTO getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioDTO funcionario) {
        this.funcionario = funcionario;
    }

    public List<EnderecoDTO> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<EnderecoDTO> enderecos) {
        this.enderecos = enderecos;
    }
}
