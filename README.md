## Trabalho da cadeira de Validação e Verificação de Sistemas

Start Quarkus in Dev mode:
```shell script
./mvnw compile quarkus:dev
```

## Verificação estática no projeto
-pom.xml
-build.yml
-application.properties
-Foi necessário criar login em https://sonarcloud.io/ e seguir o passo a passo para integrar um repositório do github com o sonar.

## Testes unitários
-pom.xml, maven.yml
-ClienteTest.java, verifica método de classe Cliente.java

## Testes de componentes (API)
-pom.xml, maven.yml
-ClienteResourceTest.java, verifica body de url's '/clientes', '/clientes/buscaLoja/loja/Loja-geral' e e /clientes/buscaClienteProduto/Beliche

# Testes de componentes (Mock)
-pom.xml, maven.yml
-ClienteResourceMockTest, verifica os métodos de 'login' e 'alteraDadosCliente' da classe ClienteResource.java 

## Testes de sistema (Cypress)
-spec.cy.js, npm-publish.yml
-Testa a chamada chamada da tela url localhost

