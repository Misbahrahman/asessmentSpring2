package com.example.assessment.controller;

import com.example.assessment.dto.req.ProductReq;
import com.example.assessment.models.Category;
import com.example.assessment.models.PaymentMode;
import com.example.assessment.models.Product;
import com.example.assessment.models.User;
import com.example.assessment.repository.UserRepository;
import com.example.assessment.service.OrderService;
import com.example.assessment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class controller {

    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/addProduct")
    ResponseEntity addProduct(@RequestBody ProductReq productReq){

        String name = productService.addProduct(productReq);
        return new ResponseEntity(name , HttpStatus.OK);

    }

    @PostMapping("/productsWithA")
    ResponseEntity allProductsWithNameStartingWithA(@RequestParam("userID") int userId ,@RequestParam("mode") PaymentMode paymentMode){

        List<Product> response= orderService.allProductsWithNameStartingWithA(userId  , paymentMode);
        return new ResponseEntity(response , HttpStatus.OK);
    }


    @GetMapping("/getMaxForXCategory")
    ResponseEntity getMaxForCategory(@RequestParam("x") Category category){
        Product product = productService.getMaxForCategory(category);
        return new ResponseEntity("Order Placed" , HttpStatus.OK);
    }

    @PostMapping("/orderLowestOfAllCategory")
    ResponseEntity orderLowestPriced(@RequestParam("userID") int userId ,@RequestParam("mode")PaymentMode paymentMode){
        List<Product> response= orderService.orderLowestPriced(userId , paymentMode);
        return new ResponseEntity("Order Placed" , HttpStatus.OK);
    }

    String addUser(User user){
        userRepository.save(user);
        return "Added";
    }

}
