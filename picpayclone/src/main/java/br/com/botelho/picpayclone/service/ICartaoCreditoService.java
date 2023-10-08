package br.com.botelho.picpayclone.service;

import br.com.botelho.picpayclone.DTO.CartaoCreditoDTO;
import br.com.botelho.picpayclone.modelo.CartaoCredito;

public interface ICartaoCreditoService {

    CartaoCredito salvar(CartaoCreditoDTO cartaoCredito);

}
