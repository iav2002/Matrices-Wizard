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
      Scanner mySC = new Scanner (System.in);
      
       
       
        
       
     while (true) {
         System.out.println("///////////////////////");
         System.out.println("Welcome to MatricesWizard!");
         System.out.println("Press 1 to Login");
         System.out.println("Press 2 to Sing Up");
         System.out.println("Press 3 to Exit");
         System.out.println("///////////////////////");
         

          // Read the user's input
          int choice = mySC.nextInt();

          // Use a switch statement to execute the appropriate code for each option
          switch (choice) {
            case 1 -> {
                //login 
                //verificar que un usuario correcto 
                //USER O ADMIN ??? 
                //admin o no admin desplegar dos disintos menu de opcines 
                System.out.println("Time to verify the login!");
                String sInput;
                sInput = mySC.next();
                myL.getPasswordForLogin(sInput);
                
                
               }

            case 2 -> { //singup
                String fInput;
                String sInput;
                
                System.out.print("Please introduce your username:");             
                fInput = mySC.next();
                
                System.out.print("Introduce your password:");          
                sInput = mySC.next();
                
                myL.SignUP(fInput, sInput);
                
               }
            case 3 -> { //quit programm 
               if (choice == 3) {
                System.out.println("Quitting the program...");
                return;      
               }
            }
         
         }
             
            
     
       }
         
    
     }
    
    }
          

 
          

   
    

