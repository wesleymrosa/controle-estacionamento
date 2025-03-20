package br.wesley.controle_estacionamento.dtos;

import jakarta.validation.constraints.NotBlank;

public class ControleEstacionamentoDTO {

    private static final long serializable = 1L;
    @NotBlank
    private String numeroDaVaga;
    @NotBlank
    private String placaDoCarro;
    @NotBlank
    private String marcaDoCarro;
    @NotBlank
    private String modeloDoCarro;
    @NotBlank
    private String corDoCarro;
    @NotBlank
    private String nomeDoResponsavel;
    @NotBlank
    private String apartamento;
    @NotBlank
    private String torre;

    public ControleEstacionamentoDTO() {
    }

    public ControleEstacionamentoDTO(String numeroDaVaga, String placaDoCarro, String marcaDoCarro,
                                     String modeloDoCarro, String corDoCarro, String nomeDoResponsavel,
                                     String apartamento, String torre) {
        this.numeroDaVaga = numeroDaVaga;
        this.placaDoCarro = placaDoCarro;
        this.marcaDoCarro = marcaDoCarro;
        this.modeloDoCarro = modeloDoCarro;
        this.corDoCarro = corDoCarro;
        this.nomeDoResponsavel = nomeDoResponsavel;
        this.apartamento = apartamento;
        this.torre = torre;
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

    @Override
    public String toString() {
        return "ControleEstacionamentoDTO{" +
                "numeroDaVaga='" + numeroDaVaga + '\'' +
                ", placaDoCarro='" + placaDoCarro + '\'' +
                ", marcaDoCarro='" + marcaDoCarro + '\'' +
                ", modeloDoCarro='" + modeloDoCarro + '\'' +
                ", corDoCarro='" + corDoCarro + '\'' +
                ", nomeDoResponsavel='" + nomeDoResponsavel + '\'' +
                ", apartamento='" + apartamento + '\'' +
                ", torre='" + torre + '\'' +
                '}';
    }
}