package br.wesley.controle_estacionamento.repositories;

import br.wesley.controle_estacionamento.entity.ControleEstacionamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ControleEstacionamentoRepository extends JpaRepository<ControleEstacionamentoEntity, Long> {
    boolean existsByPlacaDoCarro(String placaDoCarro);

    boolean existsByNumeroDaVaga(String numeroDaVaga);

    boolean existsByApartamentoAndTorre(String apartamento, String torre);
}
