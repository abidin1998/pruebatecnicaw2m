package com.w2m.pruebatecnica.service;

import com.w2m.pruebatecnica.entity.Hero;
import com.w2m.pruebatecnica.exception.HeroNotFoundException;

import java.io.FileNotFoundException;
import java.util.List;

public interface HerosService {

    List<Hero> getAllSuperHeroes();

    Hero getSuperHeroById(Long id);

    public List<Hero> getHeroesWithMan();

    public void modifyHero(Long id,String name) throws HeroNotFoundException;

    void deleteHero(Long id) throws HeroNotFoundException;
}
