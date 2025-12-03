package java_backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDAO {

    // Add a new order
    public boolean addOrder(int userId, String productName, int quantity) {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO orders (user_id, product_name, quantity) VALUES (?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.setString(2, productName);
            ps.setInt(3, quantity);
            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("Error adding order: " + e.getMessage());
            return false;
        }
    }

    // Get all orders of a user
    public ResultSet getOrdersByUser(int userId) {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM orders WHERE user_id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            return ps.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error fetching orders: " + e.getMessage());
            return null;
        }
    }

    // Delete an order by order ID
    public boolean deleteOrder(int orderId) {
        Connection conn = DBConnection.getConnection();
        String sql = "DELETE FROM orders WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, orderId);
            int rowsDeleted = ps.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println("Error deleting order: " + e.getMessage());
            return false;
        }
    }
}
