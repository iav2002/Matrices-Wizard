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
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 *
 * @author bernardogandara
 */
public class DatabaseDataInput {
    
    //JDBC driver name and datbase URL
    static final String JDBC_DRIVER = "jdbc:mysql://localhost:3306/?user=root";
    static final String DB_URL = "jdbc:mysql://localhost/";
    
    //Database credentials
    static final String USER = "root";
    static final String PASS = "root";
    String userInput1;
    String userInput2;
    static final String role = "user";
    
    public boolean InputEater(){
     try{   
        Scanner mySc = new Scanner(System.in);
        userInput1 = mySc.nextLine();
     }catch(Exception e){
         System.out.println("Wot?");
     }
     try{
         Scanner anotherSc = new Scanner(System.in);
         userInput2 = anotherSc.nextLine();
         
     }catch(Exception e){
         System.out.println("No way bruh!");
     }
        
        return true;
    }
    
    
    public boolean DatabaseInput() throws SQLException{
        
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        
        String sql = "INSERT INTO accounts (user_id, name, password, role)"
                + "VALUES (%d,\"%s\",\"%s\",\"%s\")";
             
        PreparedStatement stmt = conn.prepareStatement(sql);
        
        stmt.setInt(0, 0);
        stmt.setString(1, userInput1);
        stmt.setString(2, userInput2);
        stmt.setString(3, role);
             
        return true;    
    }
    
}
