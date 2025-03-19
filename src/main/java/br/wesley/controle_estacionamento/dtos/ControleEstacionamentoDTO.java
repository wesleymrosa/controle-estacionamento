package br.wesley.controle_estacionamento.dtos;

import br.wesley.controle_estacionamento.entity.ControleEstacionamentoEntity;

import java.time.LocalDateTime;

public class ControleEstacionamentoDTO {

    private static final long serializable = 1L;
    private String numeroDaVaga;
    private String placaDoCarro;
    private String marcaDoCarro;
    private String modeloDoCarro;
    private String corDoCarro;
    private LocalDateTime dataDeRegistro;
    private String nomeDoResponsavel;
    private String apartamento;
    private String torre;

    public ControleEstacionamentoDTO() {
    }

    public ControleEstacionamentoDTO(ControleEstacionamentoEntity obj) {
        this.numeroDaVaga = obj.getNumeroDaVaga();
        this.placaDoCarro = obj.getPlacaDoCarro();
        this.marcaDoCarro = obj.getMarcaDoCarro();
        this.modeloDoCarro = obj.getModeloDoCarro();
        this.corDoCarro = obj.getCorDoCarro();
        this.dataDeRegistro = obj.getDataDeRegistro();
        this.nomeDoResponsavel = obj.getNomeDoResponsavel();
        this.apartamento = obj.getApartamento();
        this.torre = obj.getTorre();
    }
}
