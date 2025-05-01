package br.com.wefit.desafio.model.enums;

import java.util.Map;

public enum TipoPessoa {

    PESSOA_FISICA("PF"),
    PESSOA_JURIDICA("PJ");

    private final static Map<String, TipoPessoa> tipoPessoaMap = Map.of("PF", PESSOA_FISICA, "PJ", PESSOA_JURIDICA);
    private final String valor;

    TipoPessoa(String valor) {
        this.valor = valor;
    }

    public static TipoPessoa of(String tipoPessoa) {
        return tipoPessoaMap.get(tipoPessoa);
    }

    public String getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "TipoPessoa{" +
                "valor='" + valor + '\'' +
                '}';
    }
}
