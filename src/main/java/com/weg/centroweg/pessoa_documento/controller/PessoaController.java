package com.weg.centroweg.pessoa_documento.controller;

import com.weg.centroweg.pessoa_documento.dto.request.PessoaRequestDto;
import com.weg.centroweg.pessoa_documento.dto.response.PessoaComDocumentoResponseDto;
import com.weg.centroweg.pessoa_documento.dto.response.PessoaResponseDto;
import com.weg.centroweg.pessoa_documento.service.PessoaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/pessoas")
@RestController
public class PessoaController {

    private final PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<PessoaResponseDto> save (@Valid @RequestBody PessoaRequestDto request){

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(pessoaService.criarPessoa(request));

    }

    @GetMapping
    public ResponseEntity<List<PessoaResponseDto>> findAll (){

        return ResponseEntity.status(HttpStatus.OK)
                .body(pessoaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponseDto> findById(@PathVariable Long id){

        return ResponseEntity.status(HttpStatus.OK)
                .body(pessoaService.buscarPorId(id));
    }

    @PatchMapping("{idPessoa}/documentos/{idDocumento}")
    public ResponseEntity<PessoaComDocumentoResponseDto> associarPessoaAoDocumento(
            @PathVariable Long idPessoa, @PathVariable Long idDocumento
    ){
        return ResponseEntity.status(HttpStatus.OK)
                .body(pessoaService.associarPessoaAoDocumento(idPessoa, idDocumento));
    }
}
