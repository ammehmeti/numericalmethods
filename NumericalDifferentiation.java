package EkstrapolimiRichardsonit;


public class NumericalDifferentiation
{
 // Vlera qe e prezanton intervali i cili eshte duke u perdorur ne llogaritje
 
   private double h;

 // Krijimi i Objektit,  jep vleren fillestare te h
   public NumericalDifferentiation()
   {
      h = 0.0001;
   }

 // Krijimi i Objektit, ku perdorusi  jep vleren fillestare te h
   public NumericalDifferentiation(double h)
   {
      this.h = h;
   }

 
   public double getH()
   {
      return h;
   }


   public void setH(double h)
   {
      this.h = h;
   }
 //Llogaritja e derivatit te pare te Funksionit  f ne piken x
 // me intervalin h , duke perdorur skemen e diferencialit qendror
 
   public double centralDividedDifference(Function f, double x, double h)
   {
      return (f.eval(x + h) - f.eval(x - h)) / (2 * h);
   }

 // Llogaritja e derivatit te pare te Funksionit  f ne piken x
 // Duke e perdorur Ekstrapolimin e Richardsonin edhe skemen e diferencialit qendror
 
   public double richardsonExtrapolation(Function f, double x)
   {   
     // Derivati ne piken x me intervalin h
	
      double d1 = centralDividedDifference(f, x, this.h);
   
   // Derivati ne piken x me intervalin h
      double d2 = centralDividedDifference(f, x, this.h / 2);
   
   // Perdorimi i Ekstrapolimit te Richardsonit per me marr rezultatin final te funksionit
  
      double res = d2 + ((d2 - d1) / 3);
   
      return res;
   }
}

//EXAMPLE USAGE

