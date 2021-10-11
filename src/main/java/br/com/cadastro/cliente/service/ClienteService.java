package br.com.cadastro.cliente.service;

import br.com.cadastro.cliente.domain.Cliente;
import br.com.cadastro.cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getClientes(){
        return clienteRepository.findAll();
    }

    public void insertCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void dropCliente(long idCliente){
        Cliente clienteDrop = this.clienteRepository.findById(idCliente).get();
        clienteRepository.delete(clienteDrop);
    }
}
