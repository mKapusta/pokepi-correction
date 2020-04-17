package fr.foreach.pokego.service;

import fr.foreach.pokego.dto.EspeceDto;
import fr.foreach.pokego.dto.EspeceSearchCriteria;

import java.util.List;

public interface EspeceService {

    List<EspeceDto> getAllEspeces(EspeceSearchCriteria searchEspeceCriteria);

    EspeceDto getEspeceById(Integer id);

    EspeceDto getEspeceJdbcById(Integer id);

    EspeceDto createEspece(EspeceDto EspeceDto);

    EspeceDto editEspece(EspeceDto EspeceDto);

    void deleteEspece(Integer id);
}
