package main.java.com.ecommerce.ui;

import main.java.com.ecommerce.models.Product;
import main.java.com.ecommerce.services.ProductService;
import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args) {
        ProductService service = new ProductService();

        if (System.console() == null) {
            // Non-interactive environment: print menu and exit to avoid blocking or input errors
            System.out.println("\n===== PRODUCT MENU =====");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Exit");
            System.out.println("(No console available - exiting)");
            return;
        }

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n===== PRODUCT MENU =====");
                System.out.println("1. Add Product");
                System.out.println("2. View Products");
                System.out.println("3. Exit");
                System.out.print("Enter choice: ");
                if (!sc.hasNextInt()) {
                    System.out.println("\nNo input available, exiting.");
                    return;
                }
                int ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        System.out.print("Enter Name: ");
                        String name = sc.next();
                        System.out.print("Enter Price: ");
                        double price = sc.nextDouble();
                        System.out.print("Enter Stock: ");
                        int stock = sc.nextInt();
                        Product p = new Product(id, name, price, stock);
                        service.addProduct(p);
                        break;

                    case 2:
                        service.viewProducts();
                        break;

                    case 3:
                        System.out.println("Exiting...");
                        System.exit(0);
                }
            }
        }
    }
}
