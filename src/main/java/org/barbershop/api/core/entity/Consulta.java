package org.barbershop.api.core.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import org.barbershop.api.core.DTO.CadastroConsultaDTO;

import java.time.OffsetDateTime;

@Table(name = "consultas")
@Entity
@EqualsAndHashCode(of = "id")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_consulta", nullable = false)
    private OffsetDateTime dataConsulta;

    @Column(nullable = false)
    private Boolean remarcada;

    @Column(nullable = false)
    private Boolean ativo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", referencedColumnName = "id", nullable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_funcionario", referencedColumnName = "id", nullable = false)
    private Funcionario funcionario;

    public Consulta() {
    }

    public Consulta(CadastroConsultaDTO dados) {
        this.id = dados.getId();
        this.dataConsulta = dados.getDataConsulta();
        this.remarcada = false;
        this.ativo = true;
        this.cliente = cliente;
        this.funcionario = funcionario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OffsetDateTime getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(OffsetDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public Boolean getRemarcada() {
        return remarcada;
    }

    public void setRemarcada(Boolean remarcada) {
        this.remarcada = remarcada;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
