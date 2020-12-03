package fr.foreach.pokego.service.impl;

import fr.foreach.pokego.dto.AttaqueDto;
import fr.foreach.pokego.exception.AttaqueNotFoundException;
import fr.foreach.pokego.respository.AttaqueJpaRepository;
import fr.foreach.pokego.service.AttaqueService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AttaqueServiceImpl implements AttaqueService {

    private AttaqueJpaRepository attaqueJpaRepository;

    public AttaqueServiceImpl(AttaqueJpaRepository attaqueJpaRepository) {
        this.attaqueJpaRepository = attaqueJpaRepository;
    }

    @Override
    public List<AttaqueDto> getAllAttaques(String type) {
        return StreamSupport.stream(attaqueJpaRepository.findAll().spliterator(), false)
                .filter(attaque -> {
                    if (type != null) {
                        return attaque.getType().getNom().equals(type);
                    }
                    return true;
                })
                .map(AttaqueDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public AttaqueDto getAttaqueById(Integer id) {
        return new AttaqueDto(attaqueJpaRepository.findById(id).orElseThrow(AttaqueNotFoundException::new));
    }

    @Override
    public AttaqueDto createAttaque(AttaqueDto attaqueDto) {
        return new AttaqueDto(attaqueJpaRepository.save(attaqueDto.toAttaque()));
    }

    @Override
    public AttaqueDto editAttaque(AttaqueDto attaqueDto) {
        return new AttaqueDto(attaqueJpaRepository.save(attaqueDto.toAttaque()));
    }

    @Override
    public void deleteAttaque(Integer id) {
        attaqueJpaRepository.deleteById(id);
    }

}
