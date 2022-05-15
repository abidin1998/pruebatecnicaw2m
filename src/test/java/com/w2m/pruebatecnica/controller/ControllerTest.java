package com.w2m.pruebatecnica.controller;


import com.w2m.pruebatecnica.entity.Hero;
import com.w2m.pruebatecnica.service.HerosService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class ControllerTest {

    @InjectMocks
    Controller controller;

    @Mock
    private HerosService herosService;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getAllSuperherosTest(){
        List<Hero> heroesList = new ArrayList<>();
        heroesList.add(new Hero(Long.valueOf(1),"superman"));
        Mockito.when(herosService.getAllSuperHeroes()).thenReturn(heroesList);
        controller.getAllSuperHeroes();
        Assert.assertEquals(heroesList,controller.getAllSuperHeroes().getBody());
    }

}
