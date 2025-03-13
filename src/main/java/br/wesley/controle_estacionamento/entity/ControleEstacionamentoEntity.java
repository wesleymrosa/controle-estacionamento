package br.wesley.controle_estacionamento.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.io.Serializable;

@Entity
public class ControleEstacionamentoEntity implements Serializable {

    private static final long serializable = 1L;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
