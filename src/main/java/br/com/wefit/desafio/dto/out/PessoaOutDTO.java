package br.com.wefit.desafio.dto.out;

import br.com.wefit.desafio.dto.in.EnderecoDTO;
import br.com.wefit.desafio.model.enums.TipoPessoa;
import lombok.*;

@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PessoaOutDTO {

    private Long id;
    private TipoPessoa tipoPessoa;
    private String cnpj;
    private String cpf;
    private String nome;
    private String celular;
    private String telefone;
    private String email;
    private EnderecoDTO endereco;
}
