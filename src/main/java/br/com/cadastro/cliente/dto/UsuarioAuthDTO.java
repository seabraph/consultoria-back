package br.com.cadastro.cliente.dto;

import br.com.cadastro.cliente.domain.Usuario;

public class UsuarioAuthDTO {
    private String tipo;
    private String email;
    private String nome;
    private String token;

    public UsuarioAuthDTO(String email, String nome, String token, String tipo) {

        this.email = email;
        this.nome = nome;
        this.token = token;
        this.tipo = tipo;
    }

    public UsuarioAuthDTO(){}

    public static UsuarioAuthDTO toDTO(Usuario usuario, String tipo) {
        return new UsuarioAuthDTO(usuario.getEmail(), usuario.getNomeUsuario(), usuario.getToken(), tipo);
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getToken() {
        return token;
    }

    public String getTipo() {
        return tipo;
    }
}
