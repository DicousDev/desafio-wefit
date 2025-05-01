package br.com.wefit.desafio.controller;

import br.com.wefit.desafio.controlleradvice.ApiResponseError;
import br.com.wefit.desafio.dto.in.CadastroPessoaDTO;
import br.com.wefit.desafio.dto.out.PessoaOutDTO;
import br.com.wefit.desafio.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaService service;

    public PessoaController(PessoaService pessoaService) {
        service = pessoaService;
    }

    @Operation(summary = "Cadastro de pessoa.",
            description = "Cadastro de pessoa física ou pessoa jurídica.",
            responses = {
                @ApiResponse(
                        description = "Pessoa cadastrada no sistema com sucesso.",
                        responseCode = "201",
                        useReturnTypeSchema = true,
                        content = {
                                @Content(
                                        schema = @Schema(implementation = PessoaOutDTO.class),
                                        mediaType = MediaType.APPLICATION_JSON_VALUE
                                )
                        }
                ),
                @ApiResponse(
                        description = "Dados enviados estão inválidos.",
                        responseCode = "400",
                        useReturnTypeSchema = true,
                        content = {
                                @Content(
                                        schema = @Schema(implementation = ApiResponseError.class),
                                        mediaType = MediaType.APPLICATION_JSON_VALUE
                                )
                        }
                ),
                @ApiResponse(
                        description = "Erro inesperado do servidor.",
                        responseCode = "500",
                        useReturnTypeSchema = true,
                        content = {
                                @Content(
                                        schema = @Schema(implementation = ApiResponseError.class),
                                        mediaType = MediaType.APPLICATION_JSON_VALUE
                                )
                        }
                )
            }
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PessoaOutDTO cadastrar(@RequestBody @Valid CadastroPessoaDTO pessoa) {
        return service.cadastrar(pessoa);
    }
}
