package fr.foreach.pokego.service.impl;

import fr.foreach.pokego.dto.TypeDto;
import fr.foreach.pokego.entity.Type;
import fr.foreach.pokego.exception.TypeNotFoundException;
import fr.foreach.pokego.respository.TypeJdbcRepository;
import fr.foreach.pokego.service.TypeService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("TypeJdbcService")
public class TypeJdbcServiceImpl implements TypeService {

    private TypeJdbcRepository typeJdbcRepository;

    public TypeJdbcServiceImpl(TypeJdbcRepository typeJdbcRepository) {
        this.typeJdbcRepository = typeJdbcRepository;
    }

    @Override
    public List<TypeDto> getAllTypes() {
        return typeJdbcRepository.getAll()
                .stream()
                .map(TypeDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public TypeDto getTypeById(Integer id) {
        try {
            Type type = typeJdbcRepository.getById(id);
            return new TypeDto(type);
        } catch (EmptyResultDataAccessException e) {
            throw new TypeNotFoundException();
        }
    }

    @Override
    public TypeDto createType(TypeDto typeDto) {

        Integer id = typeJdbcRepository.createType(typeDto.toType());
        typeDto.setId(id);
        return typeDto;
    }

    @Override
    public TypeDto editType(TypeDto typeDto) {
        typeJdbcRepository.editType(typeDto.toType());
        return typeDto;
    }

}
