package br.com.wefit.desafio.dto.in;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Getter
@Builder
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO {

    @Size(max = 8)
    private String cep;
    @Size(max = 255)
    private String logradouro;
    @Size(max = 255)
    private String numero;
    @Size(max = 255)
    private String complemento;
    @Size(max = 255)
    private String cidade;
    @Size(max = 255)
    private String bairro;
    @Size(max = 255)
    private String estado;
}
