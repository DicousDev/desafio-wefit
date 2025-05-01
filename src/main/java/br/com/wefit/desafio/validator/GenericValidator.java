package br.com.wefit.desafio.validator;

import br.com.wefit.desafio.exception.EntidadeInvalidaRuntimeException;

import java.util.Objects;
import java.util.function.BooleanSupplier;

public class GenericValidator {

    public static void validation(String mensagemErro, BooleanSupplier validations) {
        if(validations.getAsBoolean()) {
            throw new EntidadeInvalidaRuntimeException(mensagemErro);
        }
    }

    public static void validateMaxLength(String value, int maxSize, String mensagemErro) {
        validation(mensagemErro, () -> Objects.nonNull(value) && value.length() > maxSize);
    }
}
