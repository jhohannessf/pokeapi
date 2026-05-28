package co.pokeapi.modelos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GerenciadorDeArquivos {
    private String arquivo;

    public void escreveArquivo(Pokemon pokemon) throws IOException {

        //Criando um objeto da biblioteca GsonBuilder, que serve para converter Objeto Java em Json e vice-versa.
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE) // Método que trata letras maiúsculas da chave vinda da requisição API
                .setPrettyPrinting() //Método para salvar o json no formato legível
                .create(); // GsonBuilder termina a configuração e cria o objeto Gson final

        //Define pasta que será salva os pokemons
        File pasta = new File("pokemons");

        //Cria a pasta se ela não existir
        if (!pasta.exists()){
            pasta.mkdirs(); //mkdirs cria a pasta e subpastas se necessário
        }

        //Salva ou Escreve em um arquivo usando o try-with-resouces
        //usar o close() é arriscado se der erro no write, nunca é chamado.
        //Ao usar o try-with-resources, Não é necessário usar o close(),
        // pois caso der erro no write, o try fecha automaticamente.

        try (FileWriter arquivo = new FileWriter("pokemons/" + pokemon.name() + ".json")){
            arquivo.write(gson.toJson(pokemon)); // Convertendo o Objeto Pokemon Record para Json.
        }

    }

}
