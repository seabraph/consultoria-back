package br.com.cadastro.cliente.repository;

import br.com.cadastro.cliente.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
