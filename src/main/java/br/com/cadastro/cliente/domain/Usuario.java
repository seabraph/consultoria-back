package br.com.cadastro.cliente.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeUsuario;

    private String senha;

    private boolean estaLogado;

    @Column(name = "tipoconta")
    private String tipoConta;

    public Usuario() {
    }

    public Usuario(String nomeUsuario, String senha, boolean estaLogado, String tipoConta) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.estaLogado = estaLogado;
        this.tipoConta = tipoConta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isEstaLogado() {
        return estaLogado;
    }

    public void setEstaLogado(boolean estaLogado) {
        this.estaLogado = estaLogado;
    }

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) return true;
        if (!(objeto instanceof Usuario)) return false;
        Usuario user = (Usuario) objeto;
        return Objects.equals(nomeUsuario, user.nomeUsuario) &&
                Objects.equals(senha, user.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeUsuario, senha,
                estaLogado);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", usuario='" + nomeUsuario + '\'' +
                ", senha='" + senha + '\'' +
                ", loggedIn=" + estaLogado +
                '}';
    }

    public String getTipoConta() {
        return this.tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }
}
