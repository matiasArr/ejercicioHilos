public class procDos extends Thread{
    double otraMitad;
    double resultado;
    double nFactorial;

    public procDos(double otraMitad, double nFactorial){
        this.otraMitad = otraMitad;
        this.nFactorial = nFactorial;
    }

    public void run(){
       resultado = fact(otraMitad , nFactorial);
    }
    public double fact(double otraMitad, double nFactorial){
        double res = 1.0;
        for (double i = otraMitad; i <= nFactorial ; i++) {
            res *= i; // -> res = res * i
        }
        return res; 
    }


}
