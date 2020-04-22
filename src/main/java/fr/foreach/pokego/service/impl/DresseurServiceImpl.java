package fr.foreach.pokego.service.impl;

import fr.foreach.pokego.dto.DresseurDto;
import fr.foreach.pokego.exception.DresseurNotFoundException;
import fr.foreach.pokego.respository.DresseurJpaRepository;
import fr.foreach.pokego.service.DresseurService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DresseurServiceImpl implements DresseurService {

    private DresseurJpaRepository dresseurJpaRepository;

    public DresseurServiceImpl(DresseurJpaRepository dresseurJpaRepository) {
        this.dresseurJpaRepository = dresseurJpaRepository;
    }

    @Override
    public List<DresseurDto> getAllDresseurs() {
        return StreamSupport.stream(dresseurJpaRepository.findAll().spliterator(), false)
                .map(DresseurDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public DresseurDto getDresseurById(Integer id) {
        return new DresseurDto(dresseurJpaRepository.findById(id).orElseThrow(DresseurNotFoundException::new));
    }

    @Override
    public DresseurDto createDresseur(DresseurDto dresseurDto) {
        return new DresseurDto(dresseurJpaRepository.save(dresseurDto.toDresseur()));
    }

    @Override
    public DresseurDto editDresseur(DresseurDto dresseurDto) {
        return new DresseurDto(dresseurJpaRepository.save(dresseurDto.toDresseur()));
    }

    @Override
    public void deleteDresseur(Integer id) {
        dresseurJpaRepository.deleteById(id);
    }

}
