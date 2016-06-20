
public class SOR {

	private static double tol = 1E-7; //toleranca
	private static int maxIt = 2; //Numri maksimal i iteracioneve
	
		
	public static double[] sor(double[][] a, double[] xo, 
							   double[] b, double w) {
		
		int n = a.length;
		double[] x = new double[n];
		int k = 1;
		while(k <= maxIt ) {
			for(int i = 0; i < n; i++) {
				x[i] = (1 - w) * xo[i] + (w * (- shuma(i, a, x, xo) + b[i]))/a[i][i];
			}
			if(infinit(x, xo) < tol) {
				System.out.println("Toleranca u arrit pas " + --k + " iteracioneve");
				return xo;
			}
			k++;
			for(int i = 0; i < n; i++) {
				xo[i] = x[i];
			}
		}
		System.out.println("Numri maksimal i iteracioneve eshte tejkaluar");
		return xo;
	}
	
	public static double shuma(int rreshti, double[][] a, double[] x, double[] xo) {
		double shuma = 0;
		for(int j = 0; j < a.length; j++) {
			if(rreshti == j)
				continue;
			else if (rreshti < j) {
				shuma += a[rreshti][j] * xo[j];
			}
			else {
				shuma += a[rreshti][j] * x[j];
			}
		}
		return shuma;
	}
	
	public static double infinit(double[] x, double[] xo) {
	      double max = Math.abs(x[0] - xo[0]);
	      for(int i = 1; i < x.length; i++) {
	         if(Math.abs(x[i] - xo[i]) > max)
	            max = Math.abs(x[i]);
	      }
	      return max;
	   }
	   
public static void main(String[] args) {
		double[][] a = {{3, -1, 1},
						{3, 6, 2},
						{3, 3, 7}};
		double[] b = {1, 0, 4};
		double[] xo = {0, 0, 0};
		double w = 1.1;
		double[] rezFinal = sor(a, xo, b, w);
		for(int i = 0; i < rezFinal.length; i++) {
			System.out.println("x[" + i + "] = " + rezFinal[i]);
		}
	}

}
