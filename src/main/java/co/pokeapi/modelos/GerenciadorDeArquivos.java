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

        // Garante que a pasta existe
        File pasta = new File("pokemons");
        if (!pasta.exists()) {
            pasta.mkdirs();
        }

        // Verifica se o arquivo já existe ANTES de abrir o FileWriter
        File arquivoJson = new File("pokemons/" + pokemon.name() + ".json");
        if (arquivoJson.exists()) {
            System.out.println("⚠️ " + pokemon.name() + " já foi capturado anteriormente!");
            return; // encerra o método sem sobrescrever
        }

        // Salva o arquivo
        try (FileWriter arquivo = new FileWriter(arquivoJson)) {
            arquivo.write(gson.toJson(pokemon));
        }
    }

}


