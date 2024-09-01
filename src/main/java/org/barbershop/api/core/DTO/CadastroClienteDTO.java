package org.barbershop.api.core.DTO;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class CadastroClienteDTO extends CadastroUsuarioDTO {

    private Long idCliente;

    @NotNull
    private Integer tipoContrato;

    public CadastroClienteDTO() {
    }

    public CadastroClienteDTO(Integer tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public CadastroClienteDTO(Long id, String nomeCompleto, String email, String celular, LocalDate dataNascimento, String senha, CadastroEnderecoDTO endereco, Long idCliente, Integer tipoContrato) {
        super(id, nomeCompleto, email, celular, dataNascimento, senha, endereco);
        this.idCliente = idCliente;
        this.tipoContrato = tipoContrato;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(Integer tipoContrato) {
        this.tipoContrato = tipoContrato;
    }
}
