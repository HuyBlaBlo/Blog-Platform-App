package com.huybla.blog.controllers;

import com.huybla.blog.domain.entities.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    // get all category
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategory(){

    }
}
