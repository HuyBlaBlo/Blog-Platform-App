package com.huybla.blog.services.impl;

import com.huybla.blog.domain.entities.Category;
import com.huybla.blog.repositories.CategoryRepository;
import com.huybla.blog.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAllWithPostCount();
    }
}
