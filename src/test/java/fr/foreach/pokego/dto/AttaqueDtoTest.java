package fr.foreach.pokego.dto;

import fr.foreach.pokego.entity.Attaque;
import fr.foreach.pokego.entity.Type;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AttaqueDtoTest {

    @Test
    public void constructurFromAttaque() {

        Attaque attaque = new Attaque();
        attaque.setId(2);
        attaque.setNom("picpic");
        attaque.setPuissance(17);
        attaque.setType(createType(1, "normal"));

        AttaqueDto attaqueDto = new AttaqueDto(attaque);
        assertThat(attaqueDto.getId()).isEqualTo(2);
        assertThat(attaqueDto.getNom()).isEqualTo("picpic");
        assertThat(attaqueDto.getPuissance()).isEqualTo(17);
        assertThat(attaqueDto.getType().getNom()).isEqualTo("normal");
    }

    @Test
    void toAttaque() {

        AttaqueDto attaqueDto = new AttaqueDto();
        attaqueDto.setId(2);
        attaqueDto.setNom("picpic");
        attaqueDto.setType(createTypeDto(1, "normal"));
        attaqueDto.setPuissance(17);

        Attaque attaque = attaqueDto.toAttaque();
        assertThat(attaque.getId()).isEqualTo(2);
        assertThat(attaque.getNom()).isEqualTo("picpic");
        assertThat(attaque.getPuissance()).isEqualTo(17);
        assertThat(attaque.getType().getNom()).isEqualTo("normal");
    }


    private Type createType(Integer id, String nom) {
        Type type = new Type();
        type.setNom(nom);
        type.setId(id);
        return type;
    }

    private TypeDto createTypeDto(Integer id, String nom) {
        TypeDto typeDto = new TypeDto();
        typeDto.setNom(nom);
        typeDto.setId(id);
        return typeDto;
    }
}
