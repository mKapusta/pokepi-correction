package fr.foreach.pokego.dto;

public class EspeceSearchCriteria {

    private Integer typePrincipalId;
    private String nom;

    public Integer getTypePrincipalId() {
        return typePrincipalId;
    }

    public void setTypePrincipalId(Integer typePrincipalId) {
        this.typePrincipalId = typePrincipalId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
