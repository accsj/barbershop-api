package org.barbershop.api.core.entity;


import jakarta.persistence.*;

@Table(name = "roles")
@Entity(name = "Role")
public class Role {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;

    public Role(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Role() {
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
