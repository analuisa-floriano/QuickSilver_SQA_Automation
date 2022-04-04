package steps.Fatura;

import api.Fatura.FaturaApi;
import io.cucumber.java.pt.Dado;
import tech.dock.rest.state.SharedData;

public class FaturaSteps {

    FaturaApi faturaApi = new FaturaApi();

    SharedData sharedData;

    public FaturaSteps(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Dado("uma requisicao que lista todas as Faturas")
    public void umaRequisicaoQueListaTodasFaturas() {
        sharedData.setRequest(faturaApi.listarFatura());
    }

}
