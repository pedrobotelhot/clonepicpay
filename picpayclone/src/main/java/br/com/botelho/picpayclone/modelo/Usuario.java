package br.com.botelho.picpayclone.modelo;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.botelho.picpayclone.enums.TipoPermissao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "USUARIO")
public class Usuario extends EntidadeBasic {

    @Column(name = "USU_LOGIN", nullable = false)
    private String login;

    @Column(name = "USU_SENHA", nullable = false)
    private String senha;

    @Column(name = "USU_EMAIL", nullable = false)
    private String email;

    @Column(name = "USU_NOME_COMPLETO", nullable = false)
    private String nomeCompleto;

    @Column(name = "USU_CPF", nullable = false)
    private String cpf;

    @Column(name = "USU_DATA_NASCIMENTO", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "USU_NUMERO_TELEFONE", nullable = false)
    private String numeroTelefone;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<CartaoCredito> cartoesCredito;

    @Column(name = "USU_SALDO", nullable = false)
    private Double saldo;

    @Column(name = "USU_ATIVO", nullable = false)
    private Boolean ativo;

    @Enumerated(EnumType.STRING)
    @Column(name = "USU_PERMISSAO", nullable = false)
    private TipoPermissao permissao;

    @Override
    public Collection<? extends GrantedAuthority> getPermissao() {
        return Arrays.asList(new SimpleGrantedAuthority(permissao.getCodigo()));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean getAtivo() {
        return ativo;
    }

}
