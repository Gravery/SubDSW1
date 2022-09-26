# SubDSW1

Sub da AA1 de DSW1

Guilherme Calça - 790759


Requisitos
1. CRUD (Create, Read, Update e Delete) de clientes (requer login de
administrador). O sistema deve possuir um cadastro de clientes, com os seguintes
dados: e-mail, senha, CPF, nome, telefone, sexo e data de nascimento.
2. CRUD de lojas (requer login de administrador). O sistema deve possuir um
cadastro de lojas de venda de veículos, com os seguintes dados: e-mail, senha,
CNPJ, nome e descrição.
3. Cadastro de veículo para venda (requer login da loja via e-mail e senha). Depois
de fazer login, a loja pode cadastrar um veículo para venda. O cadastro de veículos
deve possuir os seguintes dados: CNPJ da loja, placa, modelo, chassi, ano,
quilometragem, descrição, valor e fotos (upload de no máximo 10 imagens) do
veículo.
4. Listagem de todos os veículos em uma única página (não requer login). O sistema
deve prover a funcionalidade de filtrar os veículos por modelo.
5. Proposta de compra de veículo (requer login do cliente via e-mail e senha). Ao
clicar em um veículo (requisito 4), o cliente pode realizar uma proposta de
compra. Nesse caso, é necessário que ele apresente o valor da proposta e as
condições de pagamento. A data atual (quando foi realizada a proposta) deve ser
registrada no sistema. O sistema deve restringir que cada cliente tenha apenas uma
proposta em aberto (requisito 7) para cada veículo.
6. Listagem de todos os veículos de uma loja (requer login da loja via e-mail e
senha). Depois de fazer login, a loja pode visualizar todos os seus veículos
cadastrados.
7. Listagem de todas as propostas de compra de um cliente (requer login do cliente
via e-mail e senha). Depois de fazer login, o cliente pode visualizar todas as suas
propostas cadastradas com seus respectivos status.
a. ABERTO indica que ainda se encontra em fase de análise pela loja
(requisito 8). NÃO ACEITO indica que a loja não aceitou a proposta de
compra. ACEITO indica que a loja aceitou a proposta de compra.
8. A loja (requer login da loja via e-mail e senha), para cada proposta de compra,
deve analisar as condições da proposta e atualizar o status da proposta para NÃO
ACEITO ou ACEITO.
o No caso do status NÃO ACEITO, a loja pode informar opcionalmente
uma contraproposta (valor e condições de pagamento). Nesse caso, o
cliente pode ou não aceitar a contraproposta.
o No caso do status ACEITO, a compra é finalizada.
9. O sistema deve tratar todos os erros possíveis (cadastros duplicados, problemas
técnicos, acesso ilegal, etc.) mostrando uma página de erros amigável ao usuário
e registrando o erro no console.


Arquitetura
• Modelo-Visão-Controlador
Tecnologias
• Lado do Servidor: Servlet, JSP, JSTL e JDBC
• Lado do Cliente: HTML, Javascript e CSS
Ambiente de Desenvolvimento
• A compilação e o desenvolvimento devem obrigatoriamente ser realizado via
Maven
• Os arquivos fonte do sistema deve estar hospedados obri
