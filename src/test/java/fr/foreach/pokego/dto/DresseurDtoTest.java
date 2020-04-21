package fr.foreach.pokego.dto;

import fr.foreach.pokego.entity.Dresseur;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DresseurDtoTest {

    @Test
    public void constructorFromDresseur() {
        Dresseur dresseur = new Dresseur();
        dresseur.setId(1);
        dresseur.setNom("nom");

        DresseurDto dto = new DresseurDto(dresseur);
        assertThat(dto.getNom()).isEqualTo("nom");
        assertThat(dto.getId()).isEqualTo(1);
    }

    @Test
    public void toDresseur_ReturnsDresseur() {
        DresseurDto dresseurDto = new DresseurDto();
        dresseurDto.setId(1);
        dresseurDto.setNom("nom");

        Dresseur dresseur = dresseurDto.toDresseur();
        assertThat(dresseur.getNom()).isEqualTo("nom");
        assertThat(dresseur.getId()).isEqualTo(1);
    }

}
