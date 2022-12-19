/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba.doble;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

/**
 *
 * @author bernardogandara
 */
public class usertools {
    
      //JDBC driver name and datbase URL
    // static final String JDBC_DRIVER = "jdbc:mysql://localhost:3306/?user=root";
    static final String DB_URL = "jdbc:mysql://localhost:3306/MatricesUsers";
    
    //Database credentials
    static final String USER = "root";
    static final String PASS = "root1234";
    
    //Method that allow user to modify his username and password
    public void updateValues(String login, String password) throws SQLException {
    Connection conn = null;
    PreparedStatement stmt = null;
    try {
        // Open a connection
        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        // Create a prepared statement to select the id of the row to update
        String sql = "SELECT id FROM logins WHERE login = ? AND password = ?";
        stmt = conn.prepareStatement(sql);

        // Set the values for the prepared statement's placeholders
        stmt.setString(1, login);
        stmt.setString(2, password);

        // Execute the query to select the id
        ResultSet rs = stmt.executeQuery();

        // If the query returns a result, update the row
        if (rs.next()) {
            int id = rs.getInt("id");

            // Create a new prepared statement to update the password
            sql = "UPDATE logins SET password = ? WHERE login = ? AND id = ?";
            stmt = conn.prepareStatement(sql);

            // Set the values for the prepared statement's placeholders
            stmt.setString(1, password);
            stmt.setString(2, login);
            stmt.setInt(3, id);

            // Execute the update
            stmt.executeUpdate();
        }

        // Close the result set, prepared statement, and connection objects
        rs.close();
        stmt.close();
        conn.close();

    } catch (SQLException se) {
        // Handle errors for JDBC
        se.printStackTrace();
    }
 
    }
  //Method that will allow users to view his previous equations solved
  public void viewEquations(String login, String password) throws SQLException {
    // Connect to the database
    Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

    // Create a statement
    Statement stmt = conn.createStatement();

    // Select the user's id from the "logins" table
    ResultSet rs = stmt.executeQuery("SELECT id FROM logins WHERE login = '" + login + "' AND password = '" + password + "'");

    // Get the user's id
    int userId = 0;
    if (rs.next()) {
      userId = rs.getInt("id");
    } else {
      System.out.println("Invalid login or password");
      return;
    }

    // Select the rows from the "equations" table where the user_id matches the user's id
    rs = stmt.executeQuery("SELECT * FROM equations WHERE user_id = " + userId);

    // Print the results
    while (rs.next()) {
      System.out.println("Equation: " + rs.getString("equation"));
      System.out.println("Solution: " + rs.getString("solution"));
    }

    // Close the connection
    conn.close();
  }
}  
    
    

    

