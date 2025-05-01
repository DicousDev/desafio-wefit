package br.com.wefit.desafio.controlleradvice;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ValidationError {

    private String field;
    private String value;
}
