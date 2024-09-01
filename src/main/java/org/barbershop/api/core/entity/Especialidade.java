package org.barbershop.api.core.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import org.barbershop.api.core.DTO.CadastroEspecialidadeDTO;

@Table
@Entity
@EqualsAndHashCode(of = "id")
public class Especialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;


    public Especialidade() {
    }

    public Especialidade(CadastroEspecialidadeDTO dados) {
        this.id = dados.getId();
        this.nome = dados.getNome();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
