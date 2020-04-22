package fr.foreach.pokego.controller;

import fr.foreach.pokego.dto.AttaqueDto;
import fr.foreach.pokego.service.AttaqueService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attaques")
public class AttaqueController {

    private AttaqueService attaqueService;

    public AttaqueController(AttaqueService attaqueService) {
        this.attaqueService = attaqueService;
    }

    @GetMapping
    public List<AttaqueDto> getAllAttaques() {
        return attaqueService.getAllAttaques();
    }

    @GetMapping("/{id}")
    public AttaqueDto getById(@PathVariable Integer id) {
        return attaqueService.getAttaqueById(id);
    }

    @PostMapping
    public AttaqueDto createAttaque(@RequestBody AttaqueDto attaqueDto) {
        return attaqueService.createAttaque(attaqueDto);
    }

    @PutMapping("/{id}")
    public AttaqueDto editAttaque(@PathVariable Integer id, @RequestBody AttaqueDto attaqueDto) {
        attaqueDto.setId(id);
        return attaqueService.editAttaque(attaqueDto);
    }

    @DeleteMapping("/{id}")
    public void deleteAttaque(@PathVariable Integer id) {
        attaqueService.deleteAttaque(id);
    }
}
