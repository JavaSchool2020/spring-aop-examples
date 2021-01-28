package com.example2;

import com.example2.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CatShelter {

    private CatService catService;

    @Autowired
    public CatShelter(CatService catService) {
        this.catService = catService;
    }

    public Cat showCat(int id) {
        return catService.getCat(id);
    }

    public List<Cat> showAllCat(){
       return catService.getAllCat();
    }

    public void addCat(int i, Cat cat){
        catService.addCat(i, cat);
    }
}
