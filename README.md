# 🎮 PokeAPI Console App

![CI](https://github.com/jhohannessf/pokeapi/actions/workflows/ci.yml/badge.svg)

Aplicação Java que consome a [PokeAPI](https://pokeapi.co/) para buscar informações de Pokémons e salvar os dados em arquivos JSON localmente.

---

## 📋 Sobre o projeto

Este projeto foi desenvolvido como prática de consumo de APIs REST em Java, trabalhando conceitos como:

- Consumo de API com `HttpClient`
- Conversão de JSON para objetos Java com **Gson**
- Criação de **Records** para modelagem de dados
- Tratamento de exceções customizadas
- Escrita e leitura de arquivos JSON no disco
- Menu interativo no console

---

## ⚙️ Funcionalidades

- 🔍 Buscar Pokémon por **nome** ou **ID da Pokédex**
- 📄 Exibir informações no console: tipos, habilidades e stats
- 💾 Salvar os dados do Pokémon em um arquivo `.json` na pasta `pokemons/`
- 📋 Listar todos os Pokémons já capturados
- ⚠️ Verificar duplicidade antes de salvar
- 🚫 Tratar erros da API (404, falhas de conexão)

---

## 🚀 Como executar

### Pré-requisitos

- Java 26 ou superior
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

Ao rodar a aplicação, um menu interativo será exibido:

```
=== POKÉDEX ===
1. Capturar Pokémon
2. Ver Pokémons capturados
3. Sair
Escolha uma opção:
```

Para capturar, digite o nome ou ID quando solicitado:

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
├── main/
│   └── java/
│       └── co/
│           └── pokeapi/
│               ├── contratos/
│               │   └── IConsulta.java             # Interface de consulta
│               ├── excecao/
│               │   └── ErroDeConversaoBusca.java  # Exceção customizada
│               ├── modelos/
│               │   ├── Pokemon.java               # Record principal
│               │   ├── Ability.java               # Records internos da API
│               │   ├── AbilityWrapper.java
│               │   ├── Type.java
│               │   ├── TypeWrapper.java
│               │   ├── Stat.java
│               │   ├── StatWrapper.java
│               │   ├── Move.java
│               │   ├── MoveWrapper.java
│               │   ├── ConsultaPokemon.java        # Consumo da API
│               │   └── GerenciadorDeArquivos.java  # Salva JSON no disco
│               └── principal/
│                   └── Principal.java             # Ponto de entrada
└── test/
    └── java/
        └── co/
            └── pokeapi/
                ├── ConsultaPokemonTest.java        # Testes de consulta à API
                └── ErroDeConversaoBuscaTest.java   # Testes da exceção customizada

pokemons/                                          # Pasta gerada automaticamente com os JSONs
```

---

## 🧪 Exemplo de saída

```
=== POKÉDEX ===
1. Capturar Pokémon
2. Ver Pokémons capturados
3. Sair
Escolha uma opção:
> 1

Digite o nome ou ID.Dex do Pokémon que deseja capturar:
> charizard

=== CHARIZARD ===
ID Dex: 6
Tipos: fire, flying
Habilidades: blaze, solar-power
Stats: hp: 78, attack: 84, defense: 78, special-attack: 109, special-defense: 85, speed: 100

✅ Captura finalizada com sucesso!
```

Listando pokémons capturados:

```
=== Pokémons Capturados ===
• CHARIZARD (ID: 6)
• PIKACHU (ID: 25)
• BULBASAUR (ID: 1)
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
| Java 26 | Linguagem principal |
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
- **Serialização/Desserialização** — ciclo completo com Gson (`toJson` e `fromJson`)
- **Tratamento de status HTTP** — respostas 404 e erros de conexão
- **Manipulação de arquivos** — leitura e escrita de arquivos JSON no disco

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
