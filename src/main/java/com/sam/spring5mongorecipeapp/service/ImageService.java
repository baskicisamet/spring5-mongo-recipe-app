package com.sam.spring5mongorecipeapp.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    void saveImageFile(String recipeId, MultipartFile file);
}
