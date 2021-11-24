public class proc extends Thread{
    double mitad;
    double resultado;

    //contructor
    public proc(double mitad){
        this.mitad = mitad;
    }

    @Override
    public void run(){
        resultado = fact(mitad);
    }
    public double fact(double mitad){
        double res = 1.0;
        for (double i = 1; i <= mitad ; i++) {
            res *= i;
        }
        return res; 
    }
}
