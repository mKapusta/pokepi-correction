package fr.foreach.pokego.service.impl;

import fr.foreach.pokego.dto.TypeDto;
import fr.foreach.pokego.entity.Type;
import fr.foreach.pokego.exception.TypeNotFoundException;
import fr.foreach.pokego.respository.TypeJpaRepository;
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
class TypeServiceImplTest {

    @Mock
    private TypeJpaRepository typeJpaRepository;

    @InjectMocks
    private TypeServiceImpl typeServiceImpl;

    @Test
    void getAllTypes_returnsListTypeDto() {
        Type type = new Type();
        type.setId(1);
        when(typeJpaRepository.findAll()).thenReturn(List.of(type));
        List<TypeDto> types = typeServiceImpl.getAllTypes();
        assertThat(types).hasSize(1);
        assertThat(types.get(0).getId()).isEqualTo(1);

        verify(typeJpaRepository).findAll();
    }

    @Test
    void getTypeById_returnsTypeDto() {
        Type type = new Type();
        type.setId(1);
        when(typeJpaRepository.findById(1)).thenReturn(Optional.of(type));
        assertThat(typeServiceImpl.getTypeById(1).getId()).isEqualTo(1);
        verify(typeJpaRepository).findById(1);
    }

    @Test
    void getTypeById_throwsException_WhenTypeDoesNotExist() {
        Type type = new Type();
        type.setId(1);
        when(typeJpaRepository.findById(1)).thenReturn(Optional.empty());
        assertThrows(TypeNotFoundException.class, () -> typeServiceImpl.getTypeById(1));
        verify(typeJpaRepository).findById(1);
    }

    @Test
    void createType_returnsTypeDto() {
        Type type = new Type();
        type.setId(1);
        when(typeJpaRepository.save(any(Type.class))).thenReturn(type);
        assertThat(typeServiceImpl.createType(new TypeDto()).getId()).isEqualTo(1);
        verify(typeJpaRepository).save(any(Type.class));
    }

    @Test
    void editType_returnsTypeDto() {
        Type type = new Type();
        type.setId(1);
        when(typeJpaRepository.save(any(Type.class))).thenReturn(type);
        assertThat(typeServiceImpl.editType(new TypeDto()).getId()).isEqualTo(1);
        verify(typeJpaRepository).save(any(Type.class));
    }
}
