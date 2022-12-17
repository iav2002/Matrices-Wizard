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
    String password = "root";
    Connection conn = null;
    
    public void createOperationsTable() throws SQLException {
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Unable to connect to the database.");
            return;
        }
        
        //Create a Statement
        Statement stmt = conn.createStatement();
        // Create the table to store operation_id(PK), user_id(FK) and var_id(FK)
        
        String createTableSQL = "CREATE TABLE operations (operation_id INTEGER PRIMARY KEY AUTO_INCREMENT, id INTEGER NOT NULL,FOREIGN KEY (id) REFERENCES logins(id))";
                //"var_id INTEGER NOT NULL," +

                //"FOREIGN KEY (var_id) REFERENCES variables(var_id)" +

            stmt.executeUpdate(createTableSQL);
            
        //Close the resources
        stmt.close();
        conn.close();
    }
    
//    public void createEquationsTable() throws SQLException{
//        try {
//            conn = DriverManager.getConnection(url, user, password);
//        } catch (SQLException e) {
//            System.out.println("Unable to connect to the database.");
//            return;
//        }
//        
//        //Create a Statement
//        Statement stmt = conn.createStatement();
//        // Create the table Variables to store operation_id(PK), user_id(FK) and var_id(FK)
//        String sql = "CREATE TABLE equations (" +
//                "eq_id INTENGER PRIMARY KEY AUTO_INCREMENT,"
//                + "operation_id INTEGER,"
//                + "constant INTEGER"
//                + "FOREIGN KEY (operation_id) REFERENCES operations(operation_id),"
//                + ")";
//        stmt.executeQuery(sql);
//        
//        //close the resources
//        stmt.close();
//        conn.close();
//       
//    }
//    
//    public void createVarTable() throws SQLException{
//        try {
//            conn = DriverManager.getConnection(url, user, password);
//        } catch (SQLException e) {
//            System.out.println("Unable to connect to the database.");
//            return;
//        }
//        
//        //Create a Statement
//        Statement stmt = conn.createStatement();
//        String sql = "CREATE TABLE variables (" +
//                "var_id INTENGER PRIMARY KEY AUTO_INCREMENT,"
//                + "eq_id INTEGER,"
//                + "co-factor INTEGER,"
//                + "var_char VARCHAR(1),"
//                + "var_value INTEGER,"
//                + "FOREIGN KEY (eq_id) REFERENCES equations(eq_id),"
//                + ")";
//        stmt.executeQuery(sql);
//        
//        //close the resources
//        stmt.close();
//        conn.close();
//    }

}
