package integration;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import support.ITemplate;
import support.ResponseEntityAssert;

import java.net.URI;

public class PessoaControllerTest extends ITemplate {

    private static final String BASE_URL = "pessoas";

    @Test
    @Sql({"classpath:IT/clean.sql"})
    void deveCadastrarPessoa() {
        String requestBody = readJSON("IT/cadastro-pessoa.json");
        String expected = readJSON("IT/cadastro-pessoa-expected.json");
        URI uri = toURI(BASE_URL);
        ResponseEntity<String> response = restTemplate.sendPOST(uri, requestBody);
        ResponseEntityAssert.assertThat(response)
                .isCreated()
                .responseBody(expected);
    }
}
