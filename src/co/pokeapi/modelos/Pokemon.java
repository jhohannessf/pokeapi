package co.pokeapi.modelos;

import java.util.List;
import java.util.stream.Collectors;

public record Pokemon(int id, String name,
                      List<AbilityWrapper> abilities,
                      List<TypeWrapper> types,
                      List<StatWrapper> stats,
                      List<MoveWrapper> moves) {

    @Override
    public String toString() {
        String abilitiesFmt = abilities.stream()
                .map(a -> a.ability().name())
                .collect(Collectors.joining(", "));

        String typesFmt = types.stream()
                .map(t -> t.type().name())
                .collect(Collectors.joining(", "));

        String statsFmt = stats.stream()
                .map(s -> s.stat().name() + ": " + s.base_stat())
                .collect(Collectors.joining(", "));

        return """
                === %s ===
                ID Dex: %d
                Tipos: %s
                Habilidades: %s
                Stats: %s
                """.formatted(name.toUpperCase(), id, typesFmt, abilitiesFmt, statsFmt);
    }
}