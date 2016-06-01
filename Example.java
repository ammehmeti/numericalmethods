package EkstrapolimiRichardsonit;


public class Example
{
   public static void main(String[] args)
   {
      NumericalDifferentiation d = new NumericalDifferentiation();
   
      Function func = 
         new Function()
         {
            public double eval(double x)
            {
             //  Function 3x^3
               return 5*x*Math.pow(Math.E, -2*x)   ;//3* x * x * x;
            }
         };
   
      double h = 0.25;
   
      d.setH(h);
   
   // Pergjigjja duke perdorur vetem Diferencialin Qendror
      System.out.println("Derivati qendror = " + d.centralDividedDifference(func, 0.35, h));
   
   // Pergjigjja me Ekstrapolimin e Richardsonit
      System.out.println("Ekstrapolimi i Richardsonit = " + d.richardsonExtrapolation(func, 0.35));
   
   // Pergjigjja e Sakte
      System.out.println("Pergjigjja e Sakte = " + 0.7449);
   }
}

