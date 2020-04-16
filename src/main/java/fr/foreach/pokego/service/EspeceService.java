package fr.foreach.pokego.service;

import fr.foreach.pokego.dto.EspeceDto;

import java.util.List;

public interface EspeceService {

    List<EspeceDto> getAllEspeces();

    EspeceDto getEspeceById(Integer id);

    EspeceDto createEspece(EspeceDto EspeceDto);

    EspeceDto editEspece(EspeceDto EspeceDto);

    void deleteEspece(Integer id);
}
