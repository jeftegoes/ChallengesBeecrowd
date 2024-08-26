package com.snack.controllers;

import com.snack.applications.ProductApplication;
import com.snack.entities.Product;
import com.snack.facade.ProductFacade;
import com.snack.repositories.ProductRepository;
import com.snack.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductRepository productRepository;
    ;
    private ProductService productService;
    ;
    private ProductApplication productApplication;
    ;
    private ProductFacade productFacade;
    ;
    public ProductController() {
        productRepository = new ProductRepository();
        productService = new ProductService();
        productApplication = new ProductApplication(productRepository, productService);
        productFacade = new ProductFacade(productApplication);

        Product product1 = new Product(1, "Hotdog", 4.00f, "F:\\hotdog.jpg");
        Product product2 = new Product(2, "X-Salad", 4.50f, "F:\\xsalad.jpg");
        Product product3 = new Product(3, "X-Bacon", 5.00f, "F:\\xbacon.jpg");
        Product product4 = new Product(4, "Simple Toast", 2.00f, "F:\\simplestoast.jpg");
        Product product5 = new Product(5, "Refrigerant", 1.50f, "F:\\refrigerante.jpg");

        productFacade.append(product1);
        productFacade.append(product2);
        productFacade.append(product3);
        productFacade.append(product4);
        productFacade.append(product5);
    }

    @GetMapping("/")
    public ResponseEntity<List<Product>> getAll() {
        List<Product> products = productFacade.getAll();

        return ResponseEntity.ok(products);
    }
}
