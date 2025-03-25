
package br.wesley.controle_estacionamento.controller;

import br.wesley.controle_estacionamento.dtos.ControleEstacionamentoDTO;
import br.wesley.controle_estacionamento.entity.ControleEstacionamentoEntity;
import br.wesley.controle_estacionamento.services.ControleEstacionamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "v1")
@Tag(name = "Controle de Estacionamento", description = "API para gerenciamento de vagas de estacionamento")
public class controleEstacionamentoController {

    private final ControleEstacionamentoService controleEstacionamentoService;

    public controleEstacionamentoController(ControleEstacionamentoService controleEstacionamentoService) {
        this.controleEstacionamentoService = controleEstacionamentoService;
    }

    @Operation(summary = "Teste de API", description = "Verifica se a API está ativa")
    @GetMapping(value = "/teste-da-api")
    public ResponseEntity<String> testeDaApi() {
        return ResponseEntity.ok().body("A API controle-estacionamento está funcionando !");
    }

    @Operation(summary = "Salvar nova vaga", description = "Cadastra uma nova vaga de estacionamento")
    @ApiResponse(responseCode = "201", description = "Vaga cadastrada com sucesso")
    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody @Valid ControleEstacionamentoDTO controleEstacionamentoDTO) {
        if (controleEstacionamentoService.existsByPlacaDoCarro(controleEstacionamentoDTO.getPlacaDoCarro())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Essa placa de carro já está em uso !");
        }

        if (controleEstacionamentoService.existsByNumeroDaVaga(controleEstacionamentoDTO.getNumeroDaVaga())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Essa vaga já está sendo usada !");
        }

        if (controleEstacionamentoService.existsByApartamentoAndTorre(controleEstacionamentoDTO.getApartamento(),
                controleEstacionamentoDTO.getTorre())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Conflict: Vaga de estacionamento já registrada para este apartamento/bloco");
        }

        var controleEstacionamentoEntity = new ControleEstacionamentoEntity();
        BeanUtils.copyProperties(controleEstacionamentoDTO, controleEstacionamentoEntity);
        controleEstacionamentoEntity.setDataDeRegistro(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(controleEstacionamentoService.salvar(controleEstacionamentoEntity));
    }

    @Operation(summary = "Listar todas as vagas", description = "Retorna todas as vagas cadastradas")
    @ApiResponse(responseCode = "200", description = "Listagem realizada com sucesso")
    @GetMapping
    public ResponseEntity<List<ControleEstacionamentoEntity>> listarTodasAsVagas() {
        return ResponseEntity.ok().body(controleEstacionamentoService.listarTudo());
    }

    @Operation(summary = "Buscar vaga por ID", description = "Retorna os dados de uma vaga específica pelo ID")
    @ApiResponse(responseCode = "200", description = "Vaga encontrada com sucesso")
    @ApiResponse(responseCode = "404", description = "Vaga não encontrada")
    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable(value = "id") Long id) {
        Optional<ControleEstacionamentoEntity> controleEstacionamentoOptional = controleEstacionamentoService.findById(id);
        if (!controleEstacionamentoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Essa vaga não foi encontrada ! ");
        }
        return ResponseEntity.status(HttpStatus.OK).body(controleEstacionamentoOptional.get());
    }

    @Operation(summary = "Deletar vaga por ID", description = "Remove uma vaga do sistema pelo ID")
    @ApiResponse(responseCode = "200", description = "Vaga removida com sucesso")
    @ApiResponse(responseCode = "404", description = "Vaga não encontrada")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarPorId(@PathVariable(value = "id") Long id) {
        Optional<ControleEstacionamentoEntity> parkingSpotModelOptional = controleEstacionamentoService.findById(id);
        if (!parkingSpotModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga de estacionamento não encontrada !");
        }
        controleEstacionamentoService.delete(parkingSpotModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Vaga de estacionamento excluída com sucesso !");
    }

    @Operation(summary = "Atualizar vaga por ID", description = "Atualiza os dados de uma vaga de estacionamento")
    @ApiResponse(responseCode = "200", description = "Vaga atualizada com sucesso")
    @ApiResponse(responseCode = "404", description = "Vaga não encontrada")
    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarVaga(@PathVariable(value = "id") Long id,
                                                @RequestBody @Valid ControleEstacionamentoDTO controleEstacionamentoDTO) {
        Optional<ControleEstacionamentoEntity> optional = controleEstacionamentoService.findById(id);
        if (!optional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga de estacionamento não encontrada !");
        }

        ControleEstacionamentoEntity controleEstacionamentoEntity = optional.get();

        controleEstacionamentoEntity.setNumeroDaVaga(controleEstacionamentoDTO.getNumeroDaVaga());
        controleEstacionamentoEntity.setPlacaDoCarro(controleEstacionamentoDTO.getPlacaDoCarro());
        controleEstacionamentoEntity.setMarcaDoCarro(controleEstacionamentoDTO.getMarcaDoCarro());
        controleEstacionamentoEntity.setModeloDoCarro(controleEstacionamentoDTO.getModeloDoCarro());
        controleEstacionamentoEntity.setCorDoCarro(controleEstacionamentoDTO.getCorDoCarro());
        controleEstacionamentoEntity.setNomeDoResponsavel(controleEstacionamentoDTO.getNomeDoResponsavel());
        controleEstacionamentoEntity.setApartamento(controleEstacionamentoDTO.getApartamento());
        controleEstacionamentoEntity.setTorre(controleEstacionamentoDTO.getTorre());

        controleEstacionamentoService.salvar(controleEstacionamentoEntity);
        return ResponseEntity.status(HttpStatus.OK).body("Vaga atualizada com sucesso.");
    }
}


