package com.weg.centroweg.pessoa_documento.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    private Documento documento;

    public Pessoa(String nome) {
        this.nome = nome;
    }
}
