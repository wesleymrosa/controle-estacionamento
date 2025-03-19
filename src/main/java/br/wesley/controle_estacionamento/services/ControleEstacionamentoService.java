package br.wesley.controle_estacionamento.services;

import br.wesley.controle_estacionamento.entity.ControleEstacionamentoEntity;
import br.wesley.controle_estacionamento.repositories.ControleEstacionamentoRepository;
import org.springframework.stereotype.Service;

@Service
public class ControleEstacionamentoService {

    private final ControleEstacionamentoRepository controleEstacionamentoRepository;

    public ControleEstacionamentoService(ControleEstacionamentoRepository controleEstacionamentoRepository) {
        this.controleEstacionamentoRepository = controleEstacionamentoRepository;
    }

    public ControleEstacionamentoEntity salvar (ControleEstacionamentoEntity controleEstacionamentoEntity) {
        return controleEstacionamentoRepository.save(controleEstacionamentoEntity);
    }


}
