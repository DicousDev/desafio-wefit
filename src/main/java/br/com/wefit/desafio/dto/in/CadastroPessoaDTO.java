package br.com.wefit.desafio.dto.in;

import br.com.wefit.desafio.model.enums.TipoPessoa;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Builder
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CadastroPessoaDTO {

    @NotNull
    private TipoPessoa tipoPessoa;
    @Size(max = 14)
    private String cnpj;
    @Size(max = 11)
    private String cpf;
    @Size(max = 255)
    private String nome;
    @Size(max = 11)
    private String celular;
    @Size(max = 11)
    private String telefone;
    @Size(max = 255)
    private String email;
    @Valid
    private EnderecoDTO endereco;
}
