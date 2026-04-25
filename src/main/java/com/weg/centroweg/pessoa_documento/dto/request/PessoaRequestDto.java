package com.weg.centroweg.pessoa_documento.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PessoaRequestDto(
        @NotBlank String nome
) {
}
