package fr.foreach.pokego.service.impl;

import fr.foreach.pokego.dto.AttaqueDto;
import fr.foreach.pokego.entity.Attaque;
import fr.foreach.pokego.exception.AttaqueNotFoundException;
import fr.foreach.pokego.exception.ElementAlreadyExistsException;
import fr.foreach.pokego.respository.AttaqueJpaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AttaqueServiceImplTest {

    @Mock
    private AttaqueJpaRepository attaqueJpaRepository;

    @InjectMocks
    private AttaqueServiceImpl attaqueServiceImpl;

    @Test
    void getAllAttaques_returnsListAttaqueDto() {
        Attaque attaque = new Attaque();
        attaque.setId(1);
        when(attaqueJpaRepository.findAll()).thenReturn(List.of(attaque));
        List<AttaqueDto> attaques = attaqueServiceImpl.getAllAttaques(null);
        assertThat(attaques).hasSize(1);
        assertThat(attaques.get(0).getId()).isEqualTo(1);

        verify(attaqueJpaRepository).findAll();
        verifyNoMoreInteractions(attaqueJpaRepository);
    }

    @Test
    void getAllAttaques_returnsListAttaqueDto_WhenSearchByType() {
        Attaque attaque = new Attaque();
        attaque.setId(1);
        when(attaqueJpaRepository.findByType_Nom("VOL")).thenReturn(List.of(attaque));
        List<AttaqueDto> attaques = attaqueServiceImpl.getAllAttaques("VOL");
        assertThat(attaques).hasSize(1);
        assertThat(attaques.get(0).getId()).isEqualTo(1);

        verify(attaqueJpaRepository).findByType_Nom("VOL");
        verifyNoMoreInteractions(attaqueJpaRepository);
    }

    @Test
    void getAttaqueById_returnsAttaqueDto() {
        Attaque attaque = new Attaque();
        attaque.setId(1);
        when(attaqueJpaRepository.findById(1)).thenReturn(Optional.of(attaque));
        assertThat(attaqueServiceImpl.getAttaqueById(1).getId()).isEqualTo(1);
        verify(attaqueJpaRepository).findById(1);
    }

    @Test
    void updateAttaquePuissance_ReturnsAttaqueDto(){
        AttaqueDto attaqueDto = new AttaqueDto();
        attaqueDto.setPuissance(3);
        when(attaqueJpaRepository.updateAttaquePuissance(3,1)).thenReturn(1);
        AttaqueDto attaqueUpdated= attaqueServiceImpl.updateAttaquePuissance(1, attaqueDto);
        assertThat(attaqueUpdated.getId()).isEqualTo(1);
        verify(attaqueJpaRepository).updateAttaquePuissance(3,1);
    }

    @Test
    void getAttaqueById_throwsException_WhenAttaqueDoesNotExist() {
        Attaque attaque = new Attaque();
        attaque.setId(1);
        when(attaqueJpaRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(AttaqueNotFoundException.class, () -> attaqueServiceImpl.getAttaqueById(1));
        verify(attaqueJpaRepository).findById(1);
    }

    @Test
    void createAttaque_returnsAttaqueDto() {
        Attaque attaque = new Attaque();
        attaque.setId(1);
        when(attaqueJpaRepository.countByNom("nom")).thenReturn(0);
        when(attaqueJpaRepository.save(any(Attaque.class))).thenReturn(attaque);
        AttaqueDto attaqueDto = new AttaqueDto();
        attaqueDto.setNom("nom");
        assertThat(attaqueServiceImpl.createAttaque(attaqueDto).getId()).isEqualTo(1);
        verify(attaqueJpaRepository).save(any(Attaque.class));
        verify(attaqueJpaRepository).countByNom("nom");
    }

    @Test
    void createAttaque_throwsExceptionWhenAlreadyExists() {
        when(attaqueJpaRepository.countByNom("nom")).thenReturn(1);
        AttaqueDto attaqueDto = new AttaqueDto();
        attaqueDto.setNom("nom");
        assertThrows(ElementAlreadyExistsException.class, () -> attaqueServiceImpl.createAttaque(attaqueDto));
        verify(attaqueJpaRepository,times(0)).save(any(Attaque.class));
        verify(attaqueJpaRepository).countByNom("nom");
    }

    @Test
    void editAttaque_returnsAttaqueDto() {
        Attaque attaque = new Attaque();
        attaque.setId(1);
        when(attaqueJpaRepository.save(any(Attaque.class))).thenReturn(attaque);
        assertThat(attaqueServiceImpl.editAttaque(new AttaqueDto()).getId()).isEqualTo(1);
        verify(attaqueJpaRepository).save(any(Attaque.class));
    }

    @Test
    void deleteAttaque_returnsNothing() {
        attaqueServiceImpl.deleteAttaque(1);
        verify(attaqueJpaRepository).deleteById(1);
    }
}
