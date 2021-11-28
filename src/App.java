import java.util.Scanner;
import javax.sound.sampled.SourceDataLine;
import java.math.*;

public class App {
    /*
      NOTAS PARA LA PROXIMA VUELTA

     - ESTA LA OPCION DE ELIMINAR LOS METODOS FACT QUE SE ENCUENTRAN EN LOS HILOS 
     - SE CREO EL METODO CON LOS HILOS(FALTA EL CASO: NUMERO NO ES PAR) 

    */

    public static void main(String[] args) throws Exception {
        double numero = 160.0;
        Long val = new Long(1000L);
        
        double start = System.currentTimeMillis();
        BigInteger respuesta = recursiva(val);
        double end = System.currentTimeMillis();
        System.out.println("Factorial( "+numero +" ) = "+respuesta.toString());
        System.out.println("Y los milisegundos son: "+ (end-start));
    }
    public static BigInteger iterativa(Long nu){
        BigInteger res = BigInteger.valueOf(1L);
        for (Long i = 1L; i <= nu ; i++) {
            res = res.multiply(BigInteger.valueOf(i));  // res = res * i
        }
        return res;
    }
    public static BigInteger recursiva(Long num){
        if (num == 1L) {
            return BigInteger.valueOf(num);
        } else {
            return BigInteger.valueOf(num).multiply(recursiva(num - 1L));
        }
    }
    //METODO CON HILOS
    public static BigInteger factorialHilos(Long num){
        Long mitad = num/2;

        proc hiloUno = new proc(mitad);
        procDos hiloDos = new procDos(mitad + 1L,num);

        return hiloUno.get().multiply(hiloDos.get());
    }
}

