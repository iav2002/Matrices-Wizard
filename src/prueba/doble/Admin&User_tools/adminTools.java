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
public class adminTools {
 
   //DB_URL driver name and datbase URL
    static final String DB_URL = "jdbc:mysql://localhost:3306/MatricesUsers";
    
    //Database credentials
    static final String USER = "root";
    static final String PASS = "root1234";
    
    //Method that will update the values for the Admin
    public void updateValues(String login, String password) throws SQLException{
        
        Connection conn = null;
        Statement stmt = null;
        try{
            //Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
           
        //Create a statement object
        Statement statement = conn.createStatement();
        
        //Use the statement object to execute an UPDATE query
        String sql = "UPDATE logins SET login = '" + login + "', password = '" + password + "' WHERE id = '" + 1 + "'";
        statement.executeUpdate(sql);
        
        //close the statement and connection objects
        statement.close();
        conn.close();
        
    }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }
    }
    //Method that will list all users Signed up 
    public void retrieveValuesFromTable(String tableName) throws SQLException{
        //Establish a connetion to the database
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        
        //Create a Statement object
        Statement stmt = conn.createStatement();
        
        //Execute a SELECT statement and process the result set
        String sql = "SELECT * FROM " + tableName;
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("login");
            String role = rs.getString("role");
            System.out.println(id + " " + name + " " + role);
        }
        
        //Close the connection
        conn.close();
    }
     //Method that will allow admin to delete any user Signed up 
    public void deleteValuesFromTable(int id) throws SQLException{
        //Establish a connection to the database
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        
        //Create a Statement object
        Statement stmt = conn.createStatement();
        
        //Execute a DELETE statement
        String sql = "DELETE FROM logins WHERE ID = " + id;
        id = stmt.executeUpdate(sql);
        if(id == 0){
            System.out.println("No id found! Just try one that actually exists!");
        }else if (id != 0) {
            System.out.println(id + " User deleted Succesfully! Remember to exit this menu type 0!");
        }
        
        //Close the connection
        conn.close();
          
    }
    //Method that will list all equation and solution performed by any user
    public void printEquationsForUser(int userId) throws SQLException {
    // Replace YOUR_DATABASE_URL, YOUR_USERNAME, and YOUR_PASSWORD with the
    // appropriate values for your database
  
        // Create a statement
        try ( // Connect to the database
                 Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            // Create a statement
            Statement stmt = conn.createStatement();
            // Select the rows from the "equations" table where the user_id matches the user's input
            ResultSet rs = stmt.executeQuery("SELECT * FROM equations WHERE user_id = " + userId);
            // Print the results
            while (rs.next()) {
                System.out.println("Equation ID: " + rs.getInt("equation_id"));
                System.out.println("User ID: " + rs.getInt("user_id"));
                System.out.println("Equation: " + rs.getString("equation"));
                System.out.println("Solution: " + rs.getString("solution"));
            }
            // Close the connection
        }
  }
}



