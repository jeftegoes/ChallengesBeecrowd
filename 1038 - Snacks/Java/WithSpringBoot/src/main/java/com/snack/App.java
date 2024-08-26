package com.snack;

import com.snack.applications.ProductApplication;
import com.snack.entities.Product;
import com.snack.facade.ProductFacade;
import com.snack.repositories.ProductRepository;
import com.snack.services.ProductService;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository();
        ProductService productService = new ProductService();
        ProductApplication productApplication = new ProductApplication(productRepository, productService);
        ProductFacade productFacade = new ProductFacade(productApplication);
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

        List<Product> products = productFacade.getAll();
        StringBuilder menu = new StringBuilder();
        String formatText = "%-10s %-20s %-20s%n";
        System.out.print(String.format(formatText, "Code", "Name", "Price"));

        products.forEach(p -> {
            System.out.print(p);
        });
    }
}
