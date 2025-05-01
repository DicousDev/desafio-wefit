package br.com.wefit.desafio.converter;

import br.com.wefit.desafio.model.enums.TipoPessoa;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TipoPessoaConverter implements AttributeConverter<TipoPessoa, String> {

    @Override
    public String convertToDatabaseColumn(TipoPessoa tipoPessoa) {
        return tipoPessoa.getValor();
    }

    @Override
    public TipoPessoa convertToEntityAttribute(String dbData) {
        return TipoPessoa.of(dbData);
    }
}
