package br.com.wefit.desafio.converter;

import br.com.wefit.desafio.dto.in.CadastroPessoaDTO;
import br.com.wefit.desafio.dto.in.EnderecoDTO;
import br.com.wefit.desafio.dto.out.PessoaOutDTO;
import br.com.wefit.desafio.model.valueobject.CNPJ;
import br.com.wefit.desafio.model.valueobject.CPF;
import br.com.wefit.desafio.model.valueobject.Email;
import br.com.wefit.desafio.model.valueobject.Endereco;
import br.com.wefit.desafio.model.Pessoa;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Objects;

@Component
public class PessoaConverter {

    public Pessoa toModel(CadastroPessoaDTO pessoa) {
        return Pessoa.builder()
                .tipoPessoa(pessoa.getTipoPessoa())
                .cnpj(StringUtils.hasText(pessoa.getCnpj()) ? CNPJ.of(pessoa.getCnpj()) : null)
                .cpf(StringUtils.hasText(pessoa.getCpf()) ? CPF.of(pessoa.getCpf()) : null)
                .email(StringUtils.hasText(pessoa.getEmail()) ? Email.of(pessoa.getEmail()) : null)
                .nome(pessoa.getNome())
                .celular(pessoa.getCelular())
                .telefone(pessoa.getTelefone())
                .endereco(toEndereco(pessoa.getEndereco()))
                .build();
    }

    public PessoaOutDTO toPessoaOut(Pessoa pessoa) {
        return PessoaOutDTO.builder()
                .id(pessoa.getId())
                .tipoPessoa(pessoa.getTipoPessoa())
                .cnpj(Objects.isNull(pessoa.getCnpj()) ? null : pessoa.getCnpj().getValor())
                .cpf(Objects.isNull(pessoa.getCpf()) ? null : pessoa.getCpf().getValor())
                .nome(pessoa.getNome())
                .celular(pessoa.getCelular())
                .telefone(pessoa.getTelefone())
                .email(Objects.isNull(pessoa.getEmail()) ? null : pessoa.getEmail().getValor())
                .endereco(toEnderecoDTO(pessoa.getEndereco()))
                .build();
    }

    private Endereco toEndereco(EnderecoDTO endereco) {

        if(Objects.isNull(endereco)) {
            return null;
        }

        return Endereco.builder()
                .cep(endereco.getCep())
                .logradouro(endereco.getLogradouro())
                .numero(endereco.getNumero())
                .complemento(endereco.getComplemento())
                .cidade(endereco.getCidade())
                .bairro(endereco.getBairro())
                .estado(endereco.getEstado())
                .build();
    }

    private EnderecoDTO toEnderecoDTO(Endereco endereco) {

        if(Objects.isNull(endereco)) {
            return null;
        }

        return EnderecoDTO.builder()
                .cep(endereco.getCep())
                .logradouro(endereco.getLogradouro())
                .numero(endereco.getNumero())
                .complemento(endereco.getComplemento())
                .cidade(endereco.getCidade())
                .bairro(endereco.getBairro())
                .estado(endereco.getEstado())
                .build();
    }
}
