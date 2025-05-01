package br.com.wefit.desafio.service;

import br.com.wefit.desafio.converter.PessoaConverter;
import br.com.wefit.desafio.dto.in.CadastroPessoaDTO;
import br.com.wefit.desafio.dto.out.PessoaOutDTO;
import br.com.wefit.desafio.model.Pessoa;
import br.com.wefit.desafio.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaConverter converter;
    private final PessoaRepository repository;

    @Transactional
    public PessoaOutDTO cadastrar(CadastroPessoaDTO pessoa) {
        Pessoa salvo = converter.toModel(pessoa);
        salvo = repository.save(salvo);
        return converter.toPessoaOut(salvo);
    }
}
