package query;

import tech.dock.test.data.enumeration.DatabaseTypeEnum;
import tech.dock.test.data.pool.GenericData;

import java.util.Map;

public class FaturaQuery {
    private final String LISTAR_TODAS_AS_FATURAS = """
             
             SELECT TOP 1 * FROM
             (
             SELECT TOP 100 ATUAL.ID_CONTA AS ID_CONTA,
             CONVERT(DATETIME, ATUAL.PROXIMOVENCIMENTOPADRAO, 103) AS DATAVENCIMENTOFATURA,
             ATUAL.DEBITOSNACIONAIS AS DEBITO,
             CAST(0.00 AS MONEY) AS CREDITO,
             NULL AS VALOR_PAGAMENTO_MINIMO,
             ATUAL.SALDOATUALFINAL + ATUAL.CREDITOSNACIONAIS - ATUAL.DEBITOSNACIONAIS AS SALDO_ANTERIOR,
             CONVERT(DATETIME, ATUAL.PROXIMOVENCIMENTOPADRAO, 103) AS DATA_VENCIMENTO_REAL,
             CV.DATAPREVISTACORTE AS DATA_CORTE,
             NULL AS ID_BOLETO,
             ATUAL.FLAGEMITEEXTRATO,
             HC.CETANUAL,
             HC.CETMENSAL
             FROM ESTADOSCONTAS ATUAL
             INNER JOIN CONTROLEVENCIMENTOS CV ON CV.DATAVENCIMENTO = CONVERT(DATETIME, ATUAL
            .PROXIMOVENCIMENTOPADRAO, 103)
             INNER JOIN STATUSCONTA S ON S.STATUS = ATUAL.STATUSCONTA
             INNER JOIN HISTORICOSCORRENTES HC ON HC.ID_CONTA = ATUAL.ID_CONTA
             ) AS TAB
             ORDER BY NEWID()
            """;

    GenericData sqlServerData = new GenericData(DatabaseTypeEnum.SQL_SERVER, true);

    public Map<String, Object> getContas() {
        return sqlServerData.getSingleResult(LISTAR_TODAS_AS_FATURAS);
    }
}
