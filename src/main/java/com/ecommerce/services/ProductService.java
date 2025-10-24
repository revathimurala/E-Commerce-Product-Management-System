package main.java.com.ecommerce.services;

import main.java.com.ecommerce.dao.ProductDAO;
import main.java.com.ecommerce.models.Product;
import java.sql.SQLException;
import java.util.List;

public class ProductService {
    private ProductDAO dao = new ProductDAO();

    public void addProduct(Product p) {
        try {
            if (dao.addProduct(p))
                System.out.println("✅ Product added successfully!");
        } catch (SQLException e) {
            System.out.println("⚠️ " + e.getMessage());
        }
    }

    public void viewProducts() {
        try {
            List<Product> list = dao.getAllProducts();
            list.forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println("⚠️ " + e.getMessage());
        }
    }
}
