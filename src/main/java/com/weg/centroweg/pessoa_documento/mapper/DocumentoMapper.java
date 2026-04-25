package com.weg.centroweg.pessoa_documento.mapper;

import com.weg.centroweg.pessoa_documento.dto.request.DocumentoRequestDto;
import com.weg.centroweg.pessoa_documento.dto.response.DocumentoResponseDto;
import com.weg.centroweg.pessoa_documento.entity.Documento;
import org.springframework.stereotype.Component;

@Component
public class DocumentoMapper {

    public Documento toEntity (DocumentoRequestDto request){

        return new Documento(
                request.numero(),
                request.tipo()
        );
    }

    public DocumentoResponseDto toDto (Documento documento){

        return new DocumentoResponseDto(
                documento.getId(),
                documento.getNumero(),
                documento.getTipo()
        );
    }
}
