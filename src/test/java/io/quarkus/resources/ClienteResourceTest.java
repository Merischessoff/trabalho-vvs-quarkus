package io.quarkus.resources;

import static io.restassured.RestAssured.given;

import static org.hamcrest.CoreMatchers.is;

import static org.hamcrest.Matchers.hasItems;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ClienteResourceTest {

    @Test
    public void testClientesEndPoint() {
        given().get("/clientes")
                .then().statusCode(200)
                .and()
                .assertThat()
                .body("idUsuario", hasItems(2))
                .body("login", hasItems("meri"))
                .body("senha", hasItems("teste"))
                .body("nome", hasItems("Meridiane"))
                .body("dataNascimento", hasItems("1991-07-23"))
                .body("cpf", hasItems("111-111-111-11"))
                .body("endereco", hasItems("rua b"));
    }

    @Test
    public void testBuscaLojaEndPoint() {
        given().get("/clientes/buscaLoja/loja/Loja-geral")
                .then().statusCode(200)
                .and()
                .assertThat()
                .body("nomeLoja", hasItems("Loja-geral"));
    }

    @Test
    public void testBuscaClienteProdutoEndPoint() {
        given().get("/clientes/buscaClienteProduto/Beliche")
                .then().statusCode(200)
                .and()
                .assertThat()
                .body("tipo", hasItems("Cama mesa e banho"));
    }

}
