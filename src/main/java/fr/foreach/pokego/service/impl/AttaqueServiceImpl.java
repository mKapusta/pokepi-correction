package fr.foreach.pokego.service.impl;

import fr.foreach.pokego.dto.AttaqueDto;
import fr.foreach.pokego.exception.AttaqueNotFoundException;
import fr.foreach.pokego.exception.ElementAlreadyExistsException;
import fr.foreach.pokego.respository.AttaqueJdbcRepository;
import fr.foreach.pokego.respository.AttaqueJpaRepository;
import fr.foreach.pokego.service.AttaqueService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AttaqueServiceImpl implements AttaqueService {

    private AttaqueJpaRepository attaqueJpaRepository;
    private AttaqueJdbcRepository attaqueJdbcRepository;

    public AttaqueServiceImpl(AttaqueJpaRepository attaqueJpaRepository, AttaqueJdbcRepository attaqueJdbcRepository) {
        this.attaqueJpaRepository = attaqueJpaRepository;
        this.attaqueJdbcRepository = attaqueJdbcRepository;
    }

    @Override
    public List<AttaqueDto> getAllAttaques(String type) {
        if (type != null) {
            return attaqueJpaRepository.findByType_Nom(type).stream()
                    .map(AttaqueDto::new)
                    .collect(Collectors.toList());
        }
        return StreamSupport.stream(attaqueJpaRepository.findAll().spliterator(), false)
                .map(AttaqueDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public AttaqueDto getAttaqueById(Integer id) {
        return new AttaqueDto(attaqueJpaRepository.findById(id).orElseThrow(AttaqueNotFoundException::new));
    }

    @Override
    public AttaqueDto createAttaque(AttaqueDto attaqueDto) {
        if (attaqueJpaRepository.countByNom(attaqueDto.getNom()) == 0) {
            return new AttaqueDto(attaqueJpaRepository.save(attaqueDto.toAttaque()));
        }
        throw new ElementAlreadyExistsException();
    }

    @Override
    public AttaqueDto editAttaque(AttaqueDto attaqueDto) {
        return new AttaqueDto(attaqueJpaRepository.save(attaqueDto.toAttaque()));
    }

    @Override
    public List<AttaqueDto> getAllAttaquesByPokemonId(Integer pokemonId) {
        return attaqueJdbcRepository.getAllAttaquesByPokemonId(pokemonId).stream()
                .map(AttaqueDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public AttaqueDto updateAttaquePuissance(Integer id, AttaqueDto attaque) {
        attaque.setId(id);
        attaqueJpaRepository.updateAttaquePuissance(attaque.getPuissance(), id);
        return attaque;
    }

    @Override
    public void deleteAttaque(Integer id) {
        attaqueJpaRepository.deleteById(id);
    }

}
