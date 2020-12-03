package fr.foreach.pokego.dto;

import fr.foreach.pokego.entity.Pokemon;

import java.util.List;
import java.util.stream.Collectors;

public class PokemonInTeamDto {

    private Integer id;
    private String surnom;
    private Integer niveau;
    private EspeceDto espece;
    private List<AttaqueDto> attaques;

    public PokemonInTeamDto(Pokemon pokemon) {
        this.id = pokemon.getId();
        this.surnom = pokemon.getSurnom();
        this.niveau = pokemon.getNiveau();
        if (pokemon.getEspece() != null) {
            this.espece = new EspeceDto(pokemon.getEspece());
        }
        if (pokemon.getAttaques() != null) {
            this.attaques = pokemon.getAttaques().stream()
                    .map(AttaqueDto::new)
                    .collect(Collectors.toList());
        }
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
}
