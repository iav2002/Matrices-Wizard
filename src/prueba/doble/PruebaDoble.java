/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba.doble;
import java.util.Scanner;
import static prueba.doble.dosPorDos.N;
import static prueba.doble.dosPorDos.determinant;
import static prueba.doble.dosPorDos.inverse;


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
            System.out.print("The constant of the ecuation" + (i+1) + ": ");
            conts[i][0] = Integer.parseInt(in.nextLine());
        }
        
        //saca la determinante, pero es lo podemos borrar, sirve sin esto 
        System.out.println("Determinant of the matrix is : " + determinant(matriz, n));
        
    
	//chequear si la matriz tiene inversa, si no tiene bota error de no tener inversa y acaba en 0 NO ERROR
	if (inverse(matriz, inv));

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
       
    }
    
    
    }

