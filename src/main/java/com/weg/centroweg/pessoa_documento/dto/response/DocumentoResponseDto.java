package com.weg.centroweg.pessoa_documento.dto.response;

import com.weg.centroweg.pessoa_documento.entity.enuns.TipoDocumento;

public record DocumentoResponseDto(
        Long id,
        String numero,
        TipoDocumento tipo
) {
}
