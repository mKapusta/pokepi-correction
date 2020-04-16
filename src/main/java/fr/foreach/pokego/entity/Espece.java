package fr.foreach.pokego.entity;

import javax.persistence.*;

@Entity
public class Espece {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nom;
    @ManyToOne
    @JoinColumn(name = "id_type_principal")
    private Type typePrincipal;
    @ManyToOne
    @JoinColumn(name = "id_type_secondaire")
    private Type typeSecondaire;
    @OneToOne
    @JoinColumn(name = "id_evolution_de")
    private Espece evolutionDe;
    @Column
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

    public Type getTypePrincipal() {
        return typePrincipal;
    }

    public void setTypePrincipal(Type typePrincipal) {
        this.typePrincipal = typePrincipal;
    }

    public Type getTypeSecondaire() {
        return typeSecondaire;
    }

    public void setTypeSecondaire(Type typeSecondaire) {
        this.typeSecondaire = typeSecondaire;
    }

    public Espece getEvolutionDe() {
        return evolutionDe;
    }

    public void setEvolutionDe(Espece evolutionDe) {
        this.evolutionDe = evolutionDe;
    }

    public Integer getPokedex() {
        return pokedex;
    }

    public void setPokedex(Integer pokedex) {
        this.pokedex = pokedex;
    }
}
