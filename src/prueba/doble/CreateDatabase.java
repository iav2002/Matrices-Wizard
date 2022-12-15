/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class CreateDatabase {
    
    //JDBC driver name and datbase URL
//    static final String dbName = "MatricesWizard";
   // static final String JDBC_DRIVER = "jdbc:mysql://localhost:3306/?user=root";
    static final String DB_URL = "jdbc:mysql://localhost/";
    
    //Database credentials
    static final String USER = "root";
    static final String PASS = "root";
    
    public boolean CreateDatabase(){
        
        Connection conn = null;
        Statement stmt = null;
        
        try{
            //Register JDBC driver
            //Class.forName("com.mysql.jdbc.Driver");
            
            //Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");
            
            //Execute a query
            System.out.println("Creating database...");
            stmt = conn.createStatement();
            
            String sql = "CREATE DATABASE MatricesWizard";
            stmt.executeUpdate(sql);
            System.out.println("Database created succesfully...");
            
            //Now on, I will be creating the table of USERS
            
            stmt.execute("USE MatricesWizard;");
            
            stmt = conn.createStatement();
            
            //Using "CREATE TABLE' statement to create a new table
            //with the desired attributes
            
            sql = "CREATE TABLE logins ("
                + "user_id INT PRIMARY KEY AUTO_INCREMENT,"
                + "name VARCHAR(30) NOT NULL,"
                + "password VARCHAR (30) NOT NULL,"
                + "role VARCHAR (30) NOT NULL"    
                +    ")";
            
            stmt.executeUpdate(sql);
            
            
            return true;
            
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
                //do nothing
            }
            try{
                if(conn!=null)
                    conn.close();
                
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
            
        }//end try
        
        System.out.println("Goodbye!");

        return true;
        
    }//end constructor
    
}//end class