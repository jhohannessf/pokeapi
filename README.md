# 🎮 PokeAPI Console App

Aplicação Java que consome a [PokeAPI](https://pokeapi.co/) para buscar informações de Pokémons e salvar os dados em arquivos JSON localmente.

---

## 📋 Sobre o projeto

Este projeto foi desenvolvido como prática de consumo de APIs REST em Java, trabalhando conceitos como:

- Consumo de API com `HttpClient`
- Conversão de JSON para objetos Java com **Gson**
- Criação de **Records** para modelagem de dados
- Tratamento de exceções customizadas
- Escrita de arquivos JSON no disco

---

## ⚙️ Funcionalidades

- 🔍 Buscar Pokémon por **nome** ou **ID da Pokédex**
- 📄 Exibir informações no console: tipos, habilidades e stats
- 💾 Salvar os dados do Pokémon em um arquivo `.json` na pasta `pokemons/`

---

## 🚀 Como executar

### Pré-requisitos

- Java 17 ou superior
- IntelliJ IDEA
- Maven



### Passos

1. Clone o repositório:
```bash
git clone https://github.com/jhohannessf/pokeapi.git
```

2. Abra o projeto no **IntelliJ IDEA**

3. O Maven baixa as dependências automaticamente — aguarde a sincronização do `pom.xml`

4. Execute a classe `Principal.java` clicando no botão ▶ ao lado do método `main`

### Uso

Ao rodar a aplicação, digite o nome ou o ID do Pokémon quando solicitado:

```
Digite o nome ou ID.Dex do Pokémon que deseja capturar:
> charizard
```

ou

```
Digite o nome ou ID.Dex do Pokémon que deseja capturar:
> 6
```

---

## 📁 Estrutura do projeto

```
src/
└── main/
    └── java/
        └── co/
            └── pokeapi/
                ├── contratos/
                │   └── IConsulta.java          # Interface de consulta
                ├── excecao/
                │   └── ErroDeConversaoBusca.java  # Exceção customizada
                ├── modelos/
                │   ├── Pokemon.java            # Record principal
                │   ├── Ability.java            # Records internos da API
                │   ├── AbilityWrapper.java
                │   ├── Type.java
                │   ├── TypeWrapper.java
                │   ├── Stat.java
                │   ├── StatWrapper.java
                │   ├── Move.java
                │   ├── MoveWrapper.java
                │   ├── ConsultaPokemon.java    # Consumo da API
                │   └── GerenciadorDeArquivos.java  # Salva JSON no disco
                └── principal/
                    └── Principal.java          # Ponto de entrada

pokemons/                                       # Pasta gerada automaticamente com os JSONs
```

---

## 🧪 Exemplo de saída

```
=== CHARIZARD (ID: 6) ===
Tipos: fire, flying
Habilidades: blaze, solar-power
Stats: hp: 78, attack: 84, defense: 78, special-attack: 109, special-defense: 85, speed: 100

Captura finalizada com sucesso!
```

Arquivo gerado em `pokemons/charizard.json`:

```json
{
  "Id": 6,
  "Name": "charizard",
  "Abilities": [
    {
      "Ability": {
        "Name": "blaze"
      }
    }
  ]
}
```

---

## 🛠️ Tecnologias utilizadas

| Tecnologia | Uso |
|---|---|
| Java 17 | Linguagem principal |
| IntelliJ IDEA | IDE de desenvolvimento |
| Maven | Gerenciamento de dependências |
| HttpClient | Requisições HTTP |
| Gson | Serialização/desserialização JSON |
| JUnit 5 | Testes unitários |
| GitHub Actions | CI/CD |
| PokeAPI | Fonte dos dados |

---

## 📚 Conceitos praticados

- **Records** — modelagem imutável de dados
- **Interfaces** — contratos entre classes
- **Generics** — reutilização de código com tipos flexíveis
- **Stream API** — manipulação de listas
- **Exceções customizadas** — tratamento de erros personalizado
- **Try-with-resources** — gerenciamento seguro de arquivos
- **Testes unitários** — validação com JUnit 5
- **CI/CD** — pipeline automatizado com GitHub Actions

---

## 🔗 API utilizada

[PokéAPI](https://pokeapi.co/) — API REST gratuita com dados de todos os Pokémons.

Endpoint utilizado:
```
GET https://pokeapi.co/api/v2/pokemon/{name-or-id}
```

---

## 👨‍💻 Autor

Feito com ☕ e muito treino Pokémon.
