import co.pokeapi.excecao.ErroDeConversaoBusca;
import co.pokeapi.modelos.ConsultaPokemon;
import co.pokeapi.modelos.Pokemon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConsultaPokemonTest {

    ConsultaPokemon consulta = new ConsultaPokemon();

    @Test
    void deveLancarExcecaoComNomeInvalido() {
        // Verifica se lança a exceção certa ao buscar algo que não existe
        assertThrows(ErroDeConversaoBusca.class, () -> {
            consulta.buscar("pokemon-invalido-xzy");
        });
    }

    @Test
    void deveBuscarPokemonPorNome() {
        Pokemon pokemon = consulta.buscar("pikachu");

        assertNotNull(pokemon);                              // não é nulo
        assertEquals("pikachu", pokemon.name());   // nome correto
        assertTrue(pokemon.id() > 0);             // tem ID válido
    }

    @Test
    void deveBuscarPokemonPorId() {
        Pokemon pokemon = consulta.buscar("25"); // pikachu é o 25

        assertNotNull(pokemon);
        assertEquals(25, pokemon.id());
    }
}

