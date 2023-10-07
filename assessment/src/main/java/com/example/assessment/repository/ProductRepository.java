package com.example.assessment.repository;

import com.example.assessment.models.Category;
import com.example.assessment.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product , Integer> {
    List<Product> findAllByCategory(Category category);
}
