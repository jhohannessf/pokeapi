🎮 PokeAPI Console App
Aplicação Java que consome a PokeAPI para buscar informações de Pokémons e salvar os dados em arquivos JSON localmente.

📋 Sobre o projeto
Este projeto foi desenvolvido como prática de consumo de APIs REST em Java, trabalhando conceitos como:

Consumo de API com HttpClient
Conversão de JSON para objetos Java com Gson
Criação de Records para modelagem de dados
Tratamento de exceções customizadas
Escrita de arquivos JSON no disco


⚙️ Funcionalidades

🔍 Buscar Pokémon por nome ou ID da Pokédex
📄 Exibir informações no console: tipos, habilidades e stats
💾 Salvar os dados do Pokémon em um arquivo .json na pasta pokemons/


🚀 Como executar
Pré-requisitos

Java 16 ou superior
Maven

Passos
bash# Clone o repositório
git clone https://github.com/seu-usuario/pokeapi-console.git

# Acesse a pasta do projeto
cd pokeapi-console

# Compile o projeto
mvn compile

# Execute
mvn exec:java -Dexec.mainClass="br.com.pokeapi.principal.Principal"
Uso
Ao rodar a aplicação, digite o nome ou o ID do Pokémon quando solicitado:
Digite o nome ou ID.Dex do Pokémon que deseja capturar:
> charizard
ou
Digite o nome ou ID.Dex do Pokémon que deseja capturar:
> 6

📁 Estrutura do projeto
src/
├── excecao/
│   └── ErroDeConversaoBusca.java   # Exceção customizada
├── modelos/
│   ├── Pokemon.java                # Record principal
│   ├── AbilityWrapper.java         # Wrappers da API
│   ├── TypeWrapper.java
│   ├── StatWrapper.java
│   ├── MoveWrapper.java
│   ├── ConsultaPokemon.java        # Consumo da API
│   └── GerenciadorDeArquivos.java  # Salva JSON no disco
└── principal/
└── Principal.java              # Ponto de entrada

pokemons/                           # Pasta gerada automaticamente com os JSONs

🧪 Exemplo de saída
=== CHARIZARD (ID: 6) ===
Tipos: fire, flying
Habilidades: blaze, solar-power
Stats: hp: 78, attack: 84, defense: 78, special-attack: 109, special-defense: 85, speed: 100

Captura finalizada com sucesso!
Arquivo gerado em pokemons/charizard.json:
json{
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

🛠️ Tecnologias utilizadas
TecnologiaUsoJava 16+Linguagem principalHttpClientRequisições HTTPGsonSerialização/desserialização JSONPokeAPIFonte dos dados

📚 Conceitos praticados

Records — modelagem imutável de dados
Interfaces — contratos entre classes
Generics — reutilização de código com tipos flexíveis
Stream API — manipulação de listas
Exceções customizadas — tratamento de erros personalizado
Try-with-resources — gerenciamento seguro de arquivos


🔗 API utilizada
PokéAPI — API REST gratuita com dados de todos os Pokémons.
Endpoint utilizado:
GET https://pokeapi.co/api/v2/pokemon/{name-or-id}

👨‍💻 Autor
Feito com ☕ e muito treino Pokémon.