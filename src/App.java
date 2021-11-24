import java.util.Scanner;
import javax.sound.sampled.SourceDataLine;
import java.math.*;

public class App {
    /*
      NOTAS PARA LA PROXIMA VUELTA

     - HAY UN PROBLEMA CON EL METODO RECURSIVO(ALGO CON LA STACK) SOLUCION: -XSS
     - EL METODO ITERATIVO LANZA UN ERROR CON EL TIPO LONG
     - FALTA AGREGAR EL APARTADO DEL HILOS(SE CREAN DOS HILOS)
     
    */
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        double resultado;

        double start = System.currentTimeMillis();
        long numero = 100L;
        long res = iterativa(numero);
        System.out.println(String.valueOf(res));  
        double end = System.currentTimeMillis();

        System.out.println("Y los milisegundos son: "+ (end-start));

        /*
        JUGANDO CON HILOS
        proc hiloUno = new proc();
        procDos hiloDos = new procDos();
        hiloDos.start();
        //hiloUno.start();
        //hiloUno.interrupt();
        hiloDos.interrupt();
        System.out.println("dame un numero");
        double  n =  sc.nextDouble();
        */
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

    /*
    
    METODO QUE SE APLICARA PARA LOS HILOS

    public static int factorial(int num){
        
        
        //double res = iterativa((int)num);
        

        //double resu = recursiva((int )num);

        ouble n = num/2;
        double resu;
        proc hiloUno = new proc(n);
        hiloUno.start();
        resu = hiloUno.getNum();
        hiloUno.interrupt();
        return resu;
    }*/
}
