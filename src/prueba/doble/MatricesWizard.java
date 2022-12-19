/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba.doble;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import static prueba.doble.mathSystem3x3.E;
import static prueba.doble.mathSystem3x3.determinant3;
import static prueba.doble.mathSystem3x3.display3;
import static prueba.doble.mathSystem3x3.inverse3;
import static prueba.doble.mathSystem2x2.N;
import static prueba.doble.mathSystem2x2.determinant;
import static prueba.doble.mathSystem2x2.display;
import static prueba.doble.mathSystem2x2.inverse;

/**
 * https://github.com/iav2002/Matrices-Wizard.git
 * @author 
 * Ignacio Alarcon 2021357
 * Bernardo Gandara 2021283
 */

    public class MatricesWizard {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
       //WELCOMING PROCESS
       CreateDatabase myDb = new CreateDatabase(); 
       myDb.CreateDatabase();  //Creation of DataBase MatricesUsers
       LoginSystem myL = new LoginSystem();
       myL.LoginSystem(); //Creatin of our first table, where users and passwords will be stored
       Scanner mySC = new Scanner (System.in); //Main Scanner for user input
       
       //Creating Tables for Math
       MathTables myMT = new MathTables();
       myMT.equationsTable();
        


          
  //Main loop structured with Switches and cases in order to navigate through the menu     
   while (true) {
       System.out.println("///////////////////////");
       System.out.println("Welcome to MatricesWizard!");
       System.out.println("Press 1 to Login");
       System.out.println("Press 2 to Sign Up");
       System.out.println("Press 3 to Exit");
       System.out.println("///////////////////////");    

          
       int choice = mySC.nextInt(); // Read the user's input
       
          // Use a switch statement to execute the appropriate code for each option
        switch (choice) {
          case 1 -> {            
              //Introduce your credentials correctly, this part of the code will verify the password and return the role
              //In order to display a different menu depending if a user login or and admin
            System.out.println("Time to verify the login!");
          
             String fInput; //Where we'll store the user_name input
             String sInput; //Where we'll store the user_password input
           
             System.out.print("Please introduce your username:");             
             fInput = mySC.next();
                
             System.out.print("Introduce your password:");          
             sInput = mySC.next();
             myL.getPasswordForLogin(fInput,sInput); //Verification method that checks if user_name & user_password mathces
             int userId = myL.getUserId(fInput, sInput); //gets the user_id for later use, in the math process
             
            String role = myL.getRoleForLogin(fInput, sInput); 
            //Checks the role of the user after passing the verification process
      
         if (role.equals("admin")){ 
            //If the role is admin will display the following menu
        
         while (true) {
           //nested loop that is used to guide the user through the menu
             System.out.println("Welcome, " + fInput + "(you are logged as ADMIN ). Here are your menu options:");
                   System.out.println("1. - Modify your profile");
                   System.out.println("2. - Access a list of all other users in the system");
                   System.out.println("3. - Remove other users from the system.");
                   System.out.println("4. - Review the operations performed by other users");
                   System.out.println("5. - Back to MatricesWizard Menu!");
                  
        //user input validation to only accept numbers, to help user in case of an error
         
            int option1Choice;
            try {
                option1Choice = mySC.nextInt();
            } catch (InputMismatchException e) {
                // input is not an integer, display error message and continue
                System.out.println("Invalid input, please enter a number between 1 and 5.");
                mySC.nextLine();  // consume the invalid input
                continue;
            }
            //switch to handle different options for the admin  
            switch (option1Choice) {
                case 1 -> {   
                    // Method to change the original credentials of admin
                     Scanner aSc = new Scanner(System.in); 
                    System.out.println("Modify your information.");
                    System.out.print("Introduce your new username:");
                    String adminNewName;
                    adminNewName = aSc.nextLine();
                    System.out.print("Introduce your new password:");
                    String adminNewPass;
                    adminNewPass = aSc.nextLine();
                    adminTools myTools = new adminTools();
                    myTools.updateValues(adminNewName, adminNewPass); //calls method from admin tools that will update the credentials
                    System.out.println("Modification applied successfully");
                    System.out.println("////////////////");
                            
                    break; //exit this funciton
                }
                case 2 -> {
                    //This Method Calls every user that has Singed up previously.
                    adminTools otherTool = new adminTools();
                    System.out.println("//////////////");
                    otherTool.retrieveValuesFromTable("logins");
                    System.out.println("//////////////");
                    break; //exit this function
                }
                case 3 -> {
                    //Method to delete any user 
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
                    System.out.println("User deleted Succesfully, Remember to exit this menu type 0!");
                    break; //exit the function
                }
                case 4 -> {
                    //Using the id of the user, you can select of which one do you want to see the operations that were performedff
                  System.out.println("Below you can find the users. Select the id of the user which operations you'd like to see.");
                    adminTools otherTool = new adminTools();
                    otherTool.retrieveValuesFromTable("logins");
                    int userIDChoice = mySC.nextInt();
                   
                    otherTool.printEquationsForUser(userIDChoice);
                    
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
        }//closing while loop
        
            //In case role of user equals user, will follow this path the user
      } else if (role.equals("user")) {
            // Display menu for users
                                   
         while(true){     
             System.out.println("Welcome, " + fInput + "(you are logged as USER). Here are your menu options:");
                   System.out.println("1. Modify your profile");
                   System.out.println("2. Solve systems of linear equations of two and three variables");
                   System.out.println("3. See the system of equations computed and their solutions");
                   System.out.println("4. Back to MatricesWizard!");
          //Input user validation in order to catch any not valid input
           int option2Choice;
            try {
                option2Choice = mySC.nextInt();
            } catch (InputMismatchException e) {
                // input is not an integer, display error message and continue
                System.out.println("Invalid input, please enter a number between 1 and 4.");
                mySC.nextLine();  // consume the invalid input
                continue;
            }
      //switch to handle different options for the user
        switch (option2Choice) {
          case 1 -> {   
            // Method that will allow user to change his credentials 
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
         //Most relevant case where we open another loop, a short menu to solve different systems of linear equations.
         //Solved by matrices method! 
          case 2->{
              OUTER: //exterior menu (so we can comeback here)
              while (true) {
                  System.out.println("Calculator menu, only numbers 1- 3!");
                  System.out.println("1. Exit");
                  System.out.println("2. Solve 2 x 2");
                  System.out.println("3. Solve 3 x 3");
                  System.out.println("/////////////////");
                  
                  Scanner in = new Scanner(System.in);
                  Scanner choicer = new Scanner(System.in);
                  
                
                int choic; //input validation
                try {
                    choic = choicer.nextInt();
                } catch (InputMismatchException e) {
                    // input is not an integer, display error message and continue
                    System.out.println("Invalid input, please enter a number between 1 and 3.");
                    choicer.nextLine();  // consume the invalid input
                    continue;
                }
                  
                  
                  switch (choic) {
                      case 1 -> {
                          break OUTER; // break the Switch 
                      }
                      case 2 ->  {
                          //Math system  
                          int i, j , n, b; //variables used for the loops, and store values
                          String literales = "";
                            
                             n = N;  //Lenght of matrix and lenght of matrices used in the mathSystem methods
                              
                              //Array to store the inverse
                              float [][]inv = new float[n][n];
                              //Array to store the constants of the equations
                              int [][]conts = new int[n][1];
                              //Array to store the coeficients of the equations
                              int[][] matriz = new int[n][n];
                             
                              //takes any letter that will be used for the equation, has validation for each input. Only letters and cant be repeated!
                               for(i=0; i<n; i++)
                                {
                                    char literal = ' ';
                                    do
                                    {
                                        System.out.print("Type the letter of the first variable " + (i+1) + ": ");
                                        String input = in.nextLine().toLowerCase();
                                        if(input.length() != 1 || !Character.isLetter(input.charAt(0)) || literales.contains(input))
                                        {
                                            System.out.println("Invalid input. Please enter a single letter that has not been used before.");
                                        }
                                        else
                                        {
                                            literal = input.charAt(0);
                                        }
                                    } while(literal == ' ');
                                    literales += literal;
                                }                               
                                    
                               // Takes the coeficients and constans of our equations, also has validation for each input. Only numbers!
                               for(i=0; i<n; i++)
                                 {
                                     for(j=0; j<n; j++)
                                     {
                                         while(true)
                                         {
                                             try
                                             {
                                                 System.out.print("The  coeficient '" + literales.charAt(j) + "' of the ecuation " + (i+1) + ": ");
                                                 String input = in.nextLine();
                                                 matriz[i][j] = Integer.parseInt(input);
                                                 break; // input was valid, so exit the loop
                                             }
                                             catch(NumberFormatException e)
                                             {
                                                 System.out.println("Invalid input. Please enter a number.");
                                             }
                                         }
                                     }

                                     while(true)
                                     {
                                         try
                                         {
                                             System.out.print("The constant of the ecuation " + (i+1) + ": ");
                                             String input = in.nextLine();
                                             conts[i][0] = Integer.parseInt(input);
                                             break; // input was valid, so exit the loop
                                         }
                                         catch(NumberFormatException e)
                                         {
                                             System.out.println("Invalid input. Please enter a number.");
                                         }
                                     }
                                 }   
                          //takes the determinant, just as a plus. If there is not determinant of course there are no solutions for our system of equations      
                         System.out.println("Determinant of the matrix is : " + determinant(matriz, n));
                              //checks if the matriz has and inverse, if not the ecuation cant be performed
                             //In case the inverse doesn't exist will display a helpful message.
                              if (inverse(matriz, inv));
                              display(inv);
                              //if there is an inverse it will be multiplied by the conts and is the result
                              // INV * CONTS = RESULT
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
                                //Print the system of ecuations with out the letters
                              System.out.println("Thats how your linear ecuation looks without the variables!");
                              for( i=0; i<n; i++)
                              {
                                  for( j=0; j<n; j++)
                                  {
                                      System.out.print(" "+matriz[i][j]);
                                  }
                                  System.out.print("  =  "+ conts[i][0]);
                                  System.out.println();
                              }             
                            
                              //Gets the system of equation in a simple way to be able to store it in our DB
                              System.out.println("Copy the system presented above but ith letters please!!");
                              String equations = MathTables.getEquations(in, n); 
                              //method to get the ecuations, the parameters is the lenght of the number of equations and also a scanner
                             
                            
                             //print the solution of the system
                             System.out.println("The product is:");
                              
                               for( b=0; b<n; b++)
                              {
                                  // x =  solucion
                                  // y = solucion 
                                  // z = solucion
                               
                                  String solucion = (literales.charAt(b) + " = " + result[b][0] + " ");
                                  //Method to store the equations, solutions linked to the userId
                                  myMT.insertEquation(userId, equations , solucion);
                                  System.out.println(literales.charAt(b) + " = " + result[b][0] + " ");
                             
                              }   
                        break; //exit the case 
                      }
                      
                      case 3 ->    {
                            //Is the same as case 2 but modified to be able to solve system of 3 equations 
                            //using matrices method 
                            int i, j , n, b;
                              String literales = "";
                              
                              n = E;
                              //Lenght of matrix and for methods
                              //Array to store the inverse
                              float [][]inv = new float[n][n];
                              //Array to store the constants of the ecuations
                              int [][]conts = new int[n][1];
                              //Array to store the coeficients of the ecuations
                              int[][] matriz = new int[n][n];
                         
                  //takes any letter that will be used for the equation, has validation for each input. Only letters and cant be repeated!
                 
                   for(i=0; i<n; i++)
                        {
                            char literal = ' ';
                            do
                            {
                                System.out.print("Type the letter of the first variable " + (i+1) + ": ");
                                String input = in.nextLine().toLowerCase();
                                if(input.length() != 1 || !Character.isLetter(input.charAt(0)) || literales.contains(input))
                                {
                                    System.out.println("Invalid input. Please enter a single letter that has not been used before.");
                                }
                                else
                                {
                                    literal = input.charAt(0);
                                }
                            } while(literal == ' ');
                            literales += literal;
                        }           
                              
                // Takes the coeficients and constans of our equations, also has validation for each input. Only numbers!         
                 for(i=0; i<n; i++)
                        {
                        for(j=0; j<n; j++)
                        {
                        while(true)
                            {
                                try
                                {
                                    System.out.print("The  coeficient '" + literales.charAt(j) + "' of the ecuation " + (i+1) + ": ");
                                    String input = in.nextLine();
                                    matriz[i][j] = Integer.parseInt(input);
                                    break; // input was valid, so exit the loop
                                }
                                catch(NumberFormatException e)
                                {
                                    System.out.println("Invalid input. Please enter a number.");
                                }
                            }
                        }

                    while(true)
                        {
                            try
                            {
                                System.out.print("The constant of the ecuation " + (i+1) + ": ");
                                String input = in.nextLine();
                                conts[i][0] = Integer.parseInt(input);
                                break; // input was valid, so exit the loop
                            }
                            catch(NumberFormatException e)
                            {
                                System.out.println("Invalid input. Please enter a number.");
                            }
                        }
                    }      
                            //takes the determinant, just as a plus. If there is not determinant of course there are no solutions for our system of equations      
                                                      
                              System.out.println("Determinant of the matrix is : " + determinant3(matriz, n));
                              System.out.println("");
                              System.out.println("Inverse is:");
                              //checks if the matriz has and inverse, if not the ecuation cant be performed
                              if (inverse3(matriz, inv));
                              display3(inv);
                              //if there is an inverse its multiplied by the conts and is the result
                              // INV * CONTS = RESULT
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
                              }             //Print the system of ecuations with out the letters
                              System.out.println("Thats how your linear ecuation looks without the variables loquita");
                              for( i=0; i<n; i++)
                              {
                                  for( j=0; j<n; j++)
                                  {
                                      System.out.print(" "+matriz[i][j]);
                                  }
                                  System.out.print("  =  "+ conts[i][0]);
                                  System.out.println();
                              }             //print the solution of the system
                              System.out.println("Copy the system presented above but ith letters please!!");
                              String equations = MathTables.getEquations(in, n);
                             //method to get the ecuations, the parameters is the lenght of the number of equations and also a scanner
                             
                              System.out.println("The product is:");
                              for( b=0; b<n; b++)
                              {
                                  // x =  solucion
                                  // y = solucion (no importa si es 2x2 3x3 4x4 5x5
                                  // z = solucion
                                  System.out.println(literales.charAt(b) + " = " + result[b][0] + " ");
                                  String solucion = (literales.charAt(b) + " = " + result[b][0] + " ");
                                  //Method to store the equations, solutions linked to the userId
                                  myMT.insertEquation(userId, equations, solucion);
                              
                                  
                              }    break;  //End of the case 3           
                      }                     
                      default -> System.out.println("Invalid choice, only numbers 1 - 3 please"); //helpful message
                  } // close the switch
              }// close the nested loop
        }//close case 2
         
          case 3->{
              //Method that allows user to watch the solved equation perfomed by itself
            usertools aTool = new usertools();
            System.out.println("////////////////////");  
            aTool.viewEquations(fInput, sInput);
             System.out.println("//////////////////");
              break;
              
          }
       
          case 4->{
           break; //Breaks the switch
          
          }
        default -> {
                    // input is not between 1 and 5, display menu again
                    System.out.println("Invalid choice, please choose a number between 1 and 4.");
                }
         
         }
            if (option2Choice == 4) {
                break;
            }
         } //end of loop        
            
        }// end of else if
        
     }//End of case 1
        
            case 2 -> { 
                //SingUp Method to allows user to registers themselves
                String fInput;
                String sInput;
                
                System.out.print("Please introduce your username:");             
                fInput = mySC.next();
                
                System.out.print("Introduce your password:");          
                sInput = mySC.next();
                
                myL.SignUP(fInput, sInput);
                
                System.out.println("Your user was succesfully singed up!");
                break;
               }
            case 3 -> { //quit programm 
               if (choice == 3) {
                System.out.println("Quitting the program...");
                return;      
               }
            }
         
         }

       }// End of main loop   
    }//main end
  }// class end

