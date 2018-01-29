package com.sam.spring5mongorecipeapp.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CategoryTest {

    Category category;

    @Before // this method will work for each test
    public void setUp(){
        category = new Category();
    }

    @Test
    public void getId() throws Exception {

    	String idValue ="4";
        category.setId(idValue);

        assertEquals(idValue,category.getId());
    }

    @Test
    public void getDescription() throws Exception {
    }

    @Test
    public void getRecipes() throws Exception {
    }

}