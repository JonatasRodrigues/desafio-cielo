# Descrição

Implantação de microsserviços para o desafio da cielo.

# Pré-requisitos

<li>Java 8</li>
<li>SpringBoot e SpringJPA</li>
<li>Maven 3.5.2</li>
<li>Docker e Docker-Compose</li>
<li>Mysql v. 14 14 for linux</li>
<li>TestNg e JMockit</li>
<li>CircleCi</li>

# Instruções

O comando deverá ser executado via terminal.

Fazer o checkout via GitHub e na raiz do projeto desafio-backend executar o comando abaixo para criar os conteiners Java e Mysql-server e realizar a carga inicial do banco:

- docker-compose up --build

A partir de agora você poderá acessar os serviços pelos endpoints.


### Swagger

http://localhost:8080/swagger-ui.html
