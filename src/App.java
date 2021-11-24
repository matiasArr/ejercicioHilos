import java.util.Scanner;
import javax.sound.sampled.SourceDataLine;
import java.math.*;

public class App {
    /*
      NOTAS PARA LA PROXIMA VUELTA

     - HAY UN PROBLEMA CON EL METODO RECURSIVO(ALGO CON LA STACK) SOLUCION: -XSS
     - EL METODO ITERATIVO LANZA UN ERROR CON EL TIPO LONG
     - SE CREO EL METODO CON LOS HILOS(FALTA EL CASO: NUMERO NO ES PAR) 
     
    */
    public static void main(String[] args) throws Exception {
        //Scanner sc = new Scanner(System.in);
        double numero = 10;
        double respuesta;
        double start = System.currentTimeMillis();
        respuesta = factorialHilos(numero);
        double end = System.currentTimeMillis();
        System.out.println("Fact( "+numero +" ) = "+respuesta);
        System.out.println("Y los milisegundos son: "+ (end-start));

        /*
        double start = System.currentTimeMillis();
        long num = 1000000L;
        long res = (num);
        System.out.println(String.valueOf(res));  
        double end = System.currentTimeMillis();

        System.out.println("Y los milisegundos son: "+ (end-start));
    }
    public static long iterativa(long nu){
        long res = 1L;
        for (long i = 1L; i <= nu ; i++) {
            res *= i;
        }
        return res;
    }
    //NO SE PUEDE JUGAR CON LOS BIG EN UN METODO RECURSIVO3
    public static long recursiva(long num){
        if (num == 1) {
            return num;
        } else {
            return num * recursiva(num - 1);
        }
        // Creo un Big de uno para realizar las siguientes operaciones: 
        //COMPARACION Y RESTA 
       /* String uno = "1";
        //BigInteger  bigUno = new BigInteger(uno);
        if(num.equals(bigUno)){
            return BigInteger.valueOf(1);
        }else{
            BigInteger resta = num.subtract(bigUno);
            BigInteger multi = num.multiply(resta);
            return multi;
            //return num * recursiva(resta));//num -1
        }*/

    }
    //METODO CON HILOS
    public static double  factorialHilos(double num) throws InterruptedException{
        double mitad = num/2;

        proc hiloUno = new proc(mitad);
        procDos hiloDos = new procDos(mitad + 1.0,num);

        hiloUno.start();
        hiloDos.start();
        hiloUno.join();
        hiloDos.join();
        double resu1 = hiloUno.resultado;
        double resu2 = hiloDos.resultado;
        double resultadoFi = resu1 * resu2;
        
        return resultadoFi;
        //System.out.println("El factorial de "+num +" es: "+resultadoFi);
    }
}

