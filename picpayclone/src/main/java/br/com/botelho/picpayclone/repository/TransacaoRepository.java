package br.com.botelho.picpayclone.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.botelho.picpayclone.modelo.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    Page<Transacao> findByOrigem_LoginOrDestino_Login(String loginOrigem, String loginDestino, Pageable paginacao);

}
