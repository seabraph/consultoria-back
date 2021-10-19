package br.com.cadastro.cliente.repository;
import br.com.cadastro.cliente.domain.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
}
