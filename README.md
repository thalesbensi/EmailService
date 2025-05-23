# 📧 Email Service - Spring Boot + Amazon SES

Este é um serviço de envio de e-mails construído com **Java + Spring Boot** e **Amazon SES (Simple Email Service)**. A aplicação foi estruturada seguindo os princípios de Clean Architecture, com separação clara entre camadas como `application`, `infrastructure`, `core`, e `adapters`.

---

## 🚀 Tecnologias utilizadas

- Java 17+
- Spring Boot
- Amazon SES (AWS)
- AWS SDK for Java
- Maven
- Lombok
- Clean Architecture

---

## Funcionalidades

- ✅ Envio de emails via Amazon SES
- ✅ API REST para integração
- ✅ Tratamento de exceções customizado
- ✅ Arquitetura limpa e modular
- ✅ Configuração flexível

## ⚙️ Pré-requisitos

Antes de executar o projeto, certifique-se de ter instalado:

- [Java 17+](https://openjdk.org/)
- [Maven 3.6+](https://maven.apache.org/)
- [AWS Account](https://aws.amazon.com/) com SES configurado
- [AWS CLI](https://aws.amazon.com/cli/) (opcional, para configuração)

## 🔧 Configuração
### Configuração do AWS SES

### via variáveis de ambiente no application.properties
```bash
ACESS_KEY_ID=sua-access-key
SECRET_KEY=sua-secret-key
AWS_REGION=us-sua-regiao-aws
```
## 📡 API Endpoints
### POST /api/email
Envia um email através do Amazon SES.

```json
{
  "to": "string (obrigatório)",
  "subject": "string (obrigatório)",
  "body": "string (obrigatório)"
}
```

## 📁 Estrutura do Projeto

```bash
src/main/java/com/thalesbensi/email_service/
├── adapters/
│   └── EmailSenderAdapter.java          # Interface para adaptadores de email
├── application/
│   └── EmailSenderService.java          # Serviço de aplicação
├── controllers/
│   └── EmailSenderController.java       # Controlador REST
├── core/
│   ├── domain/
│   │   └── EmailRequest.java            # Entidade de domínio
│   └── exceptions/
│       └── EmailServiceException.java   # Exceção customizada
├── infrastructure/
│   └── ses/
│       ├── config/
│       │   └── AwsSesConfig.java        # Configuração do AWS SES
│       └── SesEmailSender.java          # Implementação do SES
├── usecases/
│   └── EmailSenderUseCase.java          # Caso de uso
└── EmailServiceApplication.java         # Classe principal
```
### Descrição das Camadas

- Controllers: Camada de interface REST que recebe as requisições HTTP
- Use Cases: Orquestração da lógica de negócio
- Domain: Entidades e regras de negócio do domínio
- Adapters: Interfaces que definem contratos para recursos externos
- Infrastructure: Implementações concretas e configurações
- Application: Serviços de aplicação que coordenam os casos de uso
