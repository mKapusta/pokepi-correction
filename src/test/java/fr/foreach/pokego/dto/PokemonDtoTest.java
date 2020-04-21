package fr.foreach.pokego.dto;

import fr.foreach.pokego.entity.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PokemonDtoTest {

    @Test
    public void constructurFromPokemon() {
        Pokemon base = new Pokemon();
        base.setId(1);

        Pokemon pokemon = new Pokemon();
        pokemon.setId(2);
        pokemon.setSurnom("Roucoups");
        pokemon.setNiveau(17);
        pokemon.setDresseur(new Dresseur());
        pokemon.setAttaques(List.of(new Attaque()));
        pokemon.setEspece(new Espece());

        PokemonDto pokemonDto = new PokemonDto(pokemon);
        assertThat(pokemonDto.getId()).isEqualTo(2);
        assertThat(pokemonDto.getSurnom()).isEqualTo("Roucoups");
        assertThat(pokemonDto.getDresseur()).isNotNull();
        assertThat(pokemonDto.getAttaques()).hasSize(1);
        assertThat(pokemonDto.getEspece()).isNotNull();
        assertThat(pokemonDto.getNiveau()).isEqualTo(17);
    }

    @Test
    void toPokemon() {

        PokemonDto pokemonDto = new PokemonDto();
        pokemonDto.setId(2);
        pokemonDto.setSurnom("Roucoups");
        pokemonDto.setDresseur(new DresseurDto());
        pokemonDto.setAttaques(List.of(new AttaqueDto()));
        pokemonDto.setEspece(new EspeceDto());
        pokemonDto.setNiveau(17);

        Pokemon pokemon = pokemonDto.toPokemon();
        assertThat(pokemon.getId()).isEqualTo(2);
        assertThat(pokemon.getSurnom()).isEqualTo("Roucoups");
        assertThat(pokemon.getDresseur()).isNotNull();
        assertThat(pokemon.getEspece()).isNotNull();
        assertThat(pokemon.getAttaques()).hasSize(1);
        assertThat(pokemon.getNiveau()).isEqualTo(17);
    }


    private Type createType(Integer id, String nom) {
        Type type = new Type();
        type.setNom(nom);
        type.setId(id);
        return type;
    }

    private TypeDto createTypeDto(Integer id, String nom) {
        TypeDto typeDto = new TypeDto();
        typeDto.setNom(nom);
        typeDto.setId(id);
        return typeDto;
    }
}
