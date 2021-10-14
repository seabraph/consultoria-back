package br.com.cadastro.cliente.service;

import br.com.cadastro.cliente.domain.Servico;
import br.com.cadastro.cliente.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    @Autowired
    ServicoRepository servicoRepository;

    public List<Servico> getServicos(){
        return servicoRepository.findAll();
    }

    public void insertServico(Servico servico){
        try{
            servicoRepository.save(servico);
        }catch (IllegalArgumentException e){
            e.getMessage();
        }
    }

    public void dropServico(long idServico){
        try {
            servicoRepository.deleteById(idServico);
        }catch (IllegalArgumentException e){
            e.getMessage();
        }
    }

    public void updateServico(Servico novoServico){
        try {
            Servico servico = servicoRepository.findById(novoServico.getId()).get();

            servico.setTitulo(novoServico.getTitulo());
            servico.setDescricao(novoServico.getDescricao());
            servico.setValor(novoServico.getValor());

            servicoRepository.save(servico);

        }catch (IllegalArgumentException e) {
            e.getMessage();
        }
    }
}
