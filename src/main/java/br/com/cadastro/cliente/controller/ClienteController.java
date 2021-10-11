package br.com.cadastro.cliente.controller;

import br.com.cadastro.cliente.domain.Cliente;
import br.com.cadastro.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    // atributo do service
    @Autowired
    private ClienteService clienteService;

    // método get para buscar todos os clientes
    @GetMapping
    public List<Cliente> getClientes() {
        return clienteService.getClientes();
    }

    // método post para acrescentar novos clientes
    @PostMapping
    public void insertCliente(@RequestBody Cliente cliente) {
        clienteService.insertCliente(cliente);
    }
}
