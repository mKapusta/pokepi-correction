package fr.foreach.pokego.dto;

import fr.foreach.pokego.entity.Attaque;

public class AttaqueDto {

    private Integer id;
    private String nom;
    private Integer puissance;
    private TypeDto type;


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

    public Integer getPuissance() {
        return puissance;
    }

    public void setPuissance(Integer puissance) {
        this.puissance = puissance;
    }

    public TypeDto getType() {
        return type;
    }

    public void setType(TypeDto type) {
        this.type = type;
    }

    public AttaqueDto() {
    }

    public AttaqueDto(Attaque attaque) {
        id = attaque.getId();
        nom = attaque.getNom();
        puissance = attaque.getPuissance();
        if (attaque.getType() != null) {
            type = new TypeDto(attaque.getType());
        }
    }

    public Attaque toAttaque() {
        Attaque attaque = new Attaque();
        attaque.setId(id);
        attaque.setNom(nom);
        attaque.setPuissance(puissance);
        if (type != null) {
            attaque.setType(type.toType());
        }
        return attaque;
    }

}
