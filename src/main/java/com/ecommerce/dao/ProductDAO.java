package main.java.com.ecommerce.dao;

import main.java.com.ecommerce.models.Product;
import main.java.com.ecommerce.utils.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public boolean addProduct(Product p) throws SQLException {
        Connection con = DBUtil.getConnection();
        String sql = "INSERT INTO product VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, p.getId());
        ps.setString(2, p.getName());
        ps.setDouble(3, p.getPrice());
        ps.setInt(4, p.getStock());

        int rows = ps.executeUpdate();
        con.close();
        return rows > 0;
    }

    public List<Product> getAllProducts() throws SQLException {
        List<Product> list = new ArrayList<>();
        Connection con = DBUtil.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM product");
        while (rs.next()) {
            list.add(new Product(rs.getInt("id"),
                                 rs.getString("name"),
                                 rs.getDouble("price"),
                                 rs.getInt("stock")));
        }
        con.close();
        return list;
    }

    public boolean updateProductPrice(int id, double price) throws SQLException {
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = con.prepareStatement("UPDATE product SET price=? WHERE id=?");
        ps.setDouble(1, price);
        ps.setInt(2, id);
        int rows = ps.executeUpdate();
        con.close();
        return rows > 0;
    }

    public boolean deleteProduct(int id) throws SQLException {
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = con.prepareStatement("DELETE FROM product WHERE id=?");
        ps.setInt(1, id);
        int rows = ps.executeUpdate();
        con.close();
        return rows > 0;
    }
}
