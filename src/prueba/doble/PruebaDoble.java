/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba.doble;
import java.util.Scanner;
import static prueba.doble.dosPorDos.N;

import static prueba.doble.dosPorDos.adjoint;
import static prueba.doble.dosPorDos.determinant;
import static prueba.doble.dosPorDos.display;
import static prueba.doble.dosPorDos.displayComEcu;
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
        
        int i, j , n;
        String literales = "";
        char literal;
        Scanner in = new Scanner(System.in);
        
        n = N;
        
        
	float [][]inv = new float[n][n];
        int [][]conts = new int[n][1];
        int[][] matriz = new int[N][N+1];
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
             System.out.print("Ingrese la constante de la ecuaci\242n " + (i+1) + ": ");
            conts[i][0] = Integer.parseInt(in.nextLine());
        }
        
        float result[][] = new float [n][1];
        for (int e = 0; e < n; e++) 
        {
            for (int w = 0; w < 1; w++) 
            {
                for (int k = 0; k < n; k++)
                {	 
                    result[e][w] = result[e][w] + inv[e][k] * conts[k][e];
                }
            }
        }
        
        System.out.println("The product is:");
        for(int b=0; b<n; b++)
        {
            System.out.println(result[b][0] + " ");
        }
       
        
        
        System.out.print("Determinant " + "of the matrix is : " + determinant(matriz, n));
    
//        System.out.println("Input matrix is :\n");
//	displayComEcu(matriz);

	System.out.print("\nThe Inverse is :\n");
	if (inverse(matriz, inv))
		display(inv);


	
    
    }
    
    
    }

