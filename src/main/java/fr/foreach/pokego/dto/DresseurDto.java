package fr.foreach.pokego.dto;

import fr.foreach.pokego.entity.Dresseur;

public class DresseurDto {

    private Integer id;
    private String nom;

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

    public DresseurDto(Dresseur dresseur) {
        id = dresseur.getId();
        nom = dresseur.getNom();
    }

    public Dresseur toDresseur() {
        Dresseur dresseur = new Dresseur();
        dresseur.setId(id);
        dresseur.setNom(nom);
        return dresseur;
    }
}
