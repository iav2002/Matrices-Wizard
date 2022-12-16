/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba.doble;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ignacioalarconvarela
 */
public class usertools {
    
      //JDBC driver name and datbase URL
    // static final String JDBC_DRIVER = "jdbc:mysql://localhost:3306/?user=root";
    static final String DB_URL = "jdbc:mysql://localhost:3306/MatricesUsers";
    
    //Database credentials
    static final String USER = "root";
    static final String PASS = "root";
    
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
    
    
}
