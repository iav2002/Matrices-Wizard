/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba.doble;
import java.sql.*;
/**
 *
 * @author ignacioalarconvarela
 */
public class LoginSystem {
    // Set up the connection to the mySQL database
    String url = "jdbc:mysql://localhost:3306/MatricesUsers";
    String user = "root";
    String password = "root1234";
    Connection conn = null;
    
    public void LoginSystem() throws SQLException {
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Unable to connect to the database.");
            return;
        }
        
        // Create the table to store login and password information
        String createTableSql = "CREATE TABLE logins (login VARCHAR(20), password VARCHAR(20))";
        Statement stmt = conn.createStatement();
        try {
            stmt.executeUpdate(createTableSql);
        } catch (SQLException e) {
            System.out.println("Unable to create the logins table.");
            return;
        }
    }
    
    // Method to insert a login and password into the table
    public void insertLogin(String login, String password) throws SQLException {
        String insertSql = "INSERT INTO logins (login, password) VALUES ('" + login + "', '" + password + "')";
        Statement stmt = conn.createStatement();
        try {
            stmt.executeUpdate(insertSql);
        } catch (SQLException e) {
            System.out.println("Unable to insert the login and password.");
            return;
        }
    }
    
    // Method to verify a login and password
    public boolean verifyLogin(String login, String password) throws SQLException {
        String verifySql = "SELECT password FROM logins WHERE login = '" + login + "'";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(verifySql);
        if (rs.next()) {
            String passwordFromDb = rs.getString("password");
            return password.equals(passwordFromDb);
        } else {
            return false;
        }
    }
}
