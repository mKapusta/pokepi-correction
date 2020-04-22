package fr.foreach.pokego.controller;

import fr.foreach.pokego.dto.DresseurDto;
import fr.foreach.pokego.service.DresseurService;
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
class DresseurControllerTest {

    @Mock
    private DresseurService dresseurService;
    @InjectMocks
    private DresseurController dresseurController;

    @Test
    void getAlldresseurs_returnsListDresseurDto() {
        DresseurDto dresseurDto = new DresseurDto();
        when(dresseurService.getAllDresseurs()).thenReturn(List.of(dresseurDto));
        assertThat(dresseurController.getAllDresseurs()).isEqualTo(List.of(dresseurDto));
        verify(dresseurService).getAllDresseurs();
    }

    @Test
    void getById_returnsDresseurDto() {
        DresseurDto dresseurDto = new DresseurDto();
        when(dresseurService.getDresseurById(1)).thenReturn(dresseurDto);
        assertThat(dresseurController.getById(1)).isEqualTo(dresseurDto);
        verify(dresseurService).getDresseurById(1);
    }

    @Test
    void createDresseur_returnsDresseurDto() {
        DresseurDto dresseurDto = new DresseurDto();
        when(dresseurService.createDresseur(dresseurDto)).thenReturn(dresseurDto);
        assertThat(dresseurController.createDresseur(dresseurDto)).isEqualTo(dresseurDto);
        verify(dresseurService).createDresseur(dresseurDto);
    }

    @Test
    void editDresseur_returnsDresseurDto() {
        DresseurDto dresseurDto = new DresseurDto();
        when(dresseurService.editDresseur(dresseurDto)).thenReturn(dresseurDto);
        assertThat(dresseurController.editDresseur(1, dresseurDto)).isEqualTo(dresseurDto);
        verify(dresseurService).editDresseur(dresseurDto);
    }


    @Test
    void deleteDresseur_returnsNothing() {
        dresseurController.deleteDresseur(1);
        verify(dresseurService).deleteDresseur(1);
    }
}
