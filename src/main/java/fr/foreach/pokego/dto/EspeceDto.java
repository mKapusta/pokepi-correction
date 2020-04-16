package fr.foreach.pokego.dto;

import fr.foreach.pokego.entity.Espece;

public class EspeceDto {

    private Integer id;
    private String nom;
    private TypeDto typePrincipal;
    private TypeDto typeSecondaire;
    private EspeceDto evolutionDe;
    private Integer pokedex;

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

    public TypeDto getTypePrincipal() {
        return typePrincipal;
    }

    public void setTypePrincipal(TypeDto typePrincipal) {
        this.typePrincipal = typePrincipal;
    }

    public TypeDto getTypeSecondaire() {
        return typeSecondaire;
    }

    public void setTypeSecondaire(TypeDto typeSecondaire) {
        this.typeSecondaire = typeSecondaire;
    }

    public EspeceDto getEvolutionDe() {
        return evolutionDe;
    }

    public void setEvolutionDe(EspeceDto evolutionDe) {
        this.evolutionDe = evolutionDe;
    }

    public Integer getPokedex() {
        return pokedex;
    }

    public void setPokedex(Integer pokedex) {
        this.pokedex = pokedex;
    }

    public EspeceDto() {
    }

    public EspeceDto(Espece espece) {
        id = espece.getId();
        nom = espece.getNom();
        pokedex = espece.getPokedex();
        if (espece.getTypePrincipal() != null) {
            typePrincipal = new TypeDto(espece.getTypePrincipal());
        }
        if (espece.getTypeSecondaire() != null) {
            typeSecondaire = new TypeDto(espece.getTypeSecondaire());
        }
        if (espece.getEvolutionDe() != null) {
            evolutionDe = new EspeceDto(espece.getEvolutionDe());
        }
    }

    public Espece toEspece() {
        Espece espece = new Espece();
        espece.setId(id);
        espece.setNom(nom);
        espece.setPokedex(pokedex);
        if (typePrincipal != null) {
            espece.setTypePrincipal(typePrincipal.toType());
        }
        if (typeSecondaire != null) {
            espece.setTypeSecondaire(typeSecondaire.toType());
        }
        if (evolutionDe != null) {
            espece.setEvolutionDe(evolutionDe.toEspece());
        }
        return espece;
    }

}
