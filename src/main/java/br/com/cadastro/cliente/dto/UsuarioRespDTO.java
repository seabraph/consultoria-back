package br.com.cadastro.cliente.dto;

import br.com.cadastro.cliente.domain.Usuario;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility= JsonAutoDetect.Visibility.ANY)
public class UsuarioRespDTO {

    private Long id;

    private String nome;
    private String email;
    private String senha;

    public UsuarioRespDTO(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    public UsuarioRespDTO(){}

    public static UsuarioRespDTO toDTO(Usuario usuario) {
        return new UsuarioRespDTO(usuario.getNomeUsuario(), usuario.getEmail(), usuario.getSenha());
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
