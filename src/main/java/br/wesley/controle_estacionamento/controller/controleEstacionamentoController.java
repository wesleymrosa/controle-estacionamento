package br.wesley.controle_estacionamento.controller;

import br.wesley.controle_estacionamento.dtos.ControleEstacionamentoDTO;
import br.wesley.controle_estacionamento.entity.ControleEstacionamentoEntity;
import br.wesley.controle_estacionamento.repositories.ControleEstacionamentoRepository;
import br.wesley.controle_estacionamento.services.ControleEstacionamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@RequestMapping(value = "v1")
public class controleEstacionamentoController {

    private final ControleEstacionamentoService controleEstacionamentoService;
    private final ControleEstacionamentoRepository controleEstacionamentoRepository;

    public controleEstacionamentoController(ControleEstacionamentoService controleEstacionamentoService,
                                            ControleEstacionamentoRepository controleEstacionamentoRepository) {
        this.controleEstacionamentoService = controleEstacionamentoService;
        this.controleEstacionamentoRepository = controleEstacionamentoRepository;
    }

    @GetMapping(value = "teste-da-api")
    public ResponseEntity<String> testeDaApi() {
        return ResponseEntity.ok().body("A API controle-estacionamento está funcionando !");
    }

    @PostMapping
    public ResponseEntity<Object> saveParkingSpot
            (@RequestBody @Valid ControleEstacionamentoDTO controleEstacionamentoDTO) {
        var controleEstacionamentoEntity = new ControleEstacionamentoEntity();
        BeanUtils.copyProperties(ControleEstacionamentoDTO, controleEstacionamentoEntity);
        controleEstacionamentoEntity.setDataDeRegistro(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(controleEstacionamentoRepository
                .save(controleEstacionamentoEntity));
    }

}
