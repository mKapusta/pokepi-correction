package fr.foreach.pokego.controller;

import fr.foreach.pokego.dto.TypeDto;
import fr.foreach.pokego.service.TypeService;
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
class TypeControllerTest {

    @Mock
    private TypeService typeService;
    @InjectMocks
    private TypeController typeController;

    @Test
    void getAlltypes_returnsListTypeDto() {
        TypeDto typeDto = new TypeDto();
        when(typeService.getAllTypes()).thenReturn(List.of(typeDto));
        assertThat(typeController.getAllTypes()).isEqualTo(List.of(typeDto));
        verify(typeService).getAllTypes();
    }

    @Test
    void getById_returnsTypeDto() {
        TypeDto typeDto = new TypeDto();
        when(typeService.getTypeById(1)).thenReturn(typeDto);
        assertThat(typeController.getById(1)).isEqualTo(typeDto);
        verify(typeService).getTypeById(1);
    }

    @Test
    void createType_returnsTypeDto() {
        TypeDto typeDto = new TypeDto();
        when(typeService.createType(typeDto)).thenReturn(typeDto);
        assertThat(typeController.createType(typeDto)).isEqualTo(typeDto);
        verify(typeService).createType(typeDto);
    }

    @Test
    void editType_returnsTypeDto() {
        TypeDto typeDto = new TypeDto();
        when(typeService.editType(typeDto)).thenReturn(typeDto);
        assertThat(typeController.editType(typeDto)).isEqualTo(typeDto);
        verify(typeService).editType(typeDto);
    }
}
