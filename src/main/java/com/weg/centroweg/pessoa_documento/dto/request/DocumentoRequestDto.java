package com.weg.centroweg.pessoa_documento.dto.request;

import com.weg.centroweg.pessoa_documento.entity.enuns.TipoDocumento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DocumentoRequestDto(
        @NotBlank String numero,
        @NotNull TipoDocumento tipo
) {
}
