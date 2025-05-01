package br.com.wefit.desafio.model;

import br.com.wefit.desafio.exception.EntidadeInvalidaRuntimeException;
import br.com.wefit.desafio.model.valueobject.Email;
import br.com.wefit.desafio.model.valueobject.Endereco;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import support.PessoaProvider;

import java.util.stream.Stream;

public class PessoaTest {

    @ParameterizedTest
    @MethodSource(value = "examplesPessoaInvalid")
    public void assertFail(Pessoa.PessoaBuilder pessoaBuilder, String erro) {
        Assertions.assertThatThrownBy(() -> pessoaBuilder.build())
                .isInstanceOf(EntidadeInvalidaRuntimeException.class)
                .hasMessage(erro);
    }

    public static Stream<Arguments> examplesPessoaInvalid() {
        String excedeuCaracteres = "w".repeat(256);
        return Stream.of(
                Arguments.of(Pessoa.builder().tipoPessoa(null), "Tipo pessoa é um campo obrigatório."),
                Arguments.of(PessoaProvider.pessoaFisica().cpf(null), "O campo CPF é obrigatório para pessoa física."),
                Arguments.of(PessoaProvider.pessoaJuridica().cnpj(null), "O campo CNPJ é obrigatório para pessoa juridíca."),
                Arguments.of(PessoaProvider.pessoaFisica().email(Email.of(excedeuCaracteres + "@gmail.com")), "O campo email excedeu o limite de caracteres."),
                Arguments.of(PessoaProvider.pessoaFisica().nome(excedeuCaracteres), "O campo nome excedeu o limite de caracteres."),
                Arguments.of(PessoaProvider.pessoaFisica().celular(excedeuCaracteres), "O campo celular excedeu o limite de caracteres."),
                Arguments.of(PessoaProvider.pessoaFisica().telefone(excedeuCaracteres), "O campo telefone excedeu o limite de caracteres."),
                Arguments.of(PessoaProvider.pessoaFisica().endereco(Endereco.builder().cep("w".repeat(9)).build()), "O campo cep excedeu o limite de caracteres."),
                Arguments.of(PessoaProvider.pessoaFisica().endereco(Endereco.builder().logradouro(excedeuCaracteres).build()), "O campo logradouro excedeu o limite de caracteres."),
                Arguments.of(PessoaProvider.pessoaFisica().endereco(Endereco.builder().numero(excedeuCaracteres).build()), "O campo numero excedeu o limite de caracteres."),
                Arguments.of(PessoaProvider.pessoaFisica().endereco(Endereco.builder().complemento(excedeuCaracteres).build()), "O campo complemento excedeu o limite de caracteres."),
                Arguments.of(PessoaProvider.pessoaFisica().endereco(Endereco.builder().cidade(excedeuCaracteres).build()), "O campo cidade excedeu o limite de caracteres."),
                Arguments.of(PessoaProvider.pessoaFisica().endereco(Endereco.builder().bairro(excedeuCaracteres).build()), "O campo bairro excedeu o limite de caracteres."),
                Arguments.of(PessoaProvider.pessoaFisica().endereco(Endereco.builder().estado(excedeuCaracteres).build()), "O campo estado excedeu o limite de caracteres.")
        );
    }
}
