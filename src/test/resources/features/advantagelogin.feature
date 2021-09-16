#language:pt
#encoding:UTF-8
#author:Jardeson Santos
#date:23/08/2021
#version: 1.0

@login
Funcionalidade: Login
  Sendo (quem?)
  Posso (o que?)
  Para que ( beneficio a ser alcan�ado)

  Contexto: Modal exibida
    Dado que a modal esteja sendo exibida

  @fechaModalFora
  Cenario: Fechar a modal ao clicar fora da mesma
    Quando for realizado um clique fora da modal
    Entao a janela modal deve ser fechada

  @fechaModalIcone
  Cenario: Fechar a modal ao clicar no icone fechar
    Quando for realizado um clique icone de fechar da modal
    Entao a janela modal deve ser fechada

  @CreateNewAccount
  Cenario: Link Create New Account
    Quando for realizado um clique em Create New Account
    Entao a pagina Create Account deve ser exibida

  @LoginSucesso
  Esquema do Cenario: Realizar Login com <identificacao>
    Quando os campos de login forem preenchidos com os valores
      | usuario  | <usuario>  |
      | senha    | <senha>    |
      | remember | <remember> |
    Quando for realizado o clique no botao sign in
    Entao deve ser possivel logar no sistema

    Exemplos: 
      | identificacao       | usuario | senha    | remember |
      | campos obrigat�rios | chronos | Senha123 | false    |
      | todos os campos     | chronos | Senha123 | true     |

  @LoginInvalido
  Esquema do Cenario: Realizar Login com <identificacao>
    Quando os campos de login forem preenchidos com os valores
      | usuario  | <usuario>  |
      | senha    | <senha>    |
      | remember | <remember> |
    Quando for realizado o clique no botao sign in
    Entao o sistema devera exibir uma mensagem de erro

    Exemplos: 
      | identificacao        | usuario | senha     | remember |
      | com usu�rio inv�lido | chronos1 | Senha123 | false    |
      | com senha inv�lida   | chronos | 1Senha123 | false    |

  @LoginEmBranco
  Esquema do Cenario: Realizar login com <identificacao>
    Quando os campos de login forem preenchidos com os valores
      | usuario  | <usuario>  |
      | senha    | <senha>    |
      | remember | <remember> |
    Entao o botao sign in deve permanecer desabilitado

    Exemplos: 
      | identificacao         | usuario | senha | remember |
      | com usu�rio em branco |         | senha | false    |
      | com senha em branco   | chronos |       | false    |
