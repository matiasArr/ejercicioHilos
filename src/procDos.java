public class procDos implements Runnable{
    double otraMitad;
    double resultado;
    double nFactorial;
    Thread hiloDos;

    public procDos(double otraMitad, double nFactorial){
        this.otraMitad = otraMitad;
        this.nFactorial = nFactorial;
        hiloDos = new Thread(this);
        hiloDos.start();
    }
    public void run(){
       resultado = fact(otraMitad , nFactorial);
    }
    public double fact(double otraMitad, double nFactorial){
        double res = 1.0;
        for (double i = otraMitad; i <= nFactorial ; i++) {
            res *= i; // -> res = res * i            }
        }
         return res; 
        
    }
    public double get(){
        try {
            hiloDos.join();
            return resultado;
        } catch (InterruptedException e) {
            return 0;
        }
    }


}