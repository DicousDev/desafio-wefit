package br.com.wefit.desafio.repository;

import br.com.wefit.desafio.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
