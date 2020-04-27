package fr.foreach.pokego.controller;

import fr.foreach.pokego.dto.TypeDto;
import fr.foreach.pokego.exception.TypeNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@TestPropertySource(properties = "spring.datasource.url=jdbc:h2:mem:testdb")
class TypeControllerIntegrationTest {


    @Autowired
    private TypeController typeController;
    @Autowired
    private TypeJdbcController typeJdbcController;

    @Test
    void getById_returnsTypeDto() {

        RestTemplate restTemplate = new RestTemplate();
        TypeDto typeDto = typeController.getById(1);
        assertEquals(1, typeDto.getId());


    }

    @Test
    void getById_returnsTypeDto_WhenException() {
        assertThrows(TypeNotFoundException.class,  () -> typeJdbcController.getById(14));
    }

}
