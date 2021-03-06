package fr.foreach.pokego.controller;

import fr.foreach.pokego.dto.TypeDto;
import fr.foreach.pokego.service.TypeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/typesjdbc")
public class TypeJdbcController {

    private TypeService typeService;

    public TypeJdbcController(@Qualifier(value = "TypeJdbcService") TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping
    public List<TypeDto> getAllTypes() {
        return typeService.getAllTypes();
    }

    @GetMapping("/{id}")
    public TypeDto getById(@PathVariable Integer id) {
        return typeService.getTypeById(id);
    }

    @PostMapping
    public TypeDto createType(@RequestBody TypeDto typeDto) {
        return typeService.createType(typeDto);
    }

    @PutMapping("/{id}")
    public TypeDto editType(@RequestBody TypeDto typeDto) {
        return typeService.editType(typeDto);
    }
}
