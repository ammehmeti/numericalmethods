package EkstrapolimiRichardsonit;

public class Ekstrapolimi {

public static double f(double x)

{

	double f = Math.sin(x);

	return f;

}


// Derivati i funksionit
private static void Derivative(double x, int n, double h, double[][] D)

{

	int i;
	int j;

	for (i = 0; i < n; i++)

	{

		D[i][0] = (f(x + h) - f(x - h)) / (2 * h);



		for (j = 0; j <= (i - 1); j++)

		{

			D[i][j + 1] = D[i][j] + (D[i][j] - D[i - 1][j]) / (Math.pow(4.0,(double)(j + 1)) - 1);

		}

		h = h / 2;

	}

}

public static void main(String[] args)

{

	double[][] D = new double[10][10];

	int n = 10;
	int digits = 5;

	double h = 1;
	double x = 0;



	Derivative(x, n, h, D);

	
	// Printimi i diagramit

	for (int i = 0; i < n; i++)

	{

		for (int j = 0;j < i + 1;j++)

		{

			System.out.println( D[i][j]);
			
		}

		System.out.println("%f"+ "\n");

	}




}
}
