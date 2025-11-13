package com.example.e_commerce_api.service;

import com.example.e_commerce_api.entities.Category;
import com.example.e_commerce_api.exceptions.ApiException;

import java.util.List;

public interface CategoryService {
    List<Category> findallCategories() throws ApiException;
    Category getById(int id) throws ApiException;
    void create(Category req) throws ApiException;
    void update(Category req) throws ApiException;

    Object getAllCategories();
}
