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
    String createTableSql = "CREATE TABLE logins (id INTEGER PRIMARY KEY AUTO_INCREMENT, login VARCHAR(20), password VARCHAR(20), role VARCHAR(10))";
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
        String verifySql = "SELECT password FROM logins WHERE login = '" + login + "' AND password = '" + password + "'";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(verifySql);
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
    
    
    
    
    
    
    
    /// Method to get the password for a login
//    public String getPasswordForLogin(String login) throws SQLException {
//        String verifySql = "SELECT password FROM logins WHERE login = '" + login + "'";
//        Statement stmt = conn.createStatement();
//         System.out.print("Enter username: ");
//        ResultSet rs = stmt.executeQuery(verifySql);
//        if (rs.next()) {
//            String passwordFromDb = rs.getString("password");
//           
//            Scanner scanner = new Scanner(System.in);
//            System.out.print("Enter password: ");
//            String password = scanner.nextLine();
//            if (password.equals(passwordFromDb)) {
//                System.out.println("Exito");
//                return passwordFromDb;
//                
//            } else {
//                System.out.println("Incorrect password. Please try again.");
//                return getPasswordForLogin(login);
//            }
//        } else {
//            System.out.println("No such login was found in the database. Please try again.");
//            Scanner scanner = new Scanner(System.in);
//            System.out.print("Enter login: ");
//            String newLogin = scanner.nextLine();
//            return getPasswordForLogin(newLogin);
//    }
}

