package br.com.botelho.picpayclone.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.botelho.picpayclone.DTO.TransacaoDTO;

public interface ITransacaoService {

    TransacaoDTO processar(TransacaoDTO transacaoDTO);

    Page<TransacaoDTO> listar(Pageable paginacao, String usuario);

}
