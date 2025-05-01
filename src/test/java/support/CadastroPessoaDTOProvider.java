package support;

import br.com.wefit.desafio.dto.in.CadastroPessoaDTO;
import br.com.wefit.desafio.model.enums.TipoPessoa;

public class CadastroPessoaDTOProvider {

    public static CadastroPessoaDTO.CadastroPessoaDTOBuilder pessoaFisica() {
        return CadastroPessoaDTO.builder()
                .tipoPessoa(TipoPessoa.PESSOA_FISICA)
                .cpf(CPFProvider.padrao().getValor());
    }

    public static CadastroPessoaDTO.CadastroPessoaDTOBuilder pessoaJuridica() {
        return CadastroPessoaDTO.builder()
                .tipoPessoa(TipoPessoa.PESSOA_JURIDICA)
                .cpf(CNPJProvider.padrao().getValor());
    }
}
