package com.weg.centroweg.funcionario_endereco.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String rua;

    @Column(nullable = false)
    private int numero;

    @OneToOne(mappedBy = "endereco")
    private Endereco endereco;

    public Endereco(String rua, int numero) {
        this.rua = rua;
        this.numero = numero;
    }
}
