package api.Fatura;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import tech.dock.rest.payload.Request;
import tech.dock.rest.util.RestUtils;

public class FaturaApi {

    private final String LISTAR_FATURAS = "/faturas";

    //Schema Section
    private final String LISTAR_FATURAS_SCHEMA = "schemas/fatura/faturas_GET.json";

    public Request listarFatura() {
        RequestSpecification requestSpecification = RestAssured.given()
                .spec(RestUtils.getDefaultRequest())
                .queryParam("idConta", 5)
                .queryParam("situacaoProcessamento", "TODAS");

        Request request = new Request();
        request.setJsonSchemaPath(LISTAR_FATURAS_SCHEMA);
        request.setRequestSpec(requestSpecification);
        return request;

    }
}
