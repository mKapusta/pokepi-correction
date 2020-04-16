package fr.foreach.pokego.dto;

import fr.foreach.pokego.entity.Espece;
import fr.foreach.pokego.entity.Type;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EspeceDtoTest {

    @Test
    public void constructurFromEspece() {
        Espece base = new Espece();
        base.setId(1);

        Espece espece = new Espece();
        espece.setId(2);
        espece.setNom("Roucoups");
        espece.setPokedex(17);
        espece.setTypePrincipal(createType(1, "normal"));
        espece.setTypeSecondaire(createType(2, "vol"));
        espece.setEvolutionDe(base);

        EspeceDto especeDto = new EspeceDto(espece);
        assertThat(especeDto.getId()).isEqualTo(2);
        assertThat(especeDto.getNom()).isEqualTo("Roucoups");
        assertThat(especeDto.getTypePrincipal().getNom()).isEqualTo("normal");
        assertThat(especeDto.getTypeSecondaire().getNom()).isEqualTo("vol");
        assertThat(especeDto.getEvolutionDe().getId()).isEqualTo(1);
        assertThat(especeDto.getPokedex()).isEqualTo(17);
    }

    @Test
    void toEspece() {
        EspeceDto base = new EspeceDto();
        base.setId(1);

        EspeceDto especeDto = new EspeceDto();
        especeDto.setId(2);
        especeDto.setNom("Roucoups");
        especeDto.setTypePrincipal(createTypeDto(1, "normal"));
        especeDto.setTypeSecondaire(createTypeDto(2, "vol"));
        especeDto.setEvolutionDe(base);
        especeDto.setPokedex(17);

        Espece espece = especeDto.toEspece();
        assertThat(espece.getId()).isEqualTo(2);
        assertThat(espece.getNom()).isEqualTo("Roucoups");
        assertThat(espece.getTypePrincipal().getNom()).isEqualTo("normal");
        assertThat(espece.getTypeSecondaire().getNom()).isEqualTo("vol");
        assertThat(espece.getPokedex()).isEqualTo(17);
        assertThat(espece.getEvolutionDe().getId()).isEqualTo(1);
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
