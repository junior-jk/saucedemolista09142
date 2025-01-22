# language: pt

Funcionalidade: Fluxo completo de compra

  Esquema do Cenário: Comprar multiplos produtos

    Dado que estou na pagina de login
    Quando eu faco login com credenciais validas
    E eu adiciono os produtos "<produto>" ao carrinho
    E eu visualizo o carrinho
    E eu prossigo para o checkout
    E eu preencho as informacoes de checkout
    E eu confirmo a compra
    Então a compra deve ser concluída com sucesso

    Exemplos:
      | produto                |
      | Sauce Labs Backpack    |
      | Sauce Labs Bike Light  |
      | Sauce Labs Bolt T-Shirt|
      | Sauce Labs Onesie      |