//package br.wesley.controle_estacionamento.controller;
//
//import br.wesley.controle_estacionamento.dtos.ControleEstacionamentoDTO;
//import br.wesley.controle_estacionamento.entity.ControleEstacionamentoEntity;
//import br.wesley.controle_estacionamento.services.ControleEstacionamentoService;
//import jakarta.validation.Valid;
//import org.springframework.beans.BeanUtils;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDateTime;
//import java.time.ZoneId;
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping(value = "v1")
//public class controleEstacionamentoController {
//    private final ControleEstacionamentoService controleEstacionamentoService;
//
//    public controleEstacionamentoController(ControleEstacionamentoService controleEstacionamentoService) {
//        this.controleEstacionamentoService = controleEstacionamentoService;
//    }
//
//    @GetMapping(value = "/teste-da-api")
//    public ResponseEntity<String> testeDaApi() {
//        return ResponseEntity.ok().body("A API controle-estacionamento está funcionando !");
//    }
//
//    @PostMapping
//    public ResponseEntity<Object> salvar
//            (@RequestBody @Valid ControleEstacionamentoDTO controleEstacionamentoDTO) {
//        if (controleEstacionamentoService.existsByPlacaDoCarro(controleEstacionamentoDTO.getPlacaDoCarro())) {
//            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Essa placa de carro já está em uso !");
//        }
//
//        if (controleEstacionamentoService.existsByNumeroDaVaga(controleEstacionamentoDTO.getNumeroDaVaga())) {
//            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Essa vaga já está sendo usada !");
//        }
//
//        if (controleEstacionamentoService.existsByApartamentoAndTorre(controleEstacionamentoDTO.getApartamento(),
//                controleEstacionamentoDTO.getTorre())) {
//            return ResponseEntity.status(HttpStatus.CONFLICT)
//                    .body("Conflict: Vaga de estacionamento já registrada para este apartamento/bloco");
//        }
////        Essa abordagem era comum no passado e ainda pode ser utilizada atualmente.
////        ControleEstacionamentoEntity controleEstacionamentoEntity = new ControleEstacionamentoEntity();
//        var controleEstacionamentoEntity = new ControleEstacionamentoEntity();
//        BeanUtils.copyProperties(controleEstacionamentoDTO, controleEstacionamentoEntity);
////        Na linha abaixo a data de registro será "setada", inicializada.
//        controleEstacionamentoEntity.setDataDeRegistro(LocalDateTime.now(ZoneId.of("UTC")));
//        return ResponseEntity.status(HttpStatus.CREATED).body(controleEstacionamentoService
//                .salvar(controleEstacionamentoEntity));
//    }
//
//    @GetMapping
//    public ResponseEntity<List<ControleEstacionamentoEntity>> listarTodasAsVagas() {
//        return ResponseEntity.ok().body(controleEstacionamentoService.listarTudo());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Object> buscarPorId(@PathVariable(value = "id") Long id) {
//        Optional<ControleEstacionamentoEntity> controleEstacionamentoOptional = controleEstacionamentoService.findById(id);
//        if (!controleEstacionamentoOptional.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Essa vaga não foi encontrada ! ");
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(controleEstacionamentoOptional.get());
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Object> deletarPorId(@PathVariable(value = "id") Long id) {
//        Optional<ControleEstacionamentoEntity> parkingSpotModelOptional = controleEstacionamentoService.findById(id);
//        if (!parkingSpotModelOptional.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga de estacionamento não encontrada !");
//        }
//        controleEstacionamentoService.delete(parkingSpotModelOptional.get());
//        return ResponseEntity.status(HttpStatus.OK).body("Vaga de estacionamento excluída com sucesso !");
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Object> atualizarVaga(@PathVariable(value = "id") Long id,
//                                                @RequestBody @Valid ControleEstacionamentoDTO controleEstacionamentoDTO) {
//        Optional<ControleEstacionamentoEntity> optional = controleEstacionamentoService.findById(id);
//        if (!optional.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga de estacionamento não encontrada !");
//        }
//
//        ControleEstacionamentoEntity controleEstacionamentoEntity = optional.get();
//
//        controleEstacionamentoEntity.setNumeroDaVaga(controleEstacionamentoDTO.getNumeroDaVaga());
//        controleEstacionamentoEntity.setPlacaDoCarro(controleEstacionamentoDTO.getPlacaDoCarro());
//        controleEstacionamentoEntity.setMarcaDoCarro(controleEstacionamentoDTO.getMarcaDoCarro());
//        controleEstacionamentoEntity.setModeloDoCarro(controleEstacionamentoDTO.getModeloDoCarro());
//        controleEstacionamentoEntity.setCorDoCarro(controleEstacionamentoDTO.getCorDoCarro());
//        controleEstacionamentoEntity.setNomeDoResponsavel(controleEstacionamentoDTO.getNomeDoResponsavel());
//        controleEstacionamentoEntity.setApartamento(controleEstacionamentoDTO.getApartamento());
//        controleEstacionamentoEntity.setTorre(controleEstacionamentoDTO.getTorre());
//
//        controleEstacionamentoService.salvar(controleEstacionamentoEntity);
//        return ResponseEntity.status(HttpStatus.OK).body("Vaga atualizada com sucesso.");
//    }
//}