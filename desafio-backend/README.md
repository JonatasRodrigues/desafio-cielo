# Descrição

Implantação de microsserviços para o desafio da cielo.

# Pré-requisitos

<li>Java 8</li>
<li>SpringBoot</li>
<li>Maven 3.5.2</li>
<li>Docker Compose</li>
<li>Docker</li>
<li>Mysql v. 14 14 for linux</li>
<li>TestNg e JMockit</li>
<li>CircleCi</li>

# Instruções

Todos os comandos deverão ser executados via terminal.

Fazer o checkout via GitHub e na raiz do projeto desafio-backend executar o comando abaixo para criar os conteiners Java e Mysql-server e realizar a carga inicial do banco:

- docker-compose up --build

A partir de agora você poderá acessar os serviços pelos endpoints.


### Swagger

http://localhost:8080/swagger-ui.html
