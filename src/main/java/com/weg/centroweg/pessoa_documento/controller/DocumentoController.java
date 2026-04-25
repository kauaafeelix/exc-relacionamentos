package com.weg.centroweg.pessoa_documento.controller;

import com.weg.centroweg.pessoa_documento.dto.request.DocumentoRequestDto;
import com.weg.centroweg.pessoa_documento.dto.response.DocumentoResponseDto;
import com.weg.centroweg.pessoa_documento.service.DocumentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documentos")
@RequiredArgsConstructor
public class DocumentoController {

    private final DocumentoService service;


    @PostMapping
    public ResponseEntity<DocumentoResponseDto> save (@Valid @RequestBody DocumentoRequestDto request){

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.criarDocumento(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentoResponseDto> findById(@PathVariable Long id){

        return ResponseEntity.status(HttpStatus.OK)
                .body(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<DocumentoResponseDto>> findAll(){

        return ResponseEntity.status(HttpStatus.OK).body(service.listarTodosOsDocumentos());
    }
}
