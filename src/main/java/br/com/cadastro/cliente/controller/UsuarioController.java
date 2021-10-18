package br.com.cadastro.cliente.controller;

import br.com.cadastro.cliente.domain.StatusResponse;
import br.com.cadastro.cliente.domain.Usuario;
import br.com.cadastro.cliente.dto.DadosLogin;
import br.com.cadastro.cliente.dto.UsuarioAuthDTO;
import br.com.cadastro.cliente.dto.UsuarioRegDTO;
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

//    @PostMapping("login")
//    public ResponseEntity<StatusResponse> loginUsuario(@Valid @RequestBody Usuario usuario) {
//        StatusResponse statusResponse = usuarioService.loginUsuario(usuario);
//        return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.OK);
//    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioAuthDTO> autenticar(@RequestBody DadosLogin dadosLogin, @RequestHeader String Authorization){
        Usuario user = usuarioService.autenticar(dadosLogin, Authorization);
        return new ResponseEntity<UsuarioAuthDTO>(UsuarioAuthDTO.toDTO(user, "Bearer "), HttpStatus.ACCEPTED);
    }


//    @PostMapping("cadastro")
//    public ResponseEntity<StatusResponse> registrarUsuario(@Valid @RequestBody Usuario novoUsuario) {
//        System.out.println(novoUsuario.getTipoConta());
//        StatusResponse statusResponse = this.usuarioService.registrarUsuario(novoUsuario);
//        return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.OK);
//    }

    @PostMapping("/user")
    public ResponseEntity<UsuarioAuthDTO> registrate(@RequestBody UsuarioRegDTO usuarioRegDTO){
        Usuario user = usuarioService.registrar(usuarioRegDTO.toUsuario());
        return  new ResponseEntity<UsuarioAuthDTO>(UsuarioAuthDTO.toDTO(user, "Bearer "), HttpStatus.CREATED);
    }

}
