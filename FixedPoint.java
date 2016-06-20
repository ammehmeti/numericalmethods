import java.util.Scanner;
public class FixedPoint {
	public static void main (String []args) {
		Scanner s = new Scanner(System.in);
		double p , p0 , tol ;
		int i = 1 ;
		int n0;

        System.out.println("Sheno p0: ");
        p0 = s.nextDouble();

        System.out.println("Toleranca: ");
        tol = s.nextDouble();

        System.out.println("Iteracionet: ");
        n0 = s.nextInt();
        
        while (i<=n0){
            p = g(p0);
            if(Math.abs(p-p0) < tol)
                break;

        System.out.printf("Iteracioni %d: Vlera %f\n", i, p);
        	i++;
            p0 = p;

            if(i>n0)
                System.out.printf("Metoda deshtoi pas %d iteracioneve \n", n0);
        }
	}
	 public static double g(double x){
	        return Math.pow(3*x*x+3, .25);
	    }
	  public static double f(double x){
	        return (Math.pow(x, 4) - 3*Math.pow(x, 2) -3) ; 
	    }
	
}
