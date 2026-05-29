package co.pokeapi.principal;

import co.pokeapi.modelos.ConsultaPokemon;
import co.pokeapi.modelos.GerenciadorDeArquivos;
import co.pokeapi.modelos.Pokemon;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {

        //Capturando o que é digita e armazenando em uma variável
        Scanner leitura = new Scanner(System.in);

        //Instanciando o meu objeto da classe Consulta Pokemon
        ConsultaPokemon c = new ConsultaPokemon();

        //Escrevendo o Objeto em um arquivo
        GerenciadorDeArquivos file = new GerenciadorDeArquivos();


        String menu = "";

        while (!menu.equals("3")) {
            System.out.println("\n=== POKÉDEX ===");
            System.out.println("1. Capturar Pokémon");
            System.out.println("2. Ver Pokémons capturados");
            System.out.println("3. Sair\n");
            menu = leitura.nextLine();

            if (menu.equals("1")) {
                System.out.println("Digite o nome ou ID.Dex do Pokémon que deseja capturar: ");
                var captura = leitura.nextLine();

                try {
                    //Faz a busca do pokemon e retorna um objeto Pokemon
                    Pokemon pokemon = c.buscar(captura);
                    file.escreveArquivo(pokemon);
                    // Extraindo só o que interessa
                    System.out.println(pokemon);
                    System.out.println("✅ Captura finalizada com sucesso!");
                } catch (RuntimeException e) {
                    System.out.println("❌ " + e.getMessage());
                } catch (IOException e) {
                    throw new IllegalStateException(e);
                }
            } else if (menu.equals("2")) {
                try {
                    List<Pokemon> capturados = file.listarCapturados();
                    if (capturados.isEmpty()) {
                        System.out.println("Nenhum Pokémon capturado ainda.");
                    } else {
                        System.out.println("\n=== Pokémons Capturados ===");
                        capturados.forEach(p ->
                                System.out.println("• " + p.name().toUpperCase() + " (ID: " + p.id() + ")")
                        );
                    }
                } catch (IOException e) {
                    throw new IllegalStateException(e);
                }

            } else if (!menu.equals("3")) {
                System.out.println("Opção inválida! Digite 1, 2 ou 3.");
            }
        }

        System.out.println("Encerrando a Pokédex. Até logo!");
        leitura.close();
    }
}
