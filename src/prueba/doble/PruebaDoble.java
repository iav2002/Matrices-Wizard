/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba.doble;
import java.util.Scanner;

import static prueba.doble.dosPorDos.adjoint;
import static prueba.doble.dosPorDos.determinant;
import static prueba.doble.dosPorDos.display;
import static prueba.doble.dosPorDos.inverse;
import static prueba.doble.dosPorDos.userInput;

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
    public static void main(String[] args) {
        
        //WELCOMING PROCESS
        	
        
        int i, j,  n ;

        float termino;
        String literales = "";
        char literal;
        Scanner in = new Scanner(System.in);
        Scanner myKb = new Scanner(System.in);
         
       n = userInput();
        int[][] matriz = new int[n][n];
        int [][]adj = new int[n][n]; // To store adjoint of A[][]
	float [][]inv = new float[n][n];
        for(i=0; i<n; i++)
        {
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
                System.out.print("Inter the  coeficient '" + literales.charAt(j) + "' of the ecuation " + (i+1) + ": ");
                matriz[i][j] = Integer.parseInt(in.nextLine());
            }
        }
 
        System.out.print("Determinant " + "of the matrix is : " + determinant(matriz, n));
    
    System.out.println("Input matrix is :\n");
	display(matriz);

	System.out.print("\nThe Adjoint is :\n");
	adjoint(matriz, adj);
	display(adj);

	System.out.print("\nThe Inverse is :\n");
	if (inverse(matriz, inv))
		display(inv);

     }
    }

