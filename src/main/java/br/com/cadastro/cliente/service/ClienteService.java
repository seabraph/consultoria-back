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
        try {
            clienteRepository.save(cliente);
        } catch (IllegalArgumentException e) {
            e.getMessage();
        }
    }

    public void dropCliente(long idCliente) {
        try {
            Cliente clienteDrop = this.clienteRepository.findById(idCliente).get();
            clienteRepository.delete(clienteDrop);

        } catch (IllegalArgumentException e) {
            e.getMessage();
        }
    }

    public void updateCliente(Cliente cliente) {
        try {
            Cliente clienteUpdate = this.clienteRepository.findById(cliente.getId()).get();

            clienteUpdate.setNome(cliente.getNome());
            clienteUpdate.setSobrenome(cliente.getSobrenome());
            clienteUpdate.setEmail(cliente.getEmail());

            this.clienteRepository.save(clienteUpdate);

        } catch (IllegalArgumentException e) {
            e.getMessage();
        }
    }
}
