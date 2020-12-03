package fr.foreach.pokego.controller;

import fr.foreach.pokego.dto.AttaqueDto;
import fr.foreach.pokego.service.AttaqueService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AttaqueControllerTest {

    @Mock
    private AttaqueService attaqueService;
    @InjectMocks
    private AttaqueController attaqueController;

    @Test
    void getAllattaques_returnsListAttaqueDto() {
        AttaqueDto attaqueDto = new AttaqueDto();
        when(attaqueService.getAllAttaques(null)).thenReturn(List.of(attaqueDto));
        assertThat(attaqueController.getAllAttaques(null)).isEqualTo(List.of(attaqueDto));
        verify(attaqueService).getAllAttaques(null);
    }

    @Test
    void updateAttaquePuissance_returnsAttaqueDto() {
        AttaqueDto attaqueDto = new AttaqueDto();
        when(attaqueService.updateAttaquePuissance(1, attaqueDto)).thenReturn(attaqueDto);
        assertThat(attaqueController.updateAttaquePuissance(1,attaqueDto)).isEqualTo(attaqueDto);
        verify(attaqueService).updateAttaquePuissance(1, attaqueDto);
    }

    @Test
    void getById_returnsAttaqueDto() {
        AttaqueDto attaqueDto = new AttaqueDto();
        when(attaqueService.getAttaqueById(1)).thenReturn(attaqueDto);
        assertThat(attaqueController.getById(1)).isEqualTo(attaqueDto);
        verify(attaqueService).getAttaqueById(1);
    }

    @Test
    void createAttaque_returnsAttaqueDto() {
        AttaqueDto attaqueDto = new AttaqueDto();
        when(attaqueService.createAttaque(attaqueDto)).thenReturn(attaqueDto);
        assertThat(attaqueController.createAttaque(attaqueDto)).isEqualTo(attaqueDto);
        verify(attaqueService).createAttaque(attaqueDto);
    }

    @Test
    void editAttaque_returnsAttaqueDto() {
        AttaqueDto attaqueDto = new AttaqueDto();
        when(attaqueService.editAttaque(attaqueDto)).thenReturn(attaqueDto);
        assertThat(attaqueController.editAttaque(1, attaqueDto)).isEqualTo(attaqueDto);
        verify(attaqueService).editAttaque(attaqueDto);
    }


    @Test
    void deleteAttaque_returnsNothing() {
        attaqueController.deleteAttaque(1);
        verify(attaqueService).deleteAttaque(1);
    }
}
