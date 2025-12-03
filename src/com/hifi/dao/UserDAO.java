package com.hifi.dao;

import com.hifi.model.User;
import com.hifi.util.DBConnection;
import com.hifi.util.PasswordUtil;

import java.sql.*;

public class UserDAO {

    public boolean registerUser(String username, String password, String email) {
        String sql = "INSERT INTO users (username, password_hash, email) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, PasswordUtil.hash(password));
            ps.setString(3, email);

            return ps.executeUpdate() == 1;

        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

    public User login(String username, String password) {
        String sql = "SELECT id, username, email FROM users WHERE username=? AND password_hash=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, PasswordUtil.hash(password));

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("id"),
                                rs.getString("username"),
                                rs.getString("email"));
            }

        } catch (Exception e) { e.printStackTrace(); }
        return null;
    }
}
