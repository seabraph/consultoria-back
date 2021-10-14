package br.com.cadastro.cliente.controller;

import br.com.cadastro.cliente.domain.Servico;
import br.com.cadastro.cliente.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servico")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public List<Servico> getServicos() {
        return servicoService.getServicos();
    }

    @PostMapping
    public void insertServico(@RequestBody Servico servico) {
        servicoService.insertServico(servico);
    }

    @DeleteMapping("/{id}")
    public void dropServico(@PathVariable ("id") Long idServico) {
        servicoService.dropServico(idServico);
    }

    @PutMapping
    public void updateServico(@RequestBody Servico servico) {
        servicoService.updateServico(servico);
    }
}
