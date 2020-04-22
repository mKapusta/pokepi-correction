package fr.foreach.pokego.controller;

import fr.foreach.pokego.dto.DresseurDto;
import fr.foreach.pokego.service.DresseurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dresseurs")
public class DresseurController {

    private DresseurService dresseurService;

    public DresseurController(DresseurService dresseurService) {
        this.dresseurService = dresseurService;
    }

    @GetMapping
    public List<DresseurDto> getAllDresseurs() {
        return dresseurService.getAllDresseurs();
    }

    @GetMapping("/{id}")
    public DresseurDto getById(@PathVariable Integer id) {
        return dresseurService.getDresseurById(id);
    }

    @PostMapping
    public DresseurDto createDresseur( @RequestBody DresseurDto dresseurDto) {
        return dresseurService.createDresseur(dresseurDto);
    }

    @PutMapping("/{id}")
    public DresseurDto editDresseur(@PathVariable Integer id, @RequestBody DresseurDto dresseurDto) {
        dresseurDto.setId(id);
        return dresseurService.editDresseur(dresseurDto);
    }

    @DeleteMapping("/{id}")
    public void deleteDresseur(@PathVariable Integer id) {
        dresseurService.deleteDresseur(id);
    }
}
