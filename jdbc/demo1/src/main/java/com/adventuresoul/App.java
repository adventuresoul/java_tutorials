package com.adventuresoul;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class App {
    public static void main(String[] args) {
        // load postgres JDBC Driver 
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String jdbcURL = "jdbc:postgresql://localhost:5432/Demo";
        String username = "postgres";
        String password = "**************";

        try {
            Connection conn = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to postgres db");

            // create a Statement
            Statement st = conn.createStatement();

            // actual sql
            String sql = "SELECT * FROM product";
            //execute
            try {
                ResultSet rs = st.executeQuery(sql);
                
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + " " + rs.getString("name"));
                }
                
            } catch (SQLException e) {
                throw e;
            }

            // prepared statements for DML, (prevents sql injection)
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM product WHERE id = ?");
            // set params
            ps.setInt(1, 2);

            try {
                ResultSet rs1 = ps.executeQuery();
      
                while(rs1.next()) {
                    System.out.println(rs1.getInt("id") + " " + rs1.getString("name"));
                }
            } catch (SQLException e) {
                throw e;
            }

            // insert, update and delete with prepared statement
            PreparedStatement ps1 = conn.prepareStatement("INSERT INTO product (id, name, price, description) VALUES (?, ?, ?, ?)");
            ps1.setInt(1, 3);
            ps1.setString(2, "Dark fantasy");
            ps1.setDouble(3, 30.0);
            ps1.setString(4, "A chocolate biscuits");

            try {
                int res = ps1.executeUpdate();
                System.out.println(res + " rows affected");
            } catch (SQLException e) {
                throw e;
            }

            ps.close();
            st.close();
            ps1.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
