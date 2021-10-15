package br.com.cadastro.cliente.service;

import br.com.cadastro.cliente.domain.Usuario;
import br.com.cadastro.cliente.enums.Status;
import br.com.cadastro.cliente.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Status registrarUsuario(Usuario novoUsuario) {

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

    public Status loginUsuario(Usuario usuario) {

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
    public Status logoutUsuario(Usuario usuario) {
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
