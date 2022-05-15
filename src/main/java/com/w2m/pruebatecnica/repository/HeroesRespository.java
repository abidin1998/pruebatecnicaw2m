package com.w2m.pruebatecnica.repository;

import com.w2m.pruebatecnica.entity.Hero;
import org.springframework.data.repository.CrudRepository;

public interface HeroesRespository extends CrudRepository<Hero, Long> {
}
