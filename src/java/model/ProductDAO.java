/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.DbUtils;

/**
 *
 * @author an0other
 */
public class ProductDAO {

    public static final String GET_ALL_PRODUCT = "select * from tblProducts";
    public static final String GET_PRODUCT_BY_ID = "select * from tblProducts where tblProducts.id=?";
    public static final String CREATE_PRODUCT = "insert into tblProducts(id, name, description, price, size, status) values (?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_PRODUCT = "update tblProducts set name = ?, description = ?, price = ?, size = ?, status = ? where id = ?";
    public static final String DELETE_PRODUCT = "delete fron tblProducts where id=?";

    public ArrayList<ProductDTO> getAllProduct() {
        ArrayList<ProductDTO> arr = new ArrayList<ProductDTO>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = GET_ALL_PRODUCT;

            conn = DbUtils.getConnection();

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                Float price = rs.getFloat("price");
                String size = rs.getString("size");
                Boolean status = rs.getBoolean("status");
                arr.add(new ProductDTO(id, name, description, price, size, status));
            }
        } catch (Exception e) {
            System.err.println("Error closing resources: " + e.getMessage());
            e.printStackTrace();
        } finally {
            closeResources(conn, ps, rs);
        }
        return arr;
    }

    public ProductDTO getProductByID(String id) {
        ProductDTO product = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = GET_PRODUCT_BY_ID;

            conn = DbUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                id = rs.getString("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                Float price = rs.getFloat("price");
                String size = rs.getString("size");
                Boolean status = rs.getBoolean("status");
                product = new ProductDTO(id, name, description, price, size, status);
            }
        } catch (Exception e) {
            System.err.println("Error closing resources: " + e.getMessage());
            e.printStackTrace();
        } finally {
            closeResources(conn, ps, rs);
        }

        return product;
    }

    public boolean createProduct(ProductDTO product) {
        boolean isDone = false;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = CREATE_PRODUCT;

            conn = DbUtils.getConnection();

            ps.setString(1, product.getId());
            ps.setString(2, product.getName());
            ps.setString(3, product.getDescription());
            ps.setFloat(4, product.getPrice());
            ps.setString(5, product.getSize());
            ps.setBoolean(6, product.isStatus());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                isDone = true;
            }

        } catch (Exception e) {
            System.err.println("Error closing resources: " + e.getMessage());
            e.printStackTrace();
        } finally {
            closeResources(conn, ps, rs);
        }
        return isDone;
    }

    private void closeResources(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (conn != null) {
                conn.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        } catch (Exception e) {
            System.err.println("Error closing resources: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean updateProduct(ProductDTO product) {
        boolean isDone = false;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = UPDATE_PRODUCT;
            conn = DbUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setFloat(3, product.getPrice());
            ps.setString(4, product.getSize());
            ps.setBoolean(5, product.isStatus());
            ps.setString(6, product.getId());
            int rowsAffected = ps.executeUpdate();
            isDone = (rowsAffected > 0);
        } catch (Exception e) {
            System.err.println("Error closing resources: " + e.getMessage());
            e.printStackTrace();
        } finally {
            closeResources(conn, ps, rs);
        }
        return isDone;
    }

    public boolean deleteProduct(String id) {
        boolean isDone = false;
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;

        try {
            String sql = DELETE_PRODUCT;
            conn = DbUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            int rowsAffected = ps.executeUpdate();
            isDone = (rowsAffected > 0);
        } catch (Exception e) {
            System.err.println("Error closing resources: " + e.getMessage());
            e.printStackTrace();
        } finally {
            closeResources(conn, ps, rs);
        }
        return isDone;
    }

}
