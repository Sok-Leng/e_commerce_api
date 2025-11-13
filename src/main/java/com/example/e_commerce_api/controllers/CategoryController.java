package com.example.e_commerce_api.controllers;

import com.example.e_commerce_api.dto.response.MessageResponse;
import com.example.e_commerce_api.entities.Category;
import com.example.e_commerce_api.exceptions.ApiException;
import com.example.e_commerce_api.service.CategoryService;
import com.example.e_commerce_api.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<Object> getAllCategories() {
        try {
            var list = categoryService.getAllCategories();
            return new ResponseEntity<>(MessageUtils.success("Get all categories success", list), HttpStatus.OK);
        } catch (ApiException e) {
            return new ResponseEntity<>(MessageUtils.errorMessage(e.getMessage()), HttpStatus.OK);
        } catch (Throwable e) {
            return new ResponseEntity<>(MessageUtils.generalErrorMessage("Get all categories general exception"), HttpStatus.OK);
        }
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Object> getCategoryByID(@PathVariable ("id")int id) {
        try {
            var category = categoryService.getById(id);
            return new ResponseEntity<>(MessageUtils.success("Get category id success", category), HttpStatus.OK);
        } catch (ApiException e) {
            return new ResponseEntity<>(MessageUtils.errorMessage(e.getMessage()), HttpStatus.OK);
        } catch (Throwable e) {
            return new ResponseEntity<>(MessageUtils.generalErrorMessage("Get category id general exception"), HttpStatus.OK);
        }
    }

    @PostMapping("/categories/create")
    public ResponseEntity<Object> createCategory(@RequestBody Category req) {
        try {
           categoryService.create(req);
            return new ResponseEntity<>(MessageUtils.success("Create category success", null), HttpStatus.OK);
        } catch (ApiException e) {
            return new ResponseEntity<>(MessageUtils.errorMessage(e.getMessage()), HttpStatus.OK);
        } catch (Throwable e) {
            return new ResponseEntity<>(MessageUtils.generalErrorMessage("Create category general exception"), HttpStatus.OK);
        }
    }


    @PostMapping("/categories/update")
    public ResponseEntity<Object> updateCategory(@RequestBody Category req) {
        try {
            categoryService.update(req);
            return new ResponseEntity<>(MessageUtils.success("Update category success", null), HttpStatus.OK);
        } catch (ApiException e) {
            return new ResponseEntity<>(MessageUtils.errorMessage(e.getMessage()), HttpStatus.OK);
        } catch (Throwable e) {
            return new ResponseEntity<>(MessageUtils.generalErrorMessage("Update category general exception"), HttpStatus.OK);
        }
    }

}
