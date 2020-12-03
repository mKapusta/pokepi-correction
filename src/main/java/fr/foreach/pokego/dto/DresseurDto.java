package fr.foreach.pokego.dto;

import fr.foreach.pokego.entity.Dresseur;

import java.util.List;

public class DresseurDto {

    private Integer id;
    private String nom;
    private List<PokemonInTeamDto> equipe;

    public DresseurDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<PokemonInTeamDto> getEquipe() {
        return equipe;
    }

    public void setEquipe(List<PokemonInTeamDto> equipe) {
        this.equipe = equipe;
    }

    public DresseurDto(Dresseur dresseur) {
        id = dresseur.getId();
        nom = dresseur.getNom();
    }

    public DresseurDto(Integer id, String nom, List<PokemonInTeamDto> equipe) {
        this.id = id;
        this.nom = nom;
        this.equipe = equipe;
    }

    public Dresseur toDresseur() {
        Dresseur dresseur = new Dresseur();
        dresseur.setId(id);
        dresseur.setNom(nom);
        return dresseur;
    }
}
