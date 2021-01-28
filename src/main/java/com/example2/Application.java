package com.example2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        CatShelter catShelter = context.getBean(CatShelter.class);
        Cat cat = catShelter.showCat(1);
        LOGGER.info("This is {}", cat);

        catShelter.addCat(1, new Cat("Tim"));
    }
}
