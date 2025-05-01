package br.com.wefit.desafio.model;

import br.com.wefit.desafio.model.enums.TipoPessoa;
import br.com.wefit.desafio.model.valueobject.CNPJ;
import br.com.wefit.desafio.model.valueobject.CPF;
import br.com.wefit.desafio.model.valueobject.Email;
import br.com.wefit.desafio.model.valueobject.Endereco;
import br.com.wefit.desafio.validator.GenericValidator;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@EqualsAndHashCode
@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHoraCadastro;
    private TipoPessoa tipoPessoa;

    @Embedded
    private CNPJ cnpj;

    @Embedded
    private CPF cpf;

    @Embedded
    private Email email;

    private String nome;

    private String celular;

    private String telefone;

    @Embedded
    private Endereco endereco;

    public static class PessoaBuilder {

        public Pessoa build() {

            GenericValidator.validation("Tipo pessoa é um campo obrigatório.", () -> Objects.isNull(tipoPessoa));
            GenericValidator.validation("O campo CPF é obrigatório para pessoa física.", () -> TipoPessoa.PESSOA_FISICA.equals(tipoPessoa) && Objects.isNull(cpf));
            GenericValidator.validation("O campo CNPJ é obrigatório para pessoa juridíca.", () -> TipoPessoa.PESSOA_JURIDICA.equals(tipoPessoa) && Objects.isNull(cnpj));

            String excedeuTamanhoTexto = "O campo %s excedeu o limite de caracteres.";
            if(Objects.nonNull(email)) {
                GenericValidator.validateMaxLength(email.getValor(), 255, excedeuTamanhoTexto.formatted("email"));
            }

            GenericValidator.validateMaxLength(nome, 255, excedeuTamanhoTexto.formatted("nome"));
            GenericValidator.validateMaxLength(celular, 255, excedeuTamanhoTexto.formatted("celular"));
            GenericValidator.validateMaxLength(telefone, 255, excedeuTamanhoTexto.formatted("telefone"));

            if(Objects.nonNull(endereco)) {
                GenericValidator.validateMaxLength(endereco.getCep(), 8, excedeuTamanhoTexto.formatted("cep"));
                GenericValidator.validateMaxLength(endereco.getLogradouro(), 255, excedeuTamanhoTexto.formatted("logradouro"));
                GenericValidator.validateMaxLength(endereco.getNumero(), 255, excedeuTamanhoTexto.formatted("numero"));
                GenericValidator.validateMaxLength(endereco.getComplemento(),255, excedeuTamanhoTexto.formatted("complemento"));
                GenericValidator.validateMaxLength(endereco.getCidade(), 255, excedeuTamanhoTexto.formatted("cidade"));
                GenericValidator.validateMaxLength(endereco.getBairro(), 255, excedeuTamanhoTexto.formatted("bairro"));
                GenericValidator.validateMaxLength(endereco.getEstado(), 255, excedeuTamanhoTexto.formatted("estado"));
            }

            dataHoraCadastro = LocalDateTime.now();
            return new Pessoa(id, dataHoraCadastro, tipoPessoa, cnpj, cpf, email, nome, celular, telefone, endereco);
        }
    }
}
