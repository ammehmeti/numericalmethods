package Matrica;

import java.util.Scanner;


public class EnkriptimiShkronjNumer {
	
// Numrat jane gjeneruar ne baze te formules (n(n+1))/2
	public static int shkronjeNeNumer(String a)
	{
		String lower = a.toLowerCase();
		int nr = 0;
		switch(lower)
		{
		case "a":
			nr = 1;
			break;
		case "b":
			nr = 3;
			break;
		case "c":
			nr = 6;
			break;
		case "d":
			nr = 10;
			break;
		case "e":
			nr = 15;
			break;
		case "f":
			nr = 21;
			break;
		case "g":
			nr = 28;
			break;
		case "h":
			nr = 36;
			break;
		case "i":
			nr = 45;
			break;
		case "j":
			nr = 55;
			break;
		case "k":
			nr = 66;
			break;
		case "l":
			nr = 78;
			break;
		case "m":
			nr = 91;
			break;
		case "n":
			nr = 105;
			break;
		case "o":
			nr = 120;
			break;
		case "p":
			nr = 136;
			break;
		case "q":
			nr = 153;
			break;
		case "r":
			nr = 171;
			break;
		case "s":
			nr = 190;
			break;
		case "t":
			nr = 210;
			break;
		case "u":
			nr = 231;
			break;
		case "v":
			nr = 253;
			break;
		case "w":
			nr = 276;
			break;
		case "x":
			nr = 300;
			break;
		case "y":
			nr = 325;
			break;
		case "z":
			nr = 351;
			break;
					
		}
	return	nr;
	}
	
	public static String numerNeShkronje(double n)
	{	int num = (int)(n);
		String string = "";
		switch(num)
		{
		case 1:
			string = "a";
			break;
		case 3:
			string = "b";
			break;
		case 6:
			string = "c";
			break;
		case 10:
			string = "d";
			break;
		case 15:
			string = "e";
			break;
		case 21:
			string = "f";
			break;
		case 28:
			string = "g";
			break;
		case 36:
			string = "h";
			break;
		case 45:
			string = "i";
			break;
		case 55:
			string = "j";
			break;
		case 66:
			string = "k";
			break;
		case 78:
			string = "l";
			break;
		case 91:
			string = "m";
			break;
		case 105:
			string = "n";
			break;
		case 120:
			string = "o";
			break;
		case 136:
			string = "p";
			break;
		case 153:
			string = "q";
			break;
		case 171:
			string = "r";
			break;
		case 190:
			string = "s";
			break;
		case 210:
			string = "t";
			break;
		case 231:
			string = "u";
			break;
		case 253:
			string = "v";
			break;
		case 276:
			string = "w";
			break;
		case 300:
			string = "x";
			break;
		case 325:
			string = "y";
			break;
		case 351:
			string = "z";
			break;
			
		}
	return string;	
	}
	
	public static void main(String arg[]) 
    {
		EnkriptimiShkronjNumer sn = new EnkriptimiShkronjNumer();
        Scanner input = new Scanner(System.in);
        System.out.println(" Dimensioni i matrices: ");
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
        //Kjo pjese e kodit ben paraqitja e matrices
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
        //kthimi i elementeve shkronja ne numera
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
        System.out.println("Matrica inverse eshte: ");
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

