package com.w2m.pruebatecnica.service;

import com.w2m.pruebatecnica.entity.Hero;
import com.w2m.pruebatecnica.exception.HeroNotFoundException;
import com.w2m.pruebatecnica.repository.HeroesRespository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HerosServiceImpl implements HerosService {

    private com.w2m.pruebatecnica.repository.HeroesRespository heroesRespository;

    public HerosServiceImpl(HeroesRespository heroesRespository) {
        this.heroesRespository = heroesRespository;
    }

    @Override
    public List<Hero> getAllSuperHeroes() {
        return (List<Hero>) heroesRespository.findAll();
    }

    @Override
    public Hero getSuperHeroById(Long id) {
        Optional<Hero> hero = heroesRespository.findById(id);
        if(hero.isPresent()){
            return hero.get();
        } else {
            throw new HeroNotFoundException("No se encontro el heroe con id: " +id);
        }
    }

    @Override
    public List<Hero> getHeroesWithMan() {
        List<Hero> heroesList = (List<Hero>) heroesRespository.findAll();
        List<Hero> filteredHeroesList = heroesList.stream().filter(f->f.getName().contains("man")).collect(Collectors.toList());
        return filteredHeroesList;
    }

    @Override
    public void modifyHero(Long id,String name) throws HeroNotFoundException {
        Optional<Hero> hero = heroesRespository.findById(id);
        if(hero.isPresent()){
            hero.get().setName(name);
            heroesRespository.save(hero.get());
        } else {
            throw new HeroNotFoundException("No se encontro el heroe con id: "+id);
        }
    }

    @Override
    public void deleteHero(Long id) throws HeroNotFoundException {
        Optional<Hero> hero = heroesRespository.findById(id);
        if(hero.isPresent()){
            heroesRespository.delete(hero.get());
        } else {
            throw new HeroNotFoundException("No se encontro el heroe con id: " +id);
        }
    }

}
