package fr.foreach.pokego.controller;

import fr.foreach.pokego.dto.EspeceDto;
import fr.foreach.pokego.dto.EspeceSearchCriteria;
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
        EspeceSearchCriteria especeSearchCriteria = new EspeceSearchCriteria();
        when(especeService.getAllEspeces(especeSearchCriteria)).thenReturn(List.of(EspeceDto));
        assertThat(especeController.getAllEspeces(especeSearchCriteria)).isEqualTo(List.of(EspeceDto));
        verify(especeService).getAllEspeces(especeSearchCriteria);
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
        EspeceDto especeDto = new EspeceDto();
        when(especeService.createEspece(especeDto)).thenReturn(especeDto);
        assertThat(especeController.createEspece(especeDto)).isEqualTo(especeDto);
        verify(especeService).createEspece(especeDto);
    }

    @Test
    void editEspece_returnsEspeceDto() {
        EspeceDto especeDto = new EspeceDto();
        when(especeService.editEspece(especeDto)).thenReturn(especeDto);
        assertThat(especeController.editEspece(1, especeDto)).isEqualTo(especeDto);
        verify(especeService).editEspece(especeDto);
    }

    @Test
    void deleteEspece_returnsNothing() {
        especeController.deleteEspece(1);
        verify(especeService).deleteEspece(1);
    }
}
