package fr.foreach.pokego.service.impl;

import fr.foreach.pokego.dto.TypeDto;
import fr.foreach.pokego.exception.TypeNotFoundException;
import fr.foreach.pokego.respository.TypeJpaRepository;
import fr.foreach.pokego.service.TypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TypeServiceImpl implements TypeService {

    private TypeJpaRepository typeJpaRepository;

    public TypeServiceImpl(TypeJpaRepository typeJpaRepository) {
        this.typeJpaRepository = typeJpaRepository;
    }

    @Override
    public List<TypeDto> getAllTypes() {
        return StreamSupport.stream(typeJpaRepository.findAll().spliterator(), false)
                .map(TypeDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public TypeDto getTypeById(Integer id) {
        return new TypeDto(typeJpaRepository.findById(id).orElseThrow(TypeNotFoundException::new));
    }

    @Override
    public TypeDto createType(TypeDto typeDto) {
        return new TypeDto(typeJpaRepository.save(typeDto.toType()));
    }

    @Override
    public TypeDto editType(TypeDto typeDto) {
        return new TypeDto(typeJpaRepository.save(typeDto.toType()));
    }

}
