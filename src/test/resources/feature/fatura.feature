#  language: pt

@AllScenarios
Funcionalidade: Listar Faturas

  Cenário: Listar Todas as Faturas
    #Dado uma requisicao que lista todos as Faturas
    #Quando enviar requisicao do tipo GET para o path /faturas
    #Entao deve retornar codigo de status 200
    #Entao deve validar se o contrato esta correto
    Entao teste