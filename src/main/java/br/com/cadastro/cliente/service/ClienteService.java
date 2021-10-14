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
            clienteRepository.deleteById(idCliente);

        } catch (IllegalArgumentException e) {
            e.getMessage();
        }
    }

    public void updateCliente(Cliente novoCliente) {
        try {
            Cliente cliente = clienteRepository.findById(novoCliente.getId()).get();

            cliente.setNome(novoCliente.getNome());
            cliente.setSobrenome(novoCliente.getSobrenome());
            cliente.setEmail(novoCliente.getEmail());

            clienteRepository.save(cliente);

        } catch (IllegalArgumentException e) {
            e.getMessage();
        }
    }
}
