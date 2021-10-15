package br.com.cadastro.cliente.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nomeUsuario;

    @NotBlank
    private String senha;

    @NotBlank
    private boolean estaLogado;

    public Usuario() {
    }
    public Usuario(String nomeUsuario, String senha) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.estaLogado = false;
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
}
