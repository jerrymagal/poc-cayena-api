# Poc Desafio Back-end Java
> Projeto desenvolvido para atender aos requisitos do desafio para posição de Developer Java.

# Stack
> Foi utilizada a seguinte stack para o desafio: 

- Java 11
- Spring boot
- Spring data jpa
- Spring web
- Lombok
- MySQL
- Flyway

# Arquitetura
> A divisão do pacote foi feito com base na conceito de Clean Architecture. Foram criados os pacote de api, domain e infrastructure. Dentro do pacote api encontra-se toda lógica
de comunicação externa. Fui utilizado o padrão Rest com Hateoas.
> Na camada de domain estão as classes de domínio como entidades, interfaces services e repositorys.
> Na camada de infrastructure ficam os códigos referente as implementações dos services com regras de negócio e repositorys.

# Execução
> Para rodar a aplicação basta clonar o projeto, configurar a url de banco no arquivo application.properties e sublicar a aplicação. Foi utilizado o flyway para rodar
os scripts de criação das tabelas bem como inserts.
> Na pasta postman na raiz do projeto esta a collection que pode ser importada e utrilizada para testar a api.
