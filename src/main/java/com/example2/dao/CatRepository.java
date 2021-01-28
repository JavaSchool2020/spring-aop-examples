package com.example2.dao;

import com.example2.Cat;

import java.util.List;

public interface CatRepository {
    Cat getCat(int id);
    List<Cat> getAllCat();
    void addCat(int id, Cat cat);
}
