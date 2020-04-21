package fr.foreach.pokego.dto;

import fr.foreach.pokego.entity.Pokemon;

import java.util.List;
import java.util.stream.Collectors;

public class PokemonDto {

    private Integer id;
    private String surnom;
    private Integer niveau;
    private DresseurDto dresseur;
    private EspeceDto espece;
    private List<AttaqueDto> attaques;

    public PokemonDto() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurnom() {
        return surnom;
    }

    public void setSurnom(String surnom) {
        this.surnom = surnom;
    }

    public Integer getNiveau() {
        return niveau;
    }

    public void setNiveau(Integer niveau) {
        this.niveau = niveau;
    }

    public DresseurDto getDresseur() {
        return dresseur;
    }

    public void setDresseur(DresseurDto dresseur) {
        this.dresseur = dresseur;
    }

    public EspeceDto getEspece() {
        return espece;
    }

    public void setEspece(EspeceDto espece) {
        this.espece = espece;
    }

    public List<AttaqueDto> getAttaques() {
        return attaques;
    }

    public void setAttaques(List<AttaqueDto> attaques) {
        this.attaques = attaques;
    }

    public PokemonDto(Pokemon pokemon) {
        id = pokemon.getId();
        surnom = pokemon.getSurnom();
        niveau = pokemon.getNiveau();
        if (pokemon.getDresseur() != null) {
            dresseur = new DresseurDto(pokemon.getDresseur());
        }
        if (pokemon.getEspece() != null) {
            espece = new EspeceDto(pokemon.getEspece());
        }
        if (pokemon.getAttaques() != null) {
            attaques = pokemon.getAttaques().stream()
                    .map(AttaqueDto::new)
                    .collect(Collectors.toList());
        }
    }

    public Pokemon toPokemon() {
        Pokemon pokemon = new Pokemon();
        pokemon.setId(id);
        pokemon.setSurnom(surnom);
        pokemon.setNiveau(niveau);
        if (dresseur != null) {
            pokemon.setDresseur(dresseur.toDresseur());
        }
        if (espece != null) {
            pokemon.setEspece(espece.toEspece());
        }
        if (attaques != null) {
            pokemon.setAttaques(attaques.stream()
                    .map(AttaqueDto::toAttaque)
                    .collect(Collectors.toList()));
        }
        return pokemon;
    }
}
