/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba.doble;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import static prueba.doble.mathSystem.N;
import static prueba.doble.mathSystem.determinant;
import static prueba.doble.mathSystem.display;
import static prueba.doble.mathSystem.inverse;


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
       
       //creating tables for math
       MathTables myMT = new MathTables();
       myMT.createOperationsTable();
//       myMT.createEquationsTable();
//       myMT.createVarTable();
          
       
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
                     Scanner aSc = new Scanner(System.in);
                    System.out.println("Modify your information.");
                    System.out.println("Introduce your new username:");
                    String adminNewName;
                    adminNewName = aSc.nextLine();
                    System.out.println("Introduce your new password:");
                    String adminNewPass;
                    adminNewPass = aSc.nextLine();
                    adminTools myTools = new adminTools();
                    myTools.updateValues(adminNewName, adminNewPass);
                    System.out.println("Modification applied successfully");
                    System.out.println("press 5 to go back to the previous menu");
                            
                    break; //exit this funciton
                }
                case 2 -> {
                    //crear metodo para ver los usuarios sign upeados (llamar desde login system)
                    adminTools otherTool = new adminTools();
                    otherTool.retrieveValuesFromTable("logins");
                    System.out.println("press 5 to go back to the previous menu");
                    break;
                }
                case 3 -> {
                    //poder eliminar usuarios 
                    System.out.println("What user would you like to delete? Choose by using the id. Enter 0 to cancel");
                    adminTools otherTool = new adminTools();
                    int rowSelected = 0;
                    do{
                        otherTool.retrieveValuesFromTable("logins"); 
                        Scanner nSc = new Scanner(System.in);
                        rowSelected = nSc.nextInt();
                    otherTool.deleteValuesFromTable(rowSelected);
                    }while(rowSelected != 0);
                    //otherTool.retrieveValuesFromTable("logins");
                    System.out.println("press 5 to go back to the previous menu");
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
               Scanner aSc = new Scanner(System.in);
                    System.out.println("Modify your information.");
                    System.out.println("Introduce your new username:");
                    String userNewName;
                    userNewName = aSc.nextLine();
                    System.out.println("Introduce your new password:");
                    String userNewPass;
                    userNewPass = aSc.nextLine();
                    usertools myTools = new usertools();
                    myTools.updateValues(userNewName, userNewPass);
                    System.out.println("Modification applied successfully");
                    System.out.println("press 4 to go back to the previous menu"); 
                    break; //exit this funciton
              
          }
         
          case 2->{
              //Math
              
              int i, j , n, b;
                String literales = "";
                char literal;
                //input de todo
                Scanner in = new Scanner(System.in);
                //define longitud de ecuacion, para los metodos y matriz 
                n = N;
                //matriz para guardar la inversa
                float [][]inv = new float[n][n];
                //matriz para guardar las constantes
                int [][]conts = new int[n][1];
                //matriz para guardar los coeficientes de las variables
                int[][] matriz = new int[n][n];

            for(i=0; i<n; i++)
                {
                    //saca las letras de las variables 
                    System.out.print("Type the letter of the first variable " + (i+1) + ": ");
                    do {
                        literal = in.nextLine().toLowerCase().charAt(0);
                    } while(!Character.isLetter(literal) || literales.contains(String.valueOf(literal)));
                    literales += literal;
                }
        
             for(i=0; i<n; i++)
                {
                    for(j=0; j<n; j++)
                    {
                         //Saca los coeficientes y los guarda en matriz
                        System.out.print("The  coeficient '" + literales.charAt(j) + "' of the ecuation " + (i+1) + ": ");
                        matriz[i][j] = Integer.parseInt(in.nextLine());
                    }
                     //Saca las constantes y las guarda en conts
                    System.out.print("The constant of the ecuation " + (i+1) + ": ");
                    conts[i][0] = Integer.parseInt(in.nextLine());
                }
        
                //saca la determinante, pero es lo podemos borrar, sirve sin esto 
                System.out.println("Determinant of the matrix is : " + determinant(matriz, n));


                //chequear si la matriz tiene inversa, si no tiene bota error de no tener inversa y acaba en 0 NO ERROR
                if (inverse(matriz, inv));
                display(inv);
        
                //una vez que vemos que HAY inversa, esta parte hace la multiplicacion de INVERSA * CONSTANTES 
                // inv * conts = resultado
                float result[][] = new float [n][1];
                for ( i = 0; i < n; i++) 
                {
                    for ( j = 0; j < 1; j++) 
                    {
                        for (int k = 0; k < n; k++)
                        {	 
                            result[i][j] = result[i][j] + inv[i][k] * conts[k][j];
                        }
                    }
                }

                //imprime en orden lo que el usuario puso pero no pude poner la x y, creo que no se puede tipo que se vea bien
                System.out.println("Thats how your linear ecuation looks without the variables loquita");
                 for( i=0; i<n; i++)
                {
                    for( j=0; j<n; j++)
                    {
                        System.out.print(" "+matriz[i][j]);
                    } 
                    System.out.print("  =  "+ conts[i][0]);
                    System.out.println();
                }

             //Se imprime las soluciones del sistema de ecuaciones
                System.out.println("The product is:");
                for( b=0; b<n; b++)
                {   
                    // x =  solucion
                    // y = solucion (no importa si es 2x2 3x3 4x4 5x5 
                    // z = solucion
                    System.out.println(literales.charAt(b) + " = " + result[b][0] + " ");

                }
                         
              
          }//close case 2
         
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

