package br.wesley.controle_estacionamento.services;

import br.wesley.controle_estacionamento.entity.ControleEstacionamentoEntity;
import br.wesley.controle_estacionamento.repositories.ControleEstacionamentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ControleEstacionamentoService {

    private final ControleEstacionamentoRepository controleEstacionamentoRepository;

    public ControleEstacionamentoService(ControleEstacionamentoRepository controleEstacionamentoRepository) {
        this.controleEstacionamentoRepository = controleEstacionamentoRepository;
    }

    @Transactional
    public ControleEstacionamentoEntity salvar(ControleEstacionamentoEntity controleEstacionamentoEntity) {
        return controleEstacionamentoRepository.save(controleEstacionamentoEntity);
    }

    public List<ControleEstacionamentoEntity> listarTudo() {
        return controleEstacionamentoRepository.findAll();
    }
}
