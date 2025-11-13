package com.example.e_commerce_api.service.impl;

import com.example.e_commerce_api.entities.Category;
import com.example.e_commerce_api.exceptions.ApiException;
import com.example.e_commerce_api.repository.CategoryRepository;
import com.example.e_commerce_api.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public List<Category> findallCategories() throws ApiException {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(int id) throws ApiException {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void create(Category req) throws ApiException {
        categoryRepository.save(req);
    }

    @Override
    public void update(Category req) throws ApiException {
        categoryRepository.save(req);
    }

    @Override
    public Object getAllCategories() {
        return categoryRepository.findAll();
    }
}
