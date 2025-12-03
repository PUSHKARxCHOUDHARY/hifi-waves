package com.hifi.dao;

import com.hifi.model.Message;
import com.hifi.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessageDAO {

    public boolean saveMessage(int userId, String username, String text) {
        String sql = "INSERT INTO messages (user_id, username, text) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.setString(2, username);
            ps.setString(3, text);

            return ps.executeUpdate() == 1;

        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    public List<Message> getAllMessages() {
        List<Message> list = new ArrayList<>();
        String sql = "SELECT * FROM messages ORDER BY created_at ASC";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Message(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("text"),
                        rs.getTimestamp("created_at")
                ));
            }

        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
}
