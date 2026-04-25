package com.weg.centroweg.pessoa_documento.repository;

import com.weg.centroweg.pessoa_documento.entity.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {

}
