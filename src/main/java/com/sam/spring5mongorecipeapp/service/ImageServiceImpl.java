package com.sam.spring5mongorecipeapp.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.sam.spring5mongorecipeapp.domain.Recipe;
import com.sam.spring5mongorecipeapp.repository.RecipeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

    private final RecipeRepository recipeRepository;

    public ImageServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    @Transactional
    public void saveImageFile(String recipeId, MultipartFile file) {

        try{
            Recipe recipe = recipeRepository.findById(recipeId).get();

            Byte[] byteObjects = new Byte[file.getBytes().length];

            int i = 0;

            for(byte b : file.getBytes()){
                byteObjects[i++] =  b;
            }

            recipe.setImage(byteObjects);


            recipeRepository.save(recipe);
        }catch (IOException e){
            //todo handle better
            log.error("Error occurred" , e);

            e.printStackTrace();
        }


    }
}