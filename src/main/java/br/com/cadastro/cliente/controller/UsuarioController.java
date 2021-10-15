package br.com.cadastro.cliente.controller;

import br.com.cadastro.cliente.domain.Usuario;
import br.com.cadastro.cliente.enums.Status;
import br.com.cadastro.cliente.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping("usario/registrar")
    public Status registrarUsuario(@Valid @RequestBody Usuario novoUsuario) {
        List<Usuario> usuarios = usuarioRepository.findAll();
        System.out.println("Novo usuario: " + novoUsuario.toString());

        for (Usuario usuario: usuarios) {
            System.out.println("Usuario registrado: " + novoUsuario.toString());

            if (usuario.equals(novoUsuario)) {
                System.out.println("Usuario já existe");
                return Status.USUARIO_JA_EXISTE;
            }
        }

        usuarioRepository.save(novoUsuario);
        return Status.SUCESSO;
    }

    @PostMapping("usuario/login")
    public Status loginUsuario(@Valid @RequestBody Usuario usuario) {
        List<Usuario> usuarios = usuarioRepository.findAll();

        for (Usuario u : usuarios) {
            if (u.equals(usuario)) {
                usuario.setEstaLogado(true);
                usuarioRepository.save(usuario);
                return Status.SUCESSO;
            }
        }
        return Status.FALHA;
    }

    @PostMapping("usuario/logout")
    public Status logoutUsuario(@Valid @RequestBody Usuario usuario) {
        List<Usuario> usuarios = usuarioRepository.findAll();

        for (Usuario u : usuarios) {
            if (u.equals(usuario)) {
                usuario.setEstaLogado(false);
                usuarioRepository.save(usuario);
                return Status.SUCESSO;
            }
        }
        return Status.FALHA;
    }
}
