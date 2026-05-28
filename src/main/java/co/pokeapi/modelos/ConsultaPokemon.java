package co.pokeapi.modelos;

import co.pokeapi.contratos.IConsulta;
import co.pokeapi.excecao.ErroDeConversaoBusca;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaPokemon implements IConsulta {
    private String name;
    private int id;

    //Busca por nome
    public Pokemon buscaPokemon(String name){
        return buscar(name);
    }

    //Busca pelo ID
    public Pokemon buscaPokemon(int id){
        return buscar(String.valueOf(id)); // Converte o int id para String
    }

    public Pokemon buscar(String busca){
        URI url = URI.create("https://pokeapi.co/api/v2/pokemon/" + busca);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();

        try {

            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            //Convertendo de Json para a meu Objeto Record Pokemon
            return new Gson().fromJson(response.body(), Pokemon.class);

        } catch (Exception e){
            throw new ErroDeConversaoBusca("Não consegui capturar este Pokemon na busca (Nome ou ID.Dex inválido).");
        }


    }
}
