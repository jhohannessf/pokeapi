package co.pokeapi.principal;

import co.pokeapi.modelos.ConsultaPokemon;
import co.pokeapi.modelos.GerenciadorDeArquivos;
import co.pokeapi.modelos.Pokemon;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    static void main(String[] args) throws IOException {

        //Capturando o que é digita e armazenando em uma variável
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o nome ou ID.Dex do Pokémon que deseja capturar: ");
        var captura = leitura.nextLine();

        try {
            //Instanciando o meu objeto da classe Consulta Pokemon
            ConsultaPokemon c = new ConsultaPokemon();

            //Faz a busca do pokemon e retorna um objeto Pokemon
            Pokemon pokemon = c.buscar(captura);

            //Escrevendo o Objeto em um arquivo
            GerenciadorDeArquivos file = new GerenciadorDeArquivos();
            file.escreveArquivo(pokemon);

            // Extraindo só o que interessa
            System.out.println(pokemon);
            System.out.println("Captura finalizada com sucesso!");
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Busca finalizada!");
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

    }
}
