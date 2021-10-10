package br.com.cadastro.cliente.controller;

import br.com.cadastro.cliente.domain.Cliente;
import br.com.cadastro.cliente.service.ClienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    // atributo do service
    private ClienteService clienteService;

    // método get para buscar todos os clientes
    @GetMapping
    public List<Cliente> getClientes() {
        return clienteService.getClientes();
    }
}
