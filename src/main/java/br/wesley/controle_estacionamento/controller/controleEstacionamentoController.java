package br.wesley.controle_estacionamento.controller;

import br.wesley.controle_estacionamento.dtos.ControleEstacionamentoDTO;
import br.wesley.controle_estacionamento.entity.ControleEstacionamentoEntity;
import br.wesley.controle_estacionamento.services.ControleEstacionamentoService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(controleEstacionamentoController.class);


    public controleEstacionamentoController(ControleEstacionamentoService controleEstacionamentoService) {
        this.controleEstacionamentoService = controleEstacionamentoService;
    }


    @GetMapping(value = "/teste-da-api")
    public ResponseEntity<String> testeDaApi() {
        return ResponseEntity.ok().body("A API controle-estacionamento está funcionando !");
    }

    @PostMapping
    public ResponseEntity<Object> salvar
            (@RequestBody @Valid ControleEstacionamentoDTO controleEstacionamentoDTO) {
        if (controleEstacionamentoService.existsByPlacaDoCarro(controleEstacionamentoDTO.getPlacaDoCarro())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: License Plate Car is already in use!");
        }

        if (controleEstacionamentoService.existsByNumeroDaVaga(controleEstacionamentoDTO.getNumeroDaVaga())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot is already in use!");
        }

        if (controleEstacionamentoService.existsByApartamentoAndTorre(controleEstacionamentoDTO.getApartamento(), controleEstacionamentoDTO.getTorre())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot already registered for this apartment/block!");
        }

//        Essa abordagem era comum no passado e ainda pode ser utilizada atualmente.
//        ControleEstacionamentoEntity controleEstacionamentoEntity = new ControleEstacionamentoEntity();
        var controleEstacionamentoEntity = new ControleEstacionamentoEntity();
        BeanUtils.copyProperties(controleEstacionamentoDTO, controleEstacionamentoEntity);
//        Na linha abaixo a data de registro será "setada", inicializada.
        controleEstacionamentoEntity.setDataDeRegistro(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(controleEstacionamentoService
                .salvar(controleEstacionamentoEntity));
    }

}
