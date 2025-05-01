package support;

import br.com.wefit.desafio.model.valueobject.CNPJ;

public class CNPJProvider {

    public static CNPJ padrao() {
        return CNPJ.of("19825230000118");
    }
}
