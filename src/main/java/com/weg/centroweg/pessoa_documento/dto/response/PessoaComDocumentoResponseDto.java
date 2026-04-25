package com.weg.centroweg.pessoa_documento.dto.response;

public record PessoaComDocumentoResponseDto(
        PessoaResponseDto pessoaResponseDto,
        DocumentoResponseDto documentoResponseDto
) {
}
