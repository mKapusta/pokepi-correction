package fr.foreach.pokego.service;

import fr.foreach.pokego.dto.DresseurDto;

import java.util.List;

public interface DresseurService {
    List<DresseurDto> getAllDresseurs();

    DresseurDto getDresseurById(Integer id);

    DresseurDto createDresseur(DresseurDto dresseurDto);

    DresseurDto editDresseur(DresseurDto dresseurDto);

    void deleteDresseur(Integer id);
}
