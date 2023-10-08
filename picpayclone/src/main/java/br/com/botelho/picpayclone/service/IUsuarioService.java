package br.com.botelho.picpayclone.service;

import java.util.List;

import br.com.botelho.picpayclone.DTO.UsuarioDTO;
import br.com.botelho.picpayclone.modelo.Transacao;
import br.com.botelho.picpayclone.modelo.Usuario;

public interface IUsuarioService {

    Usuario consultarEntidade(String login);

    UsuarioDTO consultar(String login);

    void atualizarSaldo(Transacao transacaoSalva, Boolean isCartaoCredito);

    void validar(Usuario... usuarios);

    List<UsuarioDTO> listar(String login);

}
