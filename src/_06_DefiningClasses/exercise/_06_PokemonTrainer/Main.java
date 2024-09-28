package _06_DefiningClasses.exercise._06_PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Trainer trainer;
        Pokemon pokemon;
        Map<String, Trainer> trainerMap = new LinkedHashMap<>();
        while (!input.equals("Tournament")){
            String[] tokens = input.split(" ");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            if (trainerMap.containsKey(trainerName)) {
                trainer = trainerMap.get(trainerName);
            } else {
                trainer = new Trainer(trainerName);
            }
            trainer.addPokemon(pokemon);

            trainerMap.putIfAbsent(trainerName, trainer);

            input = scanner.nextLine();
        }
        String command = scanner.nextLine();
        while (!command.equals("End")){
            String element = command;

            trainerMap.values().forEach(trainer1 -> {
                if (trainer1.hasPokemonWithGivenElement(element)){
                    trainer1.increaseBadges();
                } else {
                    trainer1.decreaseHealth();
                    trainer1.removeDiedPokemons();
                }
            });
            command = scanner.nextLine();
        }

        trainerMap.values()
                .stream().sorted((t1, t2) -> Integer.compare(t2.getBadges(), t1.getBadges()))
                .forEach(entry -> {
                    System.out.printf("%s %d %d%n", entry.getName(), entry.getBadges(), entry.getPokemonList().size());
                });

    }
}
