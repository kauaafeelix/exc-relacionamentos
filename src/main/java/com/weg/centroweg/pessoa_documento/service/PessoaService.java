package com.weg.centroweg.pessoa_documento.service;

import com.weg.centroweg.pessoa_documento.dto.request.PessoaRequestDto;
import com.weg.centroweg.pessoa_documento.dto.response.PessoaComDocumentoResponseDto;
import com.weg.centroweg.pessoa_documento.dto.response.PessoaResponseDto;
import com.weg.centroweg.pessoa_documento.entity.Documento;
import com.weg.centroweg.pessoa_documento.entity.Pessoa;
import com.weg.centroweg.pessoa_documento.mapper.PessoaMapper;
import com.weg.centroweg.pessoa_documento.repository.DocumentoRepository;
import com.weg.centroweg.pessoa_documento.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final PessoaMapper pessoaMapper;
    private final DocumentoRepository documentoRepository;

    public PessoaResponseDto criarPessoa (PessoaRequestDto request){

        Pessoa pessoa = pessoaMapper.toEntity(request);

        pessoaRepository.save(pessoa);

        return pessoaMapper.toDto(pessoa);
    }

    public List<PessoaResponseDto> listarTodos (){

        return pessoaRepository.findAll()
                .stream()
                .map(pessoaMapper::toDto)
                .toList();
    }

    public PessoaResponseDto buscarPorId (Long id){

        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("A Pessoa não existe"));

        return pessoaMapper.toDto(pessoa);
    }

    public PessoaComDocumentoResponseDto associarPessoaAoDocumento(Long idPessoa, Long idDocumento){

        Pessoa pessoa = pessoaRepository.findById(idPessoa)
                .orElseThrow(() -> new RuntimeException("A Pessoa não existe"));

        Documento documento = documentoRepository.findById(idDocumento)
                .orElseThrow(()-> new RuntimeException("O Documento não exite"));

        pessoa.setDocumento(documento);

        return pessoaMapper.pessoaComDocumentoResponseDto(
                pessoaRepository.save(pessoa)
        );
    }
}
