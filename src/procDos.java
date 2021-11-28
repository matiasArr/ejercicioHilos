import java.math.BigInteger;

public class procDos implements Runnable{
    //declaracion de variables
    long otraMitad;
    BigInteger resultado;
    long nFactorial;
    Thread hiloDos;
    
    //contructor
    public procDos(long otraMitad, Long nFactorial){
        this.otraMitad = otraMitad;
        this.nFactorial = nFactorial;
        hiloDos = new Thread(this);
        hiloDos.start();
    }
    public void run(){
       resultado = fact(otraMitad , nFactorial);
    }
    public BigInteger fact(long otraMitad, long nFactorial){
        BigInteger res = BigInteger.valueOf(1L);
        for (long i = otraMitad; i <= nFactorial ; i++) {
            res = res.multiply(BigInteger.valueOf(i));  
        }
        return res;
    }
    public BigInteger get(){
        try {
            hiloDos.join();
            return resultado;
        } catch (InterruptedException e) {
            return BigInteger.valueOf(0L);
        }
    }
}