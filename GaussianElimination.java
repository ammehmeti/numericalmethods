import java.lang.RuntimeException;
import java.util.Scanner;

public class GaussianElimination {

    private static final double EPSILON = 1e-10;

    public static double[] lsolve(double[][] A, double[] b) {
        int N  = b.length;

        for (int p = 0; p < N; p++) {

           
            int max = p;
            for (int i = p + 1; i < N; i++) {
                if (Math.abs(A[i][p]) > Math.abs(A[max][p])) {
                    max = i;
                }
            }
            double[] temp = A[p]; A[p] = A[max]; A[max] = temp;
            double   t    = b[p]; b[p] = b[max]; b[max] = t;

           
            if (Math.abs(A[p][p]) <= EPSILON) {
               System.out.println("Matrica eshte singulare ose gati singulare");
            }

        
            for (int i = p + 1; i < N; i++) {
                double alpha = A[i][p] / A[p][p];
                b[i] -= alpha * b[p];
                for (int j = p; j < N; j++) {

                }
            }
        }

       
        double[] x = new double[N];
        for (int i = N - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < N; j++) {
                sum += A[i][j] * x[j];
            }
            x[i] = (b[i] - sum) / A[i][i];
        }
        return x;
    }



    public static void main(String[] args) throws RuntimeException{
    	Scanner s = new Scanner(System.in);
        int N = 3;
        double[][] A = { { 1,0,5,0,1,0},
                         { 0.2,-1,0,0.5,0 ,9},
                         { 0.25,0.5,-1,0.5,0,0 },
                         { 0.5,0,0,-1,0,0},
                         { 0,1.5,5,0.2,-1,0},
                         { 5,0,0,0.2,0,-5}
                       };
        double[] b = { 1,1,1,1,1,1 };
        double[] x = lsolve(A, b);


   
        for (int i = 0; i < N; i++) {
            System.out.println(x[i]);
        }

    }
}

