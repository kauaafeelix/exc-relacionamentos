package com.weg.centroweg.pessoa_documento.entity;

import com.weg.centroweg.pessoa_documento.entity.enuns.TipoDocumento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    String numero;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoDocumento tipo;

    @OneToOne(mappedBy = "documento")
    private Pessoa pessoa;

    public Documento(String numero, TipoDocumento tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }
}
