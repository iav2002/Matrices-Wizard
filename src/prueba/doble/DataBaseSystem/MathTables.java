/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.doble;

import java.sql.Connection;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author bernardogandara
 */
public class MathTables {
    // Set up the connection to the mySQL database
    String url = "jdbc:mysql://localhost:3306/MatricesUsers";
    String user = "root";
    String password = "root1234";
    Connection conn = null;
    
   //Method that creates our second and last table, where we will store equations and solutions (and ids)
   public void equationsTable() throws SQLException {
        try {
          conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
          System.out.println("Unable to connect to the database.");
          return;
        }

    String createTableSQL = "CREATE TABLE equations (equation_id INT AUTO_INCREMENT PRIMARY KEY, user_id INT NOT NULL, FOREIGN KEY (user_id) REFERENCES logins(id), equation VARCHAR(255) NOT NULL, solution VARCHAR(255) NOT NULL)";

        // Create a Statement
        Statement stmt = conn.createStatement();
        try {
          stmt.executeUpdate(createTableSQL);
        } catch (SQLException e) {
          System.out.println("Table was already created, don't worry we made the connection.");
          return;
  }
 }
   //Method to store equations along with the solution and user id that is automated
 public void insertEquation(int userId, String equation, String solution) throws SQLException {
  // Insert a new equation and its solution into the "equations" table
        PreparedStatement pstmt = conn.prepareStatement(
          "INSERT INTO equations (user_id, equation, solution) VALUES (?, ?, ?)");
        pstmt.setInt(1, userId);
        pstmt.setString(2, equation);
        pstmt.setString(3, solution);
        pstmt.executeUpdate();
      }


   //Method that will be used to write in simple form the equations
    public static String getEquations(Scanner sc, int n) {
        StringBuilder sb = new StringBuilder();
        for (int k = 1; k <= n; k++) {
            System.out.println("In order to save the equation it is needed you to write the equations. Please write the equation: " + k);
            String userEquation = sc.nextLine();
            System.out.println("Your equation " + k + ": " + userEquation + " is saved.");
            sb.append(userEquation).append("\n");
        }
        return sb.toString();
    }

   }

    


