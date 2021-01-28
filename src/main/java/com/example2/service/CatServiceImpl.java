package com.example2.service;

import com.example2.Cat;
import com.example2.aspects.CatchException;
import com.example2.aspects.Log;
import com.example2.dao.CatRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatServiceImpl implements CatService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CatServiceImpl.class);

    private CatRepository catRepository;

    @Autowired
    public CatServiceImpl(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    @Override

    public Cat getCat(int id) {
        Cat cat = catRepository.getCat(id);
        return cat;
    }

    @Override
    public List<Cat> getAllCat() {
        return catRepository.getAllCat();
    }

    @Override
    @CatchException
    @Log
    public void addCat(int id, Cat cat) {
        LOGGER.info("addCat в CatServiceImpl");
        catRepository.addCat(id, cat);
        getCat(id);
    }


}
