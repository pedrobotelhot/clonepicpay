package br.com.botelho.picpayclone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.botelho.picpayclone.constantes.MensagemValidacao;
import br.com.botelho.picpayclone.modelo.Usuario;
import br.com.botelho.picpayclone.service.IUsuarioService;


@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private IUsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String login) {
        Usuario usuario = usuarioService.consultarEntidade(login);

        if (!validarUsuario(usuario)) {
            throw new UsernameNotFoundException(MensagemValidacao.ERRO_USUARIO_SEM_PERMISSAO);
        }

        return (UserDetails) usuario;
    }

    private boolean validarUsuario(Usuario usuario) {
        boolean usuarioValidado = false;

        if (usuario != null && usuario.getPermissao() != null && usuario.getAtivo()) {
            usuarioValidado = true;
        }

        return usuarioValidado;
    }

}