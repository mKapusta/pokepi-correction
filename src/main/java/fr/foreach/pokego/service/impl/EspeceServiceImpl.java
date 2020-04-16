package fr.foreach.pokego.service.impl;

import fr.foreach.pokego.dto.EspeceDto;
import fr.foreach.pokego.dto.EspeceSearchCriteria;
import fr.foreach.pokego.entity.Espece;
import fr.foreach.pokego.exception.EspeceNotFoundException;
import fr.foreach.pokego.exception.WrongEspeceException;
import fr.foreach.pokego.respository.EspeceJpaRepository;
import fr.foreach.pokego.respository.PokeApiRepository;
import fr.foreach.pokego.service.EspeceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EspeceServiceImpl implements EspeceService {

    private EspeceJpaRepository especeJpaRepository;
    private PokeApiRepository pokeApiRepository;

    public EspeceServiceImpl(EspeceJpaRepository especeJpaRepository, PokeApiRepository pokeApiRepository) {
        this.especeJpaRepository = especeJpaRepository;
        this.pokeApiRepository = pokeApiRepository;
    }

    @Override
    public List<EspeceDto> getAllEspeces(EspeceSearchCriteria searchEspeceCriteria) {
        if (searchEspeceCriteria.getNom() != null) {
            return especeJpaRepository.findByNom(searchEspeceCriteria.getNom()).stream()
                    .map(EspeceDto::new)
                    .collect(Collectors.toList());
        }
        if (searchEspeceCriteria.getTypePrincipalId() != null) {
            return especeJpaRepository.findByTypePrincipal_Id(searchEspeceCriteria.getTypePrincipalId()).stream()
                    .map(EspeceDto::new)
                    .collect(Collectors.toList());
        }
        return StreamSupport.stream(especeJpaRepository.findAll().spliterator(), false)
                .map(EspeceDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public EspeceDto getEspeceById(Integer id) {
        EspeceDto especeDto = new EspeceDto(especeJpaRepository.findById(id).orElseThrow(EspeceNotFoundException::new));
        especeDto.setSprite(pokeApiRepository.getEspeceSprite(especeDto.getPokedex()));
        return especeDto;
    }

    @Override
    public EspeceDto createEspece(EspeceDto especeDto) {
        if (especeDto.getTypePrincipal() == null || especeDto.getTypePrincipal().getId() == null) {
            throw new WrongEspeceException();
        }
        if (typePrincipalAndTypeSecondaireEqual(especeDto)) {
            throw new WrongEspeceException();
        }
        Espece espece = especeJpaRepository.save(especeDto.toEspece());
        return new EspeceDto(especeJpaRepository.findById(espece.getId()).get());
    }

    private boolean typePrincipalAndTypeSecondaireEqual(EspeceDto especeDto) {
        return especeDto.getTypeSecondaire() != null && especeDto.getTypePrincipal().getId().equals(especeDto.getTypeSecondaire().getId());
    }

    @Override
    public EspeceDto editEspece(EspeceDto especeDto) {
        return new EspeceDto(especeJpaRepository.save(especeDto.toEspece()));
    }

    @Override
    public void deleteEspece(Integer id) {
        especeJpaRepository.deleteById(id);
    }

}
