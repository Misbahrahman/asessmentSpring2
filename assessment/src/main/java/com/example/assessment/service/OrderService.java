package com.example.assessment.service;

import com.example.assessment.models.Category;
import com.example.assessment.models.Order;
import com.example.assessment.models.PaymentMode;
import com.example.assessment.models.Product;
import com.example.assessment.repository.OrderRepository;
import com.example.assessment.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;
    public List<Product> allProductsWithNameStartingWithA(int id , PaymentMode paymentMode) {
        List<Product> list = productRepository.findAll();
        List<Product> toOrder = new ArrayList<>();
        for(Product x : list){
            if(x.getName().charAt(0) == 'A'){
                toOrder.add(x);
            }
        }

        Order order = Order.builder()
                .productList(toOrder)
                .UserId(id)
                .paymentMode(paymentMode)
                .build();

        orderRepository.save(order);
        return toOrder;

    }

    public List<Product> orderLowestPriced(int id , PaymentMode paymentMode) {
        List<Product> toOrder = new ArrayList<>();
        for(Category x : Category.values()){
            List<Product> list = productRepository.findAllByCategory(x);
            Collections.sort(list , (a , b) -> {return (a.getPrice() - b.getPrice());});
            toOrder.add(list.get(0));
        }

        Order order = Order.builder()
                .productList(toOrder)
                .UserId(id)
                .paymentMode(paymentMode)
                .build();


        orderRepository.save(order);

        return toOrder;

    }
}
