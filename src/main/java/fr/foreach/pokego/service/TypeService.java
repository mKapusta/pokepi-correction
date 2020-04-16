package fr.foreach.pokego.service;

import fr.foreach.pokego.dto.TypeDto;

import java.util.List;

public interface TypeService {

    List<TypeDto> getAllTypes();
    TypeDto getTypeById(Integer id);
    TypeDto createType(TypeDto typeDto);
    TypeDto editType(TypeDto typeDto);
}
