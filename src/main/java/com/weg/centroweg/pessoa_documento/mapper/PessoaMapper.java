package com.weg.centroweg.pessoa_documento.mapper;

import com.weg.centroweg.pessoa_documento.dto.request.PessoaRequestDto;
import com.weg.centroweg.pessoa_documento.dto.response.DocumentoResponseDto;
import com.weg.centroweg.pessoa_documento.dto.response.PessoaComDocumentoResponseDto;
import com.weg.centroweg.pessoa_documento.dto.response.PessoaResponseDto;
import com.weg.centroweg.pessoa_documento.entity.Documento;
import com.weg.centroweg.pessoa_documento.entity.Pessoa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PessoaMapper {

    private final DocumentoMapper documentoMapper;

    public Pessoa toEntity (PessoaRequestDto pessoaRequestDto){

        return new Pessoa(
                pessoaRequestDto.nome()
        );
    }

    public PessoaResponseDto toDto (Pessoa pessoa){

        return new PessoaResponseDto(
                pessoa.getId(),
                pessoa.getNome()
        );

    }

    public PessoaComDocumentoResponseDto pessoaComDocumentoResponseDto (Pessoa pessoa){

        DocumentoResponseDto documentoResponseDto = documentoMapper.toDto(pessoa.getDocumento());

        PessoaResponseDto pessoaResponseDto = toDto(pessoa);

        return new PessoaComDocumentoResponseDto(
                pessoaResponseDto,
                documentoResponseDto
        );
    }
}
