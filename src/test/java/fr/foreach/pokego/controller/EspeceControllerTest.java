package fr.foreach.pokego.controller;

import fr.foreach.pokego.dto.EspeceDto;
import fr.foreach.pokego.service.EspeceService;
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
class EspeceControllerTest {

    @Mock
    private EspeceService especeService;
    @InjectMocks
    private EspeceController especeController;

    @Test
    void getAllEspeces_returnsListEspeceDto() {
        EspeceDto EspeceDto = new EspeceDto();
        when(especeService.getAllEspeces()).thenReturn(List.of(EspeceDto));
        assertThat(especeController.getAllEspeces()).isEqualTo(List.of(EspeceDto));
        verify(especeService).getAllEspeces();
    }

    @Test
    void getById_returnsEspeceDto() {
        EspeceDto EspeceDto = new EspeceDto();
        when(especeService.getEspeceById(1)).thenReturn(EspeceDto);
        assertThat(especeController.getById(1)).isEqualTo(EspeceDto);
        verify(especeService).getEspeceById(1);
    }

    @Test
    void createEspece_returnsEspeceDto() {
        EspeceDto EspeceDto = new EspeceDto();
        when(especeService.createEspece(EspeceDto)).thenReturn(EspeceDto);
        assertThat(especeController.createEspece(EspeceDto)).isEqualTo(EspeceDto);
        verify(especeService).createEspece(EspeceDto);
    }

    @Test
    void editEspece_returnsEspeceDto() {
        EspeceDto EspeceDto = new EspeceDto();
        when(especeService.editEspece(EspeceDto)).thenReturn(EspeceDto);
        assertThat(especeController.editEspece(EspeceDto)).isEqualTo(EspeceDto);
        verify(especeService).editEspece(EspeceDto);
    }

    @Test
    void deleteEspece_returnsNothing() {
        especeController.deleteEspece(1);
        verify(especeService).deleteEspece(1);
    }
}
