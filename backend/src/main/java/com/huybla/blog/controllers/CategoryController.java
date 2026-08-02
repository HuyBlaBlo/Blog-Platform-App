package com.huybla.blog.controllers;

import com.huybla.blog.domain.dtos.CategoryDto;
import com.huybla.blog.domain.dtos.CreateCategoryRequest;
import com.huybla.blog.domain.entities.Category;
import com.huybla.blog.mappers.CategoryMapper;
import com.huybla.blog.services.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    private final CategoryMapper categoryMapper;

    // get all category
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategory(){
        List<CategoryDto> listCategories = this.categoryService.listCategories()
                .stream().map(categoryMapper::toDto)
                .toList();
        return ResponseEntity.ok(listCategories);
    }

    // POST /api/v1/posts Create a new post
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CreateCategoryRequest categoryRequest){
        Category categoryToCreate = this.categoryMapper.toEntity(categoryRequest);

        Category saveCategory = categoryService.createCategory(categoryToCreate);

        return new ResponseEntity<>(
          this.categoryMapper.toDto(saveCategory),
                HttpStatus.CREATED
        );
    }
}
