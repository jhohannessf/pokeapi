package co.pokeapi.modelos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

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

    public List<Pokemon> listarCapturados() throws IOException {
        //Cria uma lista Vazia dos Pokemons encontrados
        List<Pokemon> capturados = new ArrayList<>();

        //Cria um objeto File apontando para a pasta pokemons/
        //Não cria a pasta, só cria uma referência para ela, como um endereço.
        File pasta = new File("pokemons");

        //Verifica se a pasta existe e tem arquivos
        if (!pasta.exists() || pasta.listFiles() == null) {
            System.out.println("Nenhum Pokemon capturado ainda.");
            return capturados;
        }

        //Cria o Gson com mesmo FieldNamingPolicy usado ao salvar
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();

        // Percorre cada arquivo .json da pasta
        // O pasta.listFiles() retorna um array com todos os arquivos da pasta.
        for (File arquivo : pasta.listFiles()){ // Lê assim: "para cada File dentro de pasta.listFiles(), chame de arquivo"
            //Filtra apenas arquivos .json, ignorando outros tipos
            if (arquivo.getName().endsWith(".json")){
                // Lê o conteúdo do arquivo e converte para uma String
                String conteudo = new String(Files.readAllBytes(arquivo.toPath()));

                //Converte a String JSON de volta para um objeto Pokemon
                Pokemon pokemon = gson.fromJson(conteudo, Pokemon.class);

                //Adiciona o Pokemon convertido na lista.
                capturados.add(pokemon);
            }
        }
        //Retorna a lista completa com todos os Pokemons encontrados na pasta
        return capturados;
}
}



