package com.example.jdbc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Simple in-memory demo that mimics JDBC insert/delete operations using a List.
 * Useful when you don't have a MySQL server available.
 */
public class InMemoryDemo {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        // Insert - mimic JDBCInsert
        Product p1 = new Product(1, "Sample Product", 49.99);
        products.add(p1);
        System.out.println("Inserted: " + p1);

        // Show all - mimic SELECT
        System.out.println("All products:");
        for (Product p : products) {
            System.out.println("  " + p);
        }

        // Delete - mimic JDBCDelete by id
        int idToDelete = 1;
        boolean removed = false;
        Iterator<Product> it = products.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == idToDelete) {
                it.remove();
                removed = true;
                break;
            }
        }
        System.out.println("Deleted rows: " + (removed ? 1 : 0));

        System.out.println("Remaining products: " + products.size());
    }
}
