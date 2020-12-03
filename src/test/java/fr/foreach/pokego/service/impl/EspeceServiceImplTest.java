package fr.foreach.pokego.service.impl;

import fr.foreach.pokego.dto.EspeceDto;
import fr.foreach.pokego.dto.EspeceSearchCriteria;
import fr.foreach.pokego.dto.TypeDto;
import fr.foreach.pokego.entity.Espece;
import fr.foreach.pokego.exception.ElementAlreadyExistsException;
import fr.foreach.pokego.exception.EspeceNotFoundException;
import fr.foreach.pokego.exception.WrongEspeceException;
import fr.foreach.pokego.respository.EspeceJpaRepository;
import fr.foreach.pokego.respository.PokeApiRepository;
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
class EspeceServiceImplTest {

    @Mock
    private EspeceJpaRepository especeJpaRepository;
    @Mock
    private PokeApiRepository pokeApiRepository;

    @InjectMocks
    private EspeceServiceImpl especeServiceImpl;

    @Test
    void getAllEspeces_returnsListEspeceDto() {
        Espece espece = new Espece();
        espece.setId(1);
        when(especeJpaRepository.findAll()).thenReturn(List.of(espece));
        List<EspeceDto> especeDtos = especeServiceImpl.getAllEspeces(new EspeceSearchCriteria());
        assertThat(especeDtos).hasSize(1);
        assertThat(especeDtos.get(0).getId()).isEqualTo(1);

        verify(especeJpaRepository).findAll();
    }

    @Test
    void getAllEspeces_returnsListEspeceDto_WhenSearchByName() {
        Espece espece = new Espece();
        espece.setId(1);
        EspeceSearchCriteria especeSearchCriteria = new EspeceSearchCriteria();
        especeSearchCriteria.setNom("nom");
        when(especeJpaRepository.findByNom("nom")).thenReturn(List.of(espece));
        List<EspeceDto> especeDtos = especeServiceImpl.getAllEspeces(especeSearchCriteria);
        assertThat(especeDtos).hasSize(1);
        assertThat(especeDtos.get(0).getId()).isEqualTo(1);

        verify(especeJpaRepository).findByNom("nom");
    }

    @Test
    void getAllEspeces_returnsListEspeceDto_WhenSearchByType() {
        Espece espece = new Espece();
        espece.setId(1);
        EspeceSearchCriteria especeSearchCriteria = new EspeceSearchCriteria();
        especeSearchCriteria.setTypePrincipalId(1);
        when(especeJpaRepository.findByTypePrincipal_Id(1)).thenReturn(List.of(espece));
        List<EspeceDto> especeDtos = especeServiceImpl.getAllEspeces(especeSearchCriteria);
        assertThat(especeDtos).hasSize(1);
        assertThat(especeDtos.get(0).getId()).isEqualTo(1);

        verify(especeJpaRepository).findByTypePrincipal_Id(1);
    }

    @Test
    void getAllEspeces_returnsListEspeceDto_WhenSearchByTypeSecondaire() {
        Espece espece = new Espece();
        espece.setId(1);
        EspeceSearchCriteria especeSearchCriteria = new EspeceSearchCriteria();
        especeSearchCriteria.setTypeSecondaireId(1);
        when(especeJpaRepository.findByTypeSecondaire_Id(1)).thenReturn(List.of(espece));
        List<EspeceDto> especeDtos = especeServiceImpl.getAllEspeces(especeSearchCriteria);
        assertThat(especeDtos).hasSize(1);
        assertThat(especeDtos.get(0).getId()).isEqualTo(1);

        verify(especeJpaRepository).findByTypeSecondaire_Id(1);
    }


    @Test
    void getEspeceById_returnsEspeceDtoWithSprite() {
        Espece espece = new Espece();
        espece.setId(1);
        espece.setPokedex(2);
        when(especeJpaRepository.findById(1)).thenReturn(Optional.of(espece));
        when(pokeApiRepository.getEspeceSprite(2)).thenReturn("url");
        EspeceDto especeDto = especeServiceImpl.getEspeceById(1);
        assertThat(especeDto.getId()).isEqualTo(1);
        assertThat(especeDto.getSprite()).isEqualTo("url");
        verify(especeJpaRepository).findById(1);
        verify(pokeApiRepository).getEspeceSprite(2);
    }

    @Test
    void getEspeceById_throwsException_WhenEspceDoesNotExist() {
        when(especeJpaRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(EspeceNotFoundException.class, () -> especeServiceImpl.getEspeceById(1));
        verify(especeJpaRepository).findById(1);
    }

    @Test
    void createEspece_returnsEspeceDto() {
        Espece espece = new Espece();
        espece.setId(1);
        when(especeJpaRepository.save(any(Espece.class))).thenReturn(espece);
        when(especeJpaRepository.countByNom(anyString())).thenReturn(0);
        when(especeJpaRepository.findById(1)).thenReturn(Optional.of(espece));
        assertThat(especeServiceImpl.createEspece(createEspeceDtoWithGoodTypes()).getId()).isEqualTo(1);
        verify(especeJpaRepository).save(any(Espece.class));
    }

    @Test
    void createEspece_ThrowsElementAlreadyExistsException_whenEspeceExists() {
        Espece espece = new Espece();
        espece.setId(1);
        when(especeJpaRepository.countByNom(anyString())).thenReturn(1);
        assertThrows(ElementAlreadyExistsException.class, () -> especeServiceImpl.createEspece(createEspeceDtoWithGoodTypes()));
        verify(especeJpaRepository).countByNom("PIKACHU");
        verifyNoMoreInteractions(especeJpaRepository);
    }


    @Test
    void createEspece_throwWrongEspeceException_WhenNoTypePrincipal() {
        Espece espece = new Espece();
        espece.setId(1);
        assertThrows(WrongEspeceException.class, () -> especeServiceImpl.createEspece(new EspeceDto()));
        verifyNoInteractions(especeJpaRepository);
    }

    @Test
    void createEspece_throwWrongEspeceException_WhenSameTypes() {
        Espece espece = new Espece();
        espece.setId(1);
        EspeceDto especeDto = createEspeceDtoWithGoodTypes();
        especeDto.setTypeSecondaire(especeDto.getTypePrincipal());
        assertThrows(WrongEspeceException.class, () -> especeServiceImpl.createEspece(especeDto));
        verifyNoInteractions(especeJpaRepository);
    }

    @Test
    void editEspece_returnsEspeceDto() {
        Espece espece = new Espece();
        espece.setId(1);
        when(especeJpaRepository.save(any(Espece.class))).thenReturn(espece);
        assertThat(especeServiceImpl.editEspece(new EspeceDto()).getId()).isEqualTo(1);
        verify(especeJpaRepository).save(any(Espece.class));
    }

    @Test
    void deleteEspece() {
        especeServiceImpl.deleteEspece(1);
        verify(especeJpaRepository).deleteById(1);
    }

    private EspeceDto createEspeceDtoWithGoodTypes() {
        TypeDto typePrincipal = new TypeDto();
        typePrincipal.setId(1);
        TypeDto typeSecondaire = new TypeDto();
        typeSecondaire.setId(2);
        EspeceDto especeDto = new EspeceDto();
        especeDto.setNom("PIKACHU");
        especeDto.setTypePrincipal(typePrincipal);
        especeDto.setTypeSecondaire(typeSecondaire);
        return especeDto;
    }
}
