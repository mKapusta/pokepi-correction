package fr.foreach.pokego.controller;

import fr.foreach.pokego.dto.EspeceDto;
import fr.foreach.pokego.dto.EspeceSearchCriteria;
import fr.foreach.pokego.service.EspeceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especes")
public class EspeceController {

    private EspeceService especeService;

    public EspeceController(EspeceService especeService) {
        this.especeService = especeService;
    }

    @GetMapping
    public List<EspeceDto> getAllEspeces(EspeceSearchCriteria searchEspeceCriteria) {
        return especeService.getAllEspeces(searchEspeceCriteria);
    }

    @GetMapping("/{id}")
    public EspeceDto getById(@PathVariable Integer id) {
        return especeService.getEspeceById(id);
    }

    @GetMapping("/jdbc/{id}")
    public EspeceDto getByIdJdbc(@PathVariable Integer id) {
        return especeService.getEspeceJdbcById(id);
    }

    @PostMapping
    public EspeceDto createEspece(@RequestBody EspeceDto especeDto) {
        return especeService.createEspece(especeDto);
    }

    @PutMapping("/{id}")
    public EspeceDto editEspece(@PathVariable Integer id, @RequestBody EspeceDto especeDto) {
        especeDto.setId(id);
        return especeService.editEspece(especeDto);
    }

    @DeleteMapping("/{id}")
    public void deleteEspece(@PathVariable Integer id) {
        especeService.deleteEspece(id);
    }
}
