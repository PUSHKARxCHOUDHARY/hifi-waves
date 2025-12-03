import java.sql.*;

public class OrderDAO {

    public boolean addOrder(String username, String product, int amount) {
        String sql = "INSERT INTO orders(username, product, amount) VALUES(?, ?, ?)";

        try (Connection conn = DBconnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, product);
            ps.setInt(3, amount);

            return ps.executeUpdate() == 1;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
