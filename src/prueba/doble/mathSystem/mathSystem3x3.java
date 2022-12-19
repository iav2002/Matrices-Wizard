/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba.doble;

/**
 *
 * @author ignacioalarconvarela
 */
public class mathSystem3x3 {
    static int E = 3;
   //final lenght of the matrices
   
    static void getCofactor(int matriz[][], int temp[][],
                            int p, int q, int n)
    {
       
        int i = 0, j = 0;
 
        // Looping for each element of the matrix
        
        for (int row = 0; row < n; row++)
        {
            for (int col = 0; col < n; col++)
            {
                if (row != p && col != q)
                {
                    temp[i][j++] = matriz[row][col];
                    if (j == n - 1)
                    {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }
 
    // Recursive function for finding determinant of matrix. n is current dimension of matriz[][]
    static int determinant3(int matriz[][], int n)
    { 
       
        int D = 0; // Initialize result
 
        // Base case : if matrix contains single
        // element
        if (n == 1)
            return matriz[0][0];
 
        // To store cofactors
        int temp[][] = new int[E][E];
 
        // To store sign multiplier
        int sign = 1;
 
        // Iterate for each element of first row
        for (int f = 0; f < n; f++)
        {
            // Getting Cofactor of matriz[0][f]
            getCofactor(matriz, temp, 0, f, n);
            D += sign * matriz[0][f]
                 * determinant3(temp, n - 1);
 
            // terms are to be added with
            // alternate sign
            sign = -sign;
        }
 
        return D;
    }
    static void adjoint(int matriz[][],int [][]adj)
{
   	
     if (E == 1)
	
        {
		adj[0][0] = 1;
		return;
	}

	// temp is used to store cofactors of E[][]
	int sign = 1;
	int [][]temp = new int[E][E];

	for (int i = 0; i < E; i++)
	{
		for (int j = 0; j < E; j++)
		{
			// Get cofactor of E[i][j]
			getCofactor(matriz, temp, i, j, E);

			// sign of adj[j][i] positive if sum of row
			// and column indexes is even.
			sign = ((i + j) % 2 == 0)? 1: -1;

			// Interchanging rows and columns to get the
			// transpose of the cofactor matrix
			adj[j][i] = (sign)*(determinant3(temp, E-1));
		}
	}
}
// Function to calculate and store inverse, returns false if matrix is singular

        static boolean inverse3(int matriz[][], float [][]inverse)
        {
                // Find determinant of matriz[][]

                int det = determinant3(matriz, E);
                if (det == 0)
                {
                    System.out.println("///////////////////////////////////////////////////////////");
                    System.out.print("Is not possible to find its inverse in this matrix, therefore there is not solution for this System of equations");
                    System.out.println("///////////////////////////////////////////////////////////");
                   return false;
                }

                // Find adjoint
                int [][]adj = new int[E][E];
                adjoint(matriz, adj);

                // Find Inverse using formula "inverse(E) = adj(E)/det(E)"
                for (int i = 0; i < E; i++)
                        for (int j = 0; j < E; j++)
                                inverse[i][j] = adj[i][j]/(float)det;

                return true;
        }




       //Method to show the inverse
        static void display3(float matriz[][])
        {

            for (int i = 0; i < E; i++)
                {
                     for (int j = 0; j < E; j++)

                        System.out.printf("%.2f ", matriz[i][j]);
                         System.out.println();

                }
        }
}
    
    
    

