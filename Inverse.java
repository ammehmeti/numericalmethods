package Matrica;

import java.util.Scanner;

public class Inverse {

    public static void main(String arg[]) 
    {
    	ShkronjNumer sn = new ShkronjNumer();
        Scanner input = new Scanner(System.in);
        System.out.println("Sheno dimensionin e matrices: ");
        int n = input.nextInt();
        String a[][]= new String[n][n];
        System.out.println("Sheno shkronjat elemente te matrices: ");
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {	
            	a[i][j] = input.next();
            }	        
        }
        //Paraqitja e matrices
        System.out.println("Matrica me shkronja");
        for(int i=0; i<n; i++)
        {
        	System.out.print("");
            for(int j=0; j<n; j++)
            {	
            	System.out.print(" " + a[i][j]);
            }	 
            System.out.println();
        }
        //kthimi i elementeve shkronja ne numer
        double [][] nr = new double[n][n];
        for(int i=0; i<n; i++)
        {
        	for(int j=0; j<n; j++)
        	{
        		nr[i][j] = sn.shkronjeNeNumer(a[i][j]);
        	}
        }
        //paraqitja e matrices me numra
        System.out.println("Matrica me numra");
        for(int i=0; i<n; i++)
        {
        	System.out.print("");
            for(int j=0; j<n; j++)
            {	
            	System.out.print(" " + nr[i][j]);
            }	 
            System.out.println();
        }
        //matrica inverse
        double d[][] = invert(nr); 
        //paraqitja e matrices inverse 1
        System.out.println("Inversi i matrices eshte: ");
        for (int i=0; i<n; ++i) 
        {
            for (int j=0; j<n; ++j)
            {
                System.out.print(d[i][j]+"  ");
            }
            System.out.println();
        }
        
        //matrica inverse e matrices inverse
        double d2[][] = invert(d);
        //paraqitja e matrices inverse
        System.out.println("Inversi i matrices eshte: ");
        for (int i=0; i<n; ++i) 
        {
            for (int j=0; j<n; ++j)
            {
                System.out.print(d2[i][j]+"  ");
            }
            System.out.println();
        }
        //kthimi i elementeve numer ne shkronja
        String[][] character = new String[n][n];
        for(int i=0; i<n; i++)
        {
        	for(int j=0; j<n; j++)
        	{
        		character[i][j] = sn.numerNeShkronje(d2[i][j]);
        	}
        } 
        //paraqitja e matrices fillestare
        System.out.println("Matrica me shkronja");
        for(int i=0; i<n; i++)
        {
        	System.out.print("");
            for(int j=0; j<n; j++)
            {	
            	System.out.print(" " + character[i][j]);
            }	 
            System.out.println();
        }        
        
        input.close();
    }	
 
    public static double[][] invert(double nr[][]) 
    {
        int n = nr.length;
        double x[][] = new double[n][n];
        double b[][] = new double[n][n];
        int index[] = new int[n];
        for (int i=0; i<n; ++i) 
            b[i][i] = 1;
 
        gaussian(nr, index);

        for (int i=0; i<n-1; ++i)
            for (int j=i+1; j<n; ++j)
                for (int k=0; k<n; ++k)
                    b[index[j]][k]
                    	    -= nr[index[j]][i]*b[index[i]][k];
 
        for (int i=0; i<n; ++i) 
        {
            x[n-1][i] = b[index[n-1]][i]/nr[index[n-1]][n-1];
            for (int j=n-2; j>=0; --j) 
            {
                x[j][i] = b[index[j]][i];
                for (int k=j+1; k<n; ++k) 
                {
                    x[j][i] -= nr[index[j]][k]*x[k][i];
                }
                x[j][i] /= nr[index[j]][j];
            }
        }
        return x;
    }
 
    public static void gaussian(double nr[][], int index[]) 
    {
        int n = index.length;
        double c[] = new double[n];

        for (int i=0; i<n; ++i) 
            index[i] = i;

        for (int i=0; i<n; ++i) 
        {
            double c1 = 0;
            for (int j=0; j<n; ++j) 
            {
                double c0 = Math.abs(nr[i][j]);
                if (c0 > c1) c1 = c0;
            }
            c[i] = c1;
        }

        int k = 0;
        for (int j=0; j<n-1; ++j) 
        {
            double pi1 = 0;
            for (int i=j; i<n; ++i) 
            {
                double pi0 = Math.abs(nr[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1) 
                {
                    pi1 = pi0;
                    k = i;
                }
            }

            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i=j+1; i<n; ++i) 	
            {
                double pj = nr[index[i]][j]/nr[index[j]][j];

                nr[index[i]][j] = pj;

                for (int l=j+1; l<n; ++l)
                    nr[index[i]][l] -= pj*nr[index[j]][l];
            }
        }
    }
}
