package com.weg.centroweg.pessoa_documento.repository;

import com.weg.centroweg.pessoa_documento.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Long id(Long id);
}
