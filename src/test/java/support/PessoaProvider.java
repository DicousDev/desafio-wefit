package support;

import br.com.wefit.desafio.model.Pessoa;
import br.com.wefit.desafio.model.enums.TipoPessoa;

public class PessoaProvider {

    public static Pessoa.PessoaBuilder pessoaFisica() {
        return Pessoa.builder()
                .tipoPessoa(TipoPessoa.PESSOA_FISICA)
                .cpf(CPFProvider.padrao());
    }

    public static Pessoa.PessoaBuilder pessoaJuridica() {
        return Pessoa.builder()
                .tipoPessoa(TipoPessoa.PESSOA_JURIDICA)
                .cnpj(CNPJProvider.padrao());
    }
}
