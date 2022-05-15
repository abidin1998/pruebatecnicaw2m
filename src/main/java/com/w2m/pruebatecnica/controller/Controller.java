package com.w2m.pruebatecnica.controller;

import com.w2m.pruebatecnica.entity.Hero;
import com.w2m.pruebatecnica.exception.HeroNotFoundException;
import com.w2m.pruebatecnica.service.HerosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.io.FileNotFoundException;
import java.util.List;

@RestController
public class Controller {

    private HerosService herosService;

    public Controller(HerosService herosService) {
        this.herosService = herosService;
    }

    @GetMapping("heroes/all")
    public ResponseEntity<List<Hero>> getAllSuperHeroes() {
        return ResponseEntity.ok(herosService.getAllSuperHeroes());
    }

    @GetMapping("heroes/byid/{id}")
    public ResponseEntity<Hero> getSuperHeroById(@PathVariable long id) {
        return ResponseEntity.ok(herosService.getSuperHeroById(id));
    }

    @GetMapping("heroes/man")
    public ResponseEntity<List<Hero>> getHeroesWithMan() {
        return ResponseEntity.ok(herosService.getHeroesWithMan());
    }

    @PatchMapping("heroes/modify")
    public void modifyHero(@RequestBody @Valid Hero hero) throws HeroNotFoundException {
        herosService.modifyHero(hero.getId(),hero.getName());
    }

    @DeleteMapping("heroes/delete/{id}")
    public void deleteHero(@PathVariable Long id) {
        herosService.deleteHero(id);
    }
}
