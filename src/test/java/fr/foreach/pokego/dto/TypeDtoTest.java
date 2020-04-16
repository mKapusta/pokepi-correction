package fr.foreach.pokego.dto;

import fr.foreach.pokego.entity.Type;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TypeDtoTest {

    @Test
    public void constructorFromType() {
        Type type = new Type();
        type.setId(1);
        type.setNom("nom");

        TypeDto dto = new TypeDto(type);
        assertThat(dto.getNom()).isEqualTo("nom");
        assertThat(dto.getId()).isEqualTo(1);
    }

    @Test
    public void toType_ReturnsType() {
        TypeDto typeDto = new TypeDto();
        typeDto.setId(1);
        typeDto.setNom("nom");

        Type type = typeDto.toType();
        assertThat(type.getNom()).isEqualTo("nom");
        assertThat(type.getId()).isEqualTo(1);
    }

}
