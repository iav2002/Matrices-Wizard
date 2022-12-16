/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba.doble;
import java.sql.*;
import java.util.Scanner;
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
        
        //ID AUTO INCREMENTATIVO
        //ROL, ADMIN O USER 
        //INSERTAR ADMIN
    String createTableSql = "CREATE TABLE logins (id INTEGER PRIMARY KEY AUTO_INCREMENT, login VARCHAR(20), password VARCHAR(20), role VARCHAR(10) DEFAULT 'user')";
    String insertRowSql = "INSERT INTO logins (login, password, role) VALUES ('CCT', 'Dublin', 'admin')";

    Statement stmt = conn.createStatement();
    try {
        stmt.executeUpdate(createTableSql);
        stmt.executeUpdate(insertRowSql);
           } catch (SQLException e) {
        System.out.println("Unable to create the logins table or insert a row.");
        return;
        }
    }
    
    // Method to insert a login and password into the table
    public void SignUP(String login, String password) throws SQLException {
        
        String insertSql = "INSERT INTO logins (login, password) VALUES ('" + login + "', '" + password + "')";
        Statement stmt = conn.createStatement();
        try {
            stmt.executeUpdate(insertSql);
        } catch (SQLException e) {
            System.out.println("Unable to insert the login and password.");
            return;
        }
    }
    
    public String getPasswordForLogin(String login, String password) throws SQLException {
    String verifySql = "SELECT password FROM logins WHERE login = ? AND password = ?";
    try (PreparedStatement stmt = conn.prepareStatement(verifySql)) {
        stmt.setString(1, login);
        stmt.setString(2, password);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                // Login and password match the ones in the database
                
                System.out.println("SUCCESS");
                return password;
            } else {
                System.out.println("Incorrect login or password. Please try again.");
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter Username: ");
                String newLogin = scanner.nextLine();
                System.out.print("Enter password: ");
                String newPassword = scanner.nextLine();
                return getPasswordForLogin(newLogin, newPassword);
            }
        }
    }
}

    
   public String getRoleForLogin(String login, String password) throws SQLException {
    String verifySql = "SELECT role FROM logins WHERE login = ? AND password = ?";
    try (PreparedStatement stmt = conn.prepareStatement(verifySql)) {
        stmt.setString(1, login);
        stmt.setString(2, password);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                // Login and password match the ones in the database
                
                return rs.getString("role");
                
            } else {
                return null;
            }
        }
    }
}

    
    
    
    // VIEJO CODIGO PARA VERIFICACION DE USUARIO Y CONTRASENA, MEJORADO 
    
        //     public String getPasswordForLogin(String login, String password) throws SQLException {
        //        String verifySql = "SELECT password FROM logins WHERE login = '" + login + "' AND password = '" + password + "'";
        //        Statement stmt = conn.createStatement();
        //        ResultSet rs = stmt.executeQuery(verifySql);
        //        if (rs.next()) {
        //            // Login and password match the ones in the database
        //            System.out.println("SUCCESS");
        //            return password;
        //        } else {
        //            System.out.println("Incorrect login or password. Please try again.");
        //            Scanner scanner = new Scanner(System.in);
        //            System.out.print("Enter Username: ");
        //            String newLogin = scanner.nextLine();
        //            System.out.print("Enter password: ");
        //            String newPassword = scanner.nextLine();
        //            return getPasswordForLogin(newLogin, newPassword);
        //        }
        //}


}

