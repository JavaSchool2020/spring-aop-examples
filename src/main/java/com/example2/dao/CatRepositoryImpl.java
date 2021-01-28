package com.example2.dao;

import com.example2.Cat;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class CatRepositoryImpl implements CatRepository {
    private Map<Integer, Cat> catMap = new HashMap<>();

    public CatRepositoryImpl(){
        catMap.put(1, new Cat("Kitty"));
        catMap.put(2, new Cat("Tom"));
        catMap.put(3, new Cat("Iris"));
    }

    @Override
    public Cat getCat(int id) {
        return catMap.get(id);
    }

    @Override
    public List<Cat> getAllCat() {
        return new ArrayList<>(catMap.values());
    }

    @Override

    public void addCat(int id, Cat cat) {
        if (catMap.containsKey(id)){
            throw new IllegalArgumentException("Incorrect id");
        }
        catMap.put(id, cat);
    }
}
