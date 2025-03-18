package br.wesley.controle_estacionamento.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_controle_estacionamento")
public class ControleEstacionamentoEntity implements Serializable {
    private static final long serializable = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true, length = 10)
    private String numeroDaVaga;

    @Column(nullable = false, unique = true, length = 7)
    private String placaDoCarro;

    @Column(nullable = false, length = 70)
    private String marcaDoCarro;

    @Column(nullable = false, length = 70)
    private String modeloDoCarro;

    @Column(nullable = false, length = 70)
    private String corDoCarro;

    @Column(nullable = false)
    private LocalDateTime dataDeRegistro;

    @Column(nullable = false, length = 130)
    private String nomeDoResponsavel;

    @Column(nullable = false, length = 30)
    private String apartamento;

    @Column(nullable = false, length = 30)
    private String torre;

    public ControleEstacionamentoEntity() {
    }

    public ControleEstacionamentoEntity(Long id, String numeroDaVaga, String placaDoCarro, String marcaDoCarro,
                                        String modeloDoCarro, String corDoCarro, LocalDateTime dataDeRegistro,
                                        String nomeDoResponsavel, String apartamento, String torre) {
        this.id = id;
        this.numeroDaVaga = numeroDaVaga;
        this.placaDoCarro = placaDoCarro;
        this.marcaDoCarro = marcaDoCarro;
        this.modeloDoCarro = modeloDoCarro;
        this.corDoCarro = corDoCarro;
        this.dataDeRegistro = dataDeRegistro;
        this.nomeDoResponsavel = nomeDoResponsavel;
        this.apartamento = apartamento;
        this.torre = torre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroDaVaga() {
        return numeroDaVaga;
    }

    public void setNumeroDaVaga(String numeroDaVaga) {
        this.numeroDaVaga = numeroDaVaga;
    }

    public String getPlacaDoCarro() {
        return placaDoCarro;
    }

    public void setPlacaDoCarro(String placaDoCarro) {
        this.placaDoCarro = placaDoCarro;
    }

    public String getMarcaDoCarro() {
        return marcaDoCarro;
    }

    public void setMarcaDoCarro(String marcaDoCarro) {
        this.marcaDoCarro = marcaDoCarro;
    }

    public String getModeloDoCarro() {
        return modeloDoCarro;
    }

    public void setModeloDoCarro(String modeloDoCarro) {
        this.modeloDoCarro = modeloDoCarro;
    }

    public String getCorDoCarro() {
        return corDoCarro;
    }

    public void setCorDoCarro(String corDoCarro) {
        this.corDoCarro = corDoCarro;
    }

    public LocalDateTime getDataDeRegistro() {
        return dataDeRegistro;
    }

    public void setDataDeRegistro(LocalDateTime dataDeRegistro) {
        this.dataDeRegistro = dataDeRegistro;
    }

    public String getNomeDoResponsavel() {
        return nomeDoResponsavel;
    }

    public void setNomeDoResponsavel(String nomeDoResponsavel) {
        this.nomeDoResponsavel = nomeDoResponsavel;
    }

    public String getApartamento() {
        return apartamento;
    }

    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }

    public String getTorre() {
        return torre;
    }

    public void setTorre(String torre) {
        this.torre = torre;
    }
}
