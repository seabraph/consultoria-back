package br.com.cadastro.cliente.service;

import br.com.cadastro.cliente.domain.Cliente;
import br.com.cadastro.cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> getCliente(){
        return clienteRepository.findAll();
    }
}
