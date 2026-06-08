# Church Scale API

Backend do sistema de escala para igrejas.  
Projeto desenvolvido como portfólio de estudos Java, seguindo o roadmap [TechGuide Java](https://techguide.sh/pt-BR/path/java/).

## Sobre

Sistema que gerencia voluntários, setores, músicas, setlists e escalas de serviço de uma igreja.  
O domínio é baseado em um app Flutter já em desenvolvimento.

## Stack

- Java 21
- Spring Boot 4
- Spring Data JPA
- Spring Security
- PostgreSQL
- Lombok
- SpringDoc OpenAPI (Swagger)
- Maven

## Estrutura

src/
├── main/java/com/riosmind/churchscale/
│   └── domain/
│       ├── model/          → Music, Volunteer, Sector, Setlist, Scale
│       ├── exception/      → exceções customizadas de domínio
│       └── service/        → regras de negócio
└── test/java/com/riosmind/churchscale/
└── domain/service/     → ScaleServiceTest, SetlistServiceTest

## Regras de negócio

- Voluntário só pode ser alocado se estiver disponível na data da escala
- Músicas duplicadas não podem ser adicionadas ao mesmo setlist (case insensitive)
- Setor sem voluntários alocados lança exceção ao ser consultado

## Roadmap

| Fase | Status | Descrição |
|---|---|---|
| Fase 1 | ✅ Concluída | Domínio puro, sem framework |
| Fase 2 | 🔵 Em andamento | API REST, JPA, autenticação JWT |
| Fase 3 | ⏳ Pendente | SOLID, Design Patterns, testes de integração |
| Fase 4 | ⏳ Pendente | Docker, concorrência, microsserviços |

## Próximos passos

- [ ] Anotações JPA nas entidades
- [ ] Repositórios Spring Data
- [ ] Endpoints REST
- [ ] Autenticação com JWT
- [ ] Documentação Swagger
