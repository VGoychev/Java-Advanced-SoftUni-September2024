package _06_DefiningClasses.exercise._06_PokemonTrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Trainer {
    private String name;
    private int badges;
    List<Pokemon> pokemonList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public Trainer(String name) {
        this.name = name;
        this.badges = 0;
        this.pokemonList = new ArrayList<>();
    }

    public void increaseBadges(){
        this.badges++;
    }
    public boolean hasPokemonWithGivenElement(String element){
        return this.pokemonList.stream()
                .map(Pokemon::getElement)
                .collect(Collectors.toList())
                .contains(element);
    }
    public void decreaseHealth(){
        this.pokemonList.forEach(pokemon -> pokemon.setHealth(pokemon.getHealth() - 10));
    }

    public void removeDiedPokemons() {
        this.pokemonList.removeIf(pokemon -> pokemon.getHealth() <= 0);
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemonList.add(pokemon);
    }
}
