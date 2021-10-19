package br.com.cadastro.cliente.controller;

import br.com.cadastro.cliente.domain.StatusResponse;
import br.com.cadastro.cliente.domain.Usuario;
import br.com.cadastro.cliente.dto.DadosLogin;
import br.com.cadastro.cliente.dto.UsuarioAuthDTO;
import br.com.cadastro.cliente.dto.UsuarioRegDTO;
import br.com.cadastro.cliente.service.UsuarioService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping()
@CrossOrigin("*")
public class UsuarioController {


    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuario")
    public ResponseEntity<List<Usuario>> getUsuarios() {
        List<Usuario> lista = usuarioService.getUsuarios();
        return new ResponseEntity<List<Usuario>>(lista, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioAuthDTO> autenticar(@RequestBody DadosLogin dadosLogin){
        Usuario user = usuarioService.autenticar(dadosLogin);
        return new ResponseEntity<UsuarioAuthDTO>(UsuarioAuthDTO.toDTO(user, "Bearer "), HttpStatus.ACCEPTED);
    }

    @PostMapping("/cadastro")
    public ResponseEntity<UsuarioAuthDTO> registrate(@RequestBody UsuarioRegDTO usuarioRegDTO){
        Usuario user = usuarioService.registrar(usuarioRegDTO.toUsuario());

        return  new ResponseEntity<UsuarioAuthDTO>(UsuarioAuthDTO.toDTO(user, "Bearer "), HttpStatus.CREATED);
    }

}
