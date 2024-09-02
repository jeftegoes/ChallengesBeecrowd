package com.snack;

import com.snack.applications.ProductApplication;
import com.snack.entities.Product;
import com.snack.facade.ProductFacade;
import com.snack.repositories.ProductRepository;
import com.snack.services.ProductService;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    private static ProductRepository productRepository;
    private static ProductService productService;
    private static ProductApplication productApplication;
    private static ProductFacade productFacade;
    private static List<Product> products;
    private static Scanner scanner;

    public static void resolveDependencies() {
        productRepository = new ProductRepository();
        productService = new ProductService();
        productApplication = new ProductApplication(productRepository, productService);
        productFacade = new ProductFacade(productApplication);
        scanner = new Scanner(System.in);
    }

    public static void initializeProducts() {
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

    public static void showMenu() {
        System.out.println("\n1 - New product");
        System.out.println("2 - Update product");
        System.out.println("3 - List products");
        System.out.println("4 - Sell");
        System.out.println("5 - Remove product");
        System.out.println("6 - Exit");
    }

    public static int getUserInput() {
        System.out.println("Please indicate the option you want: ");
        return scanner.nextInt();
    }

    public static void listAllProducts() {
        StringBuilder menu = new StringBuilder();
        String formatText = "%-10s %-20s %-20s%n";
        System.out.print(String.format(formatText, "Id", "Name", "Price"));
        productFacade.getAll().forEach(p -> {
            System.out.print(p);
        });
    }

    public static void newProduct() {
        System.out.println("Enter the product id: ");
        int id = scanner.nextInt();

        System.out.println("Enter the description product: ");
        String description = scanner.next();

        System.out.println("Enter the price product: ");
        float price = scanner.nextFloat();

        System.out.println("Enter the image path of product: ");
        String imagePath = scanner.next();

        Product product = new Product(id, description, price, imagePath);
        productFacade.append(product);

        System.out.println("Product registered successfully!");
    }

    public static void sellProduct() {
        System.out.println("What product do you want to buy? ");
        int id = scanner.nextInt();

        System.out.println("And the quantity? ");
        int quantity = scanner.nextInt();

        System.out.println("Total: " + productFacade.sellProduct(id, quantity));
    }

    public static void updateProduct() {
        System.out.println("What product do you want to update? ");
        int id = scanner.nextInt();

        System.out.println("Enter the description product: ");
        String description = scanner.next();

        System.out.println("Enter the price product: ");
        float price = scanner.nextFloat();

        System.out.println("Enter the image path of product: ");
        String imagePath = scanner.next();

        Product product = new Product(id, description, price, imagePath);

        productFacade.update(id, product);
    }


    public static void removeProduct() {
        System.out.println("What product do you want to remove? ");
        int id = scanner.nextInt();

        productFacade.remove(id);
    }

    public static void run() {
        int menuOption;
        do {
            showMenu();
            menuOption = getUserInput();

            switch (menuOption) {
                case 1:
                    newProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    listAllProducts();
                    break;
                case 4:
                    sellProduct();
                    break;
                case 5:
                    removeProduct();
                    break;
            }

        } while (menuOption != 6);
    }

    public static void main(String[] args) {
        resolveDependencies();
        initializeProducts();
        run();
    }
}
