package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestAdmin {

    public static void main(String[] args) {

        try {

            Connection con = DBConnection.getConnection();

            System.out.println("DATABASE CONNECTED!");

            String sql =
                    "SELECT * FROM admin WHERE username=? AND password=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, "admin");
            ps.setString(2, "admin123");

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("ADMIN FOUND!");
                System.out.println("Username: " + rs.getString("username"));
            } else {
                System.out.println("ADMIN NOT FOUND!");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}