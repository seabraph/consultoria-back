package br.com.cadastro.cliente.service;

import br.com.cadastro.cliente.domain.StatusResponse;
import br.com.cadastro.cliente.domain.Usuario;
import br.com.cadastro.cliente.dto.DadosLogin;
import br.com.cadastro.cliente.repository.UsuarioRepository;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired TokenService tokenService;

    public StatusResponse registrarUsuario(Usuario novoUsuario) {

        List<Usuario> usuarios = usuarioRepository.findAll();

        for (Usuario usuario: usuarios) {

            if (usuario.equals(novoUsuario)) {
                return new StatusResponse("usuário já existe", "erro");
            }
        }

        if (novoUsuario.getTipoConta().intern() == "admin") {
            usuarioRepository.save(novoUsuario);
            return new StatusResponse("usuário do tipo admin cadastrado com sucesso", "sucesso");
        } else {
            usuarioRepository.save(novoUsuario);
            return new StatusResponse("usuário cadastrado com sucesso", "sucesso");
        }
    }

//    public StatusResponse loginUsuario(Usuario usuario) {
//
//        List<Usuario> usuarios = usuarioRepository.findAll();
//
//        for (Usuario u : usuarios) {
//
//            if (u.equals(usuario)) {
//                usuario.setEstaLogado(true);
//
//                if (usuario.getTipoConta().intern() == "admin") {
//                    usuarioRepository.save(usuario);
//                    return new StatusResponse("login do admin realizado com sucesso", "sucesso");
//                } else {
//                    usuarioRepository.save(usuario);
//                    return new StatusResponse("login do usuário realizado com sucesso", "sucesso");
//                }
//            }
//        }
//        return new StatusResponse("erro ao realizar login", "erro");
//    }

    public Usuario authenticate(DadosLogin dados, String token){
        Usuario user = usuarioRepository.findByEmail(dados.getEmail()).orElseThrow(ExistingEmailException::new);
        if(dados.getSenha().equals(user.getSenha()) && !token.isEmpty() && validate(token)) {
            return user;
        }
        else {
            throw new InvalidLoginException();
        }
    }
    private boolean validate(String token) {
        try {
            String tokenTratado = token.replace("Bearer ", "");
            Claims claims = tokenService.decodificadoToken(tokenTratado);

            System.out.println(claims.getIssuer());
            System.out.println(claims.getIssuedAt());
            //Verifica se o token está expirado
            if (claims.getExpiration().before(new Date(System.currentTimeMillis()))) throw new ExpiredTokenException();
            System.out.println(claims.getExpiration());
            return true;
        } catch (ExpiredTokenException et){
            et.printStackTrace();
            throw et;
        } catch (Exception e) {
            e.printStackTrace();
            throw new InvalidTokenException();
        }

    }


    public StatusResponse logoutUsuario(Usuario usuario) {
        List<Usuario> usuarios = usuarioRepository.findAll();

        for (Usuario u : usuarios) {
            if (u.equals(usuario)) {
                usuario.setEstaLogado(false);
                usuarioRepository.save(usuario);
                return new StatusResponse("logout realizado com sucesso", "sucesso");
            }
        }
        return new StatusResponse("erro ao realizar logout", "erro");
    }

}
