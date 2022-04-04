package steps;

import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import tech.dock.rest.client.BaseApi;
import tech.dock.rest.state.SharedData;
import io.restassured.http.Method;


import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SharedSteps {
        private SharedData sharedData;

        public SharedSteps(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Quando("enviar requisicao do tipo {} para o path {word}")
    public void enviarRequisicaoDoTipoParaOPath(Method method, String path) {
        BaseApi baseApi = new BaseApi();
        sharedData.setResponse(baseApi.doRequest(sharedData.getRequest(), method, path));
    }

    @Entao("deve retornar codigo de status {int}")
    public void deveRetornarCodigoDeStatus(Integer statusCode) {
        int actualStatusCode = sharedData.getResponse().statusCode();
        assertThat(actualStatusCode).isEqualTo(statusCode);
    }

    @Entao("deve validar se o contrato esta correto")
    public void deveValidarSeOContratoEstaCorreto() {
        BaseApi baseApi = new BaseApi();
        if (Objects.nonNull(sharedData.getRequest().getJsonSchemaPath()))
            baseApi.validateJSONSchema(sharedData.getResponse(), sharedData.getRequest().getJsonSchemaPath());
    }
}
