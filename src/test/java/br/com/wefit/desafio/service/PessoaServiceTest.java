package br.com.wefit.desafio.service;

import br.com.wefit.desafio.converter.PessoaConverter;
import br.com.wefit.desafio.dto.in.CadastroPessoaDTO;
import br.com.wefit.desafio.dto.out.PessoaOutDTO;
import br.com.wefit.desafio.model.Pessoa;
import br.com.wefit.desafio.model.enums.TipoPessoa;
import br.com.wefit.desafio.repository.PessoaRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import support.CadastroPessoaDTOProvider;
import support.PessoaProvider;

public class PessoaServiceTest {

    @Mock
    private PessoaRepository repository;
    private PessoaService service;
    private PessoaConverter converter;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        service = new PessoaService(new PessoaConverter(), repository);
    }

    @Test
    public void deveCadastrarPessoa() {
        CadastroPessoaDTO pessoaDto = CadastroPessoaDTOProvider.pessoaFisica().build();
        Pessoa pessoaProvided = PessoaProvider.pessoaFisica().build();
        Mockito.when(repository.save(Mockito.any(Pessoa.class))).thenReturn(pessoaProvided);

        PessoaOutDTO pessoa = service.cadastrar(pessoaDto);
        Assertions.assertThat(pessoa.getTipoPessoa()).isEqualTo(TipoPessoa.PESSOA_FISICA);
        Assertions.assertThat(pessoa.getCpf()).isEqualTo(pessoaProvided.getCpf().getValor());
    }
}
