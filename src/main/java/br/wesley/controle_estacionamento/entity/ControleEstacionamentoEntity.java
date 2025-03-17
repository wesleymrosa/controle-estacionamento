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
    private LocalDateTime registrationDate;

    @Column(nullable = false, length = 130)
    private String responsibleName;

    @Column(nullable = false, length = 30)
    private String apartment;

    @Column(nullable = false, length = 30)
    private String block;
}
