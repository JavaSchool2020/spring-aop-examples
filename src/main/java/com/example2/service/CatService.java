package com.example2.service;

import com.example2.Cat;

import java.util.List;

public interface CatService {
    Cat getCat(int id);
    List<Cat> getAllCat();
    void addCat(int id, Cat cat);
}
