
public class Matrica {

    private double[][] matrica;
    private int gjersia;
    private int gjatesia;

    public static Matrica identityMatrica(int dim){
        double[][] m = new double[dim][dim];
        for (int i = 0; i < m.length; i++){
            for (int j = 0; j < m.length; j++){
                if (i == j) m[i][j] = 1;
                else m[i][j] = 0;
            }
        }
        return new Matrica(m);
    }

    public Matrica(double x, double y){
        this(new double[][]{{x},{y}});
    }

    public double getX(){
        return matrica[0][0];
    }

    public double getY(){
        return matrica[1][0];
    }

    public Matrica(double[][] matrica){
        this.gjersia = matrica[0].length;
        this.gjatesia = matrica.length;
        this.matrica = matrica;
    }

    public int getGjersia(){
        return gjersia;
    }

    public int getGjatesia(){
        return gjatesia;
    }

    public double[][] getMatrica(){
        return matrica;
    }

    public Matrica multiply(Matrica mat){
        double[][] n = null;
        if (getGjersia() == mat.getGjatesia()){
            n = new double[getGjatesia()][mat.getgjersia()];

            double[][] a = this.matrica;
            double[][] b = mat.getMatrica();

            for (int y = 0; y < n.length; y++){
                for (int x = 0; x < n[y].length; x++){
                    double sum = 0;
                    for (int i = 0; i < gjersia && i < mat.getGjatesia(); i++){
                        sum += a[y][i] * b[i][x];
                    }
                    n[y][x] = sum;
                }
            }
        } else {
            System.out.println("dimension error");
        }
        return new Matrica(n);
    }

    public static void printMatix(Matrica m){
        if (m.getMatrica() == null) {
            System.out.println("NULL Matrica");
            return;
        }
        double[][] ind = m.getMatrica();
        for (int y = 0; y < m.getGjatesia(); y++){
            System.out.print("|");
            for(int x = 0; x < m.getGjersia(); x++){
                System.out.print(ind[y][x]);
                if (x != m.getGjersia() - 1) System.out.print(",");
                if (x == m.getGjatesia() - 1) System.out.println("|");
            }

        }
        System.out.println(m.getGjatesia() + "x" + m.getGjersia());
    }

    public static void main(String[] args){
        double[][] m1 = new double[][]{
                {5, 6},
                {1, 8}
        };
        double[][] m2 = new double[][]{
                {1, 0},
                {0, 1}
        };
        Matrica mat1 = new Matrica(m1);
        Matrica mat2 = new Matrica(m2);
        printMatix(mat1.multiply(mat2));

    }
}
