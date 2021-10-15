package br.com.cadastro.cliente.controller;

import br.com.cadastro.cliente.domain.Usuario;
import br.com.cadastro.cliente.enums.Status;
import br.com.cadastro.cliente.repository.UsuarioRepository;
import br.com.cadastro.cliente.service.UsuarioService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("cadastro")
    public void registrarUsuario(@Valid @RequestBody Usuario novoUsuario) {
        this.usuarioService.registrarUsuario(novoUsuario);

        throw new ResponseStatusException(HttpStatus.OK, "Cause description here");
    }

    @PostMapping("login")
    public Status loginUsuario(@Valid @RequestBody Usuario usuario) {
        return usuarioService.loginUsuario(usuario);
    }

    @PostMapping("logout")
    public Status logoutUsuario(@Valid @RequestBody Usuario usuario) {
        return usuarioService.logoutUsuario(usuario);
    }
}
