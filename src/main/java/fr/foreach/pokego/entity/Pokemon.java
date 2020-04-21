package fr.foreach.pokego.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String surnom;
    @Column
    private Integer niveau;
    @ManyToOne
    @JoinColumn(name = "ID_DRESSEUR")
    private Dresseur dresseur;
    @ManyToOne
    @JoinColumn(name = "ID_ESPECE")
    private Espece espece;
    @ManyToMany
    @JoinTable(name = "PEUT_LANCER",
            joinColumns = {@JoinColumn(name = "ID_POKEMON")},
            inverseJoinColumns = {@JoinColumn(name = "ID_ATTAQUE")})
    private List<Attaque> attaques;

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

    public Dresseur getDresseur() {
        return dresseur;
    }

    public void setDresseur(Dresseur dresseur) {
        this.dresseur = dresseur;
    }

    public Espece getEspece() {
        return espece;
    }

    public void setEspece(Espece espece) {
        this.espece = espece;
    }

    public List<Attaque> getAttaques() {
        return attaques;
    }

    public void setAttaques(List<Attaque> attaques) {
        this.attaques = attaques;
    }
}
