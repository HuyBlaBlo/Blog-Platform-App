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
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    private final CategoryMapper categoryMapper;

    // GET /api/v1/categories: get all category
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategory(){
        List<CategoryDto> listCategories = this.categoryService.listCategories()
                .stream().map(categoryMapper::toDto)
                .toList();
        return ResponseEntity.ok(listCategories);
    }

    // POST /api/v1/categories: Create a new post
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CreateCategoryRequest categoryRequest){
        Category categoryToCreate = this.categoryMapper.toEntity(categoryRequest);

        Category saveCategory = categoryService.createCategory(categoryToCreate);

        return new ResponseEntity<>(
          this.categoryMapper.toDto(saveCategory),
                HttpStatus.CREATED
        );
    }

    // DELETE /api/v1/categories/{id}
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable UUID id){
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
