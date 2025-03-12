package br.wesley.controle_estacionamento.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1")
public class controleEstacionamentoController {
    @GetMapping
    public ResponseEntity<String> testeDaApi() {
        return ResponseEntity.ok().body("A API controle-estacionamento está funcionando !");
    }
}
