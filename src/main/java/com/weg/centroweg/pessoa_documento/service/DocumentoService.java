package com.weg.centroweg.pessoa_documento.service;

import com.weg.centroweg.pessoa_documento.dto.request.DocumentoRequestDto;
import com.weg.centroweg.pessoa_documento.dto.response.DocumentoResponseDto;
import com.weg.centroweg.pessoa_documento.entity.Documento;
import com.weg.centroweg.pessoa_documento.mapper.DocumentoMapper;
import com.weg.centroweg.pessoa_documento.repository.DocumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.accept.ApiVersionStrategy;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentoService {

    private final DocumentoRepository documentoRepository;
    private final DocumentoMapper documentoMapper;

    public DocumentoResponseDto criarDocumento (DocumentoRequestDto request){

        Documento documento = documentoMapper.toEntity(request);

        documentoRepository.save(documento);

        return documentoMapper.toDto(documento);
    }

    public List<DocumentoResponseDto> listarTodosOsDocumentos(){

        return documentoRepository.findAll()
                .stream()
                .map(documentoMapper::toDto)
                .toList();

    }

    public DocumentoResponseDto buscarPorId (Long id){

        Documento documento = documentoRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Documento não existe."));

        return documentoMapper.toDto(documento);
    }
}
