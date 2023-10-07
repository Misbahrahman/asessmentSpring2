package com.example.assessment.service;

import com.example.assessment.dto.req.ProductReq;
import com.example.assessment.models.Category;
import com.example.assessment.models.Product;
import com.example.assessment.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    public String addProduct(ProductReq productReq) {
        Product product = Product.builder()
                .name(productReq.getName())
                .category(productReq.getCategory())
                .price(productReq.getPrice())
                .build();

        productRepository.save(product);
        return product.getName();
    }

    public Product getMaxForCategory(Category category) {
        List<Product> list = productRepository.findAllByCategory(category);
        Collections.sort(list , (a , b) -> {return (b.getPrice() - a.getPrice());});
        return list.get(0);
    }
}
