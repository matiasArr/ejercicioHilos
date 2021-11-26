public class proc implements Runnable{
    double mitad;
    double resultado;
    Thread hiloUno;
    //contructor
    public proc(double mitad){
        this.mitad = mitad;
        hiloUno = new Thread(this);
        hiloUno.start();
    }
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
    public double get(){
        try {
            hiloUno.join();
            return resultado;
        } catch (InterruptedException e) {
            return 0;
        }
    }
}
