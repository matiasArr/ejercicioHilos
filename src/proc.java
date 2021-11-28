import java.math.BigInteger;

public class proc implements Runnable{
    //declaracion de variables
    Long mitad;
    BigInteger resultado;
    Thread hiloUno;
    //contructor
    public proc(Long mitad){
        this.mitad = mitad;
        hiloUno = new Thread(this);
        hiloUno.start();
    }
    public void run(){
        resultado = fact(mitad);
    }
    public BigInteger fact(Long mitad){
        BigInteger res = BigInteger.valueOf(1L);
        for (Long i = 1L; i <= mitad ; i++) {
            res = res.multiply(BigInteger.valueOf(i));  
        }
        return res;
    }
    public BigInteger get(){
        try {
            hiloUno.join();
            return resultado;
        } catch (InterruptedException e) {
            return BigInteger.valueOf(0L);
        }
    }
}
