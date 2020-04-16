package fr.foreach.pokego.dto;

import fr.foreach.pokego.entity.Type;

public class TypeDto {

    private Integer id;
    private String nom;

    public TypeDto() {
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

    public TypeDto(Type type) {
        id = type.getId();
        nom = type.getNom();
    }

    public Type toType() {
        Type type = new Type();
        type.setId(id);
        type.setNom(nom);
        return type;
    }
}
