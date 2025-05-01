package support;

import br.com.wefit.desafio.dto.in.EnderecoDTO;

public class EnderecoDTOProvider {

    public static EnderecoDTO padrao() {
        return EnderecoDTO.builder()
                .cep("11011555")
                .logradouro("Servidão XXX")
                .numero("111")
                .complemento("kitnet")
                .cidade("Florianópolis")
                .bairro("Rio tavares")
                .estado("SC")
                .build();
    }
}
