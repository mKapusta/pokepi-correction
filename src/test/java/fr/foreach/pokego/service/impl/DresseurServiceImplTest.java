package fr.foreach.pokego.service.impl;

import fr.foreach.pokego.dto.AttaqueDto;
import fr.foreach.pokego.entity.Attaque;
import fr.foreach.pokego.exception.AttaqueNotFoundException;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DresseurServiceImplTest {

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
        when(attaqueJpaRepository.save(any(Attaque.class))).thenReturn(attaque);
        assertThat(attaqueServiceImpl.createAttaque(new AttaqueDto()).getId()).isEqualTo(1);
        verify(attaqueJpaRepository).save(any(Attaque.class));
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
