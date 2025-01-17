Olá pessoal essa é uma API-REST para um sistema de estacionamento rotativo, além das funcionalidades de cadastrar buscar, atualizar, excluir, possui as funcionalidades de buscar por parte do nome, buscar por ´parte da placa, os métodos que pode  ocultar o cliente, ou seja exclui o cliente da aplicação mas não do banco de dados, e torna o cliente visível a aplicação novamente, nesse caso específico eu criei um método que busca apenes os clientes que estão ativos, ou seja, os visíveis, e o método tradicional que busca todos ou seja, os ativos e não ativos, alguns desses métodos são a título de aprendizado, pois acredito que será útil em aplicações futuras.

Como sempre API-REST feita com boas práticas como nomes de variáveis e métodos condizentes com suas funções, separações entre camadas , DTOs, validações, tratamento de exceções com cada método com sua única responsabilidade, documentada,etc.

tecnologias:

-Java

-Spring

-H2

-Postgres

-Docker

-Swagger

Comando para subir o container com  o postgres: docker compose up -d
