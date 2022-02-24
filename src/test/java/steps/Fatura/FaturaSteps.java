package steps.Fatura;

import api.Fatura.FaturasApi;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import query.FaturaQuery;
import tech.dock.rest.state.SharedData;

public class FaturaSteps {

    FaturasApi faturaApi = new FaturasApi();

    SharedData sharedData;

    public FaturaSteps(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Dado("uma requisicao que lista todos as Faturas")
    public void umaRequisicaoQueListaTodasFaturas() {
        sharedData.setRequest(faturaApi.listarFatura());
    }

    @Entao("teste")
    public void teste() {
        FaturaQuery faturaQuery = new FaturaQuery();
        System.out.println(faturaQuery.getContas());
    }
}
