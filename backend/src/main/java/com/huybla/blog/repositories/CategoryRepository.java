package com.huybla.blog.repositories;

import com.huybla.blog.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

    // show all category with post one each
    @Query("SELECT c from Category c LEFT JOIN FETCH c.posts")
    List<Category> findAllWithPostCount();

    // create a new category
    boolean existsByNameIgnoreCase(String name);

}
