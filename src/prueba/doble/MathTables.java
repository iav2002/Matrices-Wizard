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
 public void insertEquation(int userId, String equation, String solution) throws SQLException {
  // Insert a new equation and its solution into the "equations" table
        PreparedStatement pstmt = conn.prepareStatement(
          "INSERT INTO equations (user_id, equation, solution) VALUES (?, ?, ?)");
        pstmt.setInt(1, userId);
        pstmt.setString(2, equation);
        pstmt.setString(3, solution);
        pstmt.executeUpdate();
      }

}
   

//   String insertSql = "INSERT INTO matrix_table (literal, coefficient, constant) VALUES (?, ?, ?)";
//                
//                PreparedStatement pstmt = conn.prepareStatement(insertSql);
//
//                for ( i = 0; i < n; i++) {
//                    for ( j = 0; j < n; j++) {
//                        pstmt.setString(1, String.valueOf(literales.charAt(j)));
//                        pstmt.setInt(2, matriz[i][j]);
//                        pstmt.setInt(3, conts[i][0]);
//                        pstmt.executeUpdate();
 
    

    


