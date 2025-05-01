package br.com.wefit.desafio.converter;

import br.com.wefit.desafio.dto.out.PessoaOutDTO;
import br.com.wefit.desafio.model.Pessoa;
import br.com.wefit.desafio.model.enums.TipoPessoa;
import br.com.wefit.desafio.model.valueobject.Email;
import br.com.wefit.desafio.model.valueobject.Endereco;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import support.CNPJProvider;
import support.CPFProvider;
import support.CadastroPessoaDTOProvider;
import support.EnderecoDTOProvider;
import support.PessoaProvider;

public class PessoaConverterTest {

    private final PessoaConverter converter = new PessoaConverter();

    @Test
    public void toModel() {
        var pessoa = CadastroPessoaDTOProvider.pessoaFisica()
                .cpf(CPFProvider.padrao().getValor())
                .cnpj(CNPJProvider.padrao().getValor())
                .nome("Joao")
                .celular("48111111")
                .telefone("48111111")
                .email("joao@gmail.com")
                .endereco(EnderecoDTOProvider.padrao())
                .build();
        Pessoa resultado = converter.toModel(pessoa);
        Assertions.assertThat(resultado).hasNoNullFieldsOrPropertiesExcept("id");
        Assertions.assertThat(resultado.getTipoPessoa()).isEqualTo(TipoPessoa.PESSOA_FISICA);
        Assertions.assertThat(resultado.getCnpj().getValor()).isEqualTo("19825230000118");
        Assertions.assertThat(resultado.getCpf().getValor()).isEqualTo("94869206056");
        Assertions.assertThat(resultado.getNome()).isEqualTo("Joao");
        Assertions.assertThat(resultado.getCelular()).isEqualTo("48111111");
        Assertions.assertThat(resultado.getTelefone()).isEqualTo("48111111");
        Assertions.assertThat(resultado.getEmail().getValor()).isEqualTo("joao@gmail.com");
        Assertions.assertThat(resultado.getEndereco()).hasNoNullFieldsOrProperties();
    }

    @Test
    public void toPessoaOut() {
        Pessoa pessoa = PessoaProvider.pessoaFisica()
                .id(1L)
                .cnpj(CNPJProvider.padrao())
                .nome("Joao")
                .celular("48111111")
                .telefone("48111111")
                .email(Email.of("joao@gmail.com"))
                .endereco(Endereco.builder()
                        .cep("11011222")
                        .logradouro("rua")
                        .numero("111")
                        .complemento("aaa")
                        .cidade("xx")
                        .bairro("yyy")
                        .estado("SC")
                        .build())
                .build();

        PessoaOutDTO resultado = converter.toPessoaOut(pessoa);
        Assertions.assertThat(resultado).hasNoNullFieldsOrProperties();
        Assertions.assertThat(resultado.getEndereco()).hasNoNullFieldsOrProperties();
    }
}
