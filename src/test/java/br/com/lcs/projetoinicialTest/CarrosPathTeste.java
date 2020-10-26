package br.com.lcs.projetoinicialTest;

import br.com.lcs.projetoinicial.persistence.model.Veiculo;
import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.jayway.restassured.RestAssured.given;

public class CarrosPathTeste extends FunctionalTeste {

    @Test
    public void basicPingTest(){

        given().when().get("veiculo/oi").then().statusCode(200);

    }

    @Test
    public void vereificarSeRetornaBadRequest(){

        given().when().get("veiculo/buscar/Ford").then().statusCode(400);

    }

    //@Test
    @Ignore
    public void vereificarSalvar(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dt1 = LocalDate.parse("15/09/2020", formatter);
        LocalDate dt2 = LocalDate.parse("15/10/2020", formatter);

        Veiculo veiculo = new Veiculo("Corolla","Toyota", 2015, true, dt1, dt2);
        given().contentType("application/json").body(veiculo).when().post("carro/salvar").then().statusCode(200);

    }


}
