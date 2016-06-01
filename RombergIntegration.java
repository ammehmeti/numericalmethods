package EkstrapolimiRichardsonit;

import java.util.*;

public class RombergIntegration
{  
	//Funksioni 
    public static double f(double x)
    {  double e = 2.718281828;
       x = Math.pow(x,2);
       e = Math.pow(e,-x);
       //x = 1 / e;
       x = e;
       return x;
     }

    public static void main(String args[])
     { 
       int i,j,k,n;
       double a,b,h,sum ;
       Scanner inputs = new Scanner( System.in ); 
    
       System.out.println("Numri i intervale - n: ");
       n = inputs.nextInt();
       System.out.println("Kufiri i poshtem b i integralit : ");
       a = inputs.nextInt();
       System.out.println("Kufiri i eperm a i integralit  : ");
       b = inputs.nextInt();
       
       
       double[][] r = new double[n][n];

       h = b - a;
       r[0][0] = (h/2) * (f(a) + f(b));
    
      for (i=1;i<=n-1;i++)
      { h = h/2;
        sum = 0;

        for (k=1;k<=(Math.pow(2,i) - 1);k++)
         {  sum = sum + f(a + k*h);
         
         }

        r[i][0] = 0.5 * r[i-1][0] + sum * h;
        System.out.println("r["+i+"][0] = " +r[i][0]);
        for (j=1;j<=i;j++)
        { r[i][j] = r[i][j-1] + (r[i][j-1] - r[i-1][j-1])/(Math.pow(4,j)-1);
          System.out.println("r["+i+"]["+j+"] = " +r[i][j]);
        }
       }
     }
}