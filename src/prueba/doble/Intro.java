/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.doble;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author bernardogandara
 */
public class Intro {
    
    //VARIABLES FOR ADMIN LOG IN
    private String adminName = "berni"; //username of the admin
    private String password = "CCT";    //password of the admin
    Scanner in = new Scanner(System.in);    //all these scanners are for input of username and password
    Scanner anIn = new Scanner(System.in);
    Scanner arIn = new Scanner(System.in);
    Scanner opChosen = new Scanner(System.in);
    Scanner rm = new Scanner(System.in);    //for removing users
    
    //VARIABLES FOR USER LOG IN
    Map<String, String> users = new HashMap<String, String>();   //to keep a list of users with username and password 
    //Following scanners are for manipulating users in the list
    Scanner uI = new Scanner(System.in);    
    Scanner uP = new Scanner(System.in);
    private String userName;    //regular user username
    private String userPassword;    //regular user password
    

    public int Intro() {
        //FIRST MESSAGES INTRODUCTION
        System.out.println("Welcome to the Matrices Wizzard");
        System.out.println("Please select:\n"
                + "1. Admin Log In\n"
                + "2. User Log In");
        
        try{
            int usIn = in.nextInt();
            if(usIn == 1){
                
                System.out.println("Hello, please introduce your username and password");
                System.out.println("username:");
                String nameIn = anIn.nextLine();
                
                if(!nameIn.matches(adminName)){
                    System.out.println("Access Denied. Wrong username.");
                }else{
                    System.out.println("Password:");
                    String passIn = arIn.nextLine();
                    if(!passIn.matches(password)){
                        System.out.println("Access Denied. Wrong password");
                    }else{
                        System.out.println("Welcome " + adminName + ", we were waiting for you.");
                        System.out.println("What action would you like to perform?");
                        System.out.println("1. Modify user, password");
                        System.out.println("2. Remove users from the system");
                        System.out.println("3. See user list");
                        System.out.println("4. See previous operations done by users");
                        int op = opChosen.nextInt();
                        if(op == 1){
                            System.out.println("Introduce your new username:");
                            nameIn = anIn.nextLine();
                            System.out.println("Introduce your new password:");
                            passIn = arIn.nextLine();
                            adminName = nameIn;
                            password = passIn;
                            System.out.println("Your new username is " + adminName + " and your new password is " + password);
                        }else if(op == 2){
                            System.out.println("What user would you like to remove?");
                            System.out.println(users.keySet());
                            String userRemoved = rm.nextLine();
                            if(users.containsKey(userRemoved)){
                                users.remove(userRemoved);
                                System.out.println(userRemoved + " has been removed");
                                System.out.println("The users are now " + users.keySet());
                            }else{
                                System.out.println("User not found");
                            }
                        }else if (op == 3){
                            System.out.println(users);
                        }else if (op == 4){
                            System.out.println("The previous operatios are ");
                        }
                    
                    }
                }
                
            }else if(usIn == 2){
                System.out.println("Please introduce your username: ");
                String userName = uI.nextLine();
                System.out.println("Introduce your password: ");
                String userPass = uP.nextLine();
                
                users.put(userName, userPass);  //store the user info in the HashMap
                System.out.println("Your account has been succesfully created as " + userName + " and password " + userPass);
                System.out.println("What action would you like to perform?");
                System.out.println("1. Modify user, password");
                System.out.println("2. Perform Matrices Wizzard");                
                
            }else{
                System.out.println("Wrong number. The input should be 1 or 2");
            }
            
        }catch(Exception e){
            
            System.out.println("Please introduce a number");
            return 0;
        }
        return 1;
    }    
    
}
