/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba.doble;
import java.sql.SQLException;
import java.util.InputMismatchException;
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
       System.out.println("Press 2 to Sign Up");
       System.out.println("Press 3 to Exit");
       System.out.println("///////////////////////");    

          // Read the user's input
       int choice = mySC.nextInt();
       
          // Use a switch statement to execute the appropriate code for each option
        switch (choice) {
          case 1 -> {            
             //que si el usuario quiere salir 
             //USER O ADMIN ??? 
            System.out.println("Time to verify the login!");
          
             String fInput;
             String sInput;
            
             System.out.print("Please introduce your username:");             
             fInput = mySC.next();
                
             System.out.print("Introduce your password:");          
             sInput = mySC.next();
             myL.getPasswordForLogin(fInput,sInput);
   
            String role = myL.getRoleForLogin(fInput, sInput); //chequea que role tiene el usuario que acaba de logearse
      
         if (role.equals("admin")) {
            // Display menu for admins
                 System.out.println("Welcome, admin! Here are your menu options:");
                   System.out.println("1. - Modify your profile");
                   System.out.println("2. - Access a list of all other users in the system");
                   System.out.println("3. - Remove other users from the system.");
                   System.out.println("4. - Review the operations performed by other users");
                  System.out.println("5. - Return to previous menu");
         
         while (true) {
            int option1Choice;
            try {
                option1Choice = mySC.nextInt();
            } catch (InputMismatchException e) {
                // input is not an integer, display error message and continue
                System.out.println("Invalid input, please enter a number between 1 and 5.");
                mySC.nextLine();  // consume the invalid input
                continue;
            }
                    switch (option1Choice) {
                case 1 -> {   
                    // crear metodo para poder modificar Admin
                    System.out.println("hola");
                }
                case 2 -> {
                    //crear metodo para ver los usuarios sign upeados (llamar desde login system)
                }
                case 3 -> {
                    //poder eliminar usuarios 
                }
                case 4 -> {
                    //ver operaciones hechas por un usuario
                }
                case 5 -> {
                    //return to last menu
                    System.out.println("Back to MatricesWizard Menu!"); 
                    break;
                }
                default -> {
                    // input is not between 1 and 5, display menu again
                    System.out.println("Invalid choice, please choose a number between 1 and 5.");
                }
            }

            // exit loop if user chose option 5
            if (option1Choice == 5) {
                break;
            }
}
        
            // ...
      } else if (role.equals("user")) {
            // Display menu for users
                   System.out.println("Welcome, user! Here are your menu options:");
                   System.out.println("1. Modify your profile");
                   System.out.println("2. Solve systems of linear equations of two and three variables");
                   System.out.println("3. See the system of equations computed and their solutions");
                   System.out.println("4. Exit");
            
                    
                   
         while(true){         
          int option2Choice;
            try {
                option2Choice = mySC.nextInt();
            } catch (InputMismatchException e) {
                // input is not an integer, display error message and continue
                System.out.println("Invalid input, please enter a number between 1 and 4.");
                mySC.nextLine();  // consume the invalid input
                continue;
            }
        switch (option2Choice) {
          case 1 -> {   
            // crear metodo para poder modificar Credenciales del user
            
              
          }
         
          case 2->{
              //Toda la parte de matematicas va aca
              
              
              
              
              
              
              
              
              
              
          }
         
          case 3->{
              //Ver los sistemas resueltos por el usuario en el que estamos logeados
              
              
          }
       
          case 4->{
           break;
          
          }
        default -> {
                    // input is not between 1 and 5, display menu again
                    System.out.println("Invalid choice, please choose a number between 1 and 4.");
                }
         
         }
            if (option2Choice == 4) {
                break;
            }
         }         
            // ...
        }
        
     }// final de CASE 1 de Matrices Wizzard
        
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

       }//del primer while    
     
  
  
  }//llave del metodo main 
  }// corchete de la clase
          

 
          

   
    

