/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba.doble;
import java.sql.SQLException;
import java.util.Scanner;


/**
 *
 * @author ignac
 */
//ahisbciabcui
// ya funciono perrita 
//BERNARDOOO CONECTATEEEEEEEEEEE PUTOO
    public class PruebaDoble {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        //WELCOMING PROCESS
       CreateDatabase myDb = new CreateDatabase();
        myDb.CreateDatabase();
       LoginSystem myL = new LoginSystem();
       myL.LoginSystem();
    
       String fInput;
       String sInput;
    
        System.out.println("Please introduce your username:");
       Scanner mySC = new Scanner (System.in);
       fInput = mySC.nextLine();
   
        System.out.println("Introduce your password:");
       Scanner nSc = new Scanner (System.in);
       sInput = nSc.nextLine();
       myL.insertLogin(fInput, sInput);
        
       myL.verifyLogin(fInput, sInput);
     }
    }

