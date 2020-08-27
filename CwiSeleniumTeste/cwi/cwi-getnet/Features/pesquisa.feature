#language: pt
#encoding: utf-8

Funcionalidade: Buscar GetNet.

Cenário: Buscar Condição de Recebimento para Qualquer Maquininha.
Dado que acessei a pagina.
Quando clicar no botão de pesquisa.
	E informar "superget".
	E clicar no botão procurar.
	E clicar na pagina "8" do resultado das buscas.
	E clicar no resultado da busca "Posso contratar a condição de recebimento de 2% para qualquer maquininha?".	
	E verificar o título do modal "Posso contratar a condição de recebimento de 2% para qualquer maquininha?".
Então o modal deve conter a mensagem "Observação: essa condição de recebimento não é válida para E-commerce.".