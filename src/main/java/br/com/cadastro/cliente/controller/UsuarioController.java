package br.com.cadastro.cliente.controller;

import br.com.cadastro.cliente.domain.StatusResponse;
import br.com.cadastro.cliente.domain.Usuario;
import br.com.cadastro.cliente.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("cadastro")
    public ResponseEntity<StatusResponse> registrarUsuario(@Valid @RequestBody Usuario novoUsuario) {
        StatusResponse statusResponse = this.usuarioService.registrarUsuario(novoUsuario);
        return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.OK);
    }

    @PostMapping("login")
    public ResponseEntity<StatusResponse> loginUsuario(@Valid @RequestBody Usuario usuario) {
        StatusResponse statusResponse = usuarioService.loginUsuario(usuario);
        return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.OK);
    }

    @PostMapping("logout")
    public ResponseEntity<StatusResponse> logoutUsuario(@Valid @RequestBody Usuario usuario) {
        StatusResponse statusResponse = usuarioService.logoutUsuario(usuario);
        return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.OK);
    }
}
