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
        //Scanner sc = new Scanner(System.in);
        double numero = 160.0;
        double respuesta;
        double start = System.currentTimeMillis();
        respuesta = factorialHilos(numero);
        double end = System.currentTimeMillis();
        System.out.println("Fact( "+numero +" ) = "+respuesta);
        System.out.println("Y los milisegundos son: "+ (end-start));

        
        /*double start = System.currentTimeMillis();
        long num = 1000000L;
        long res = (num);
        System.out.println(String.valueOf(res));  
        double end = System.currentTimeMillis();

        System.out.println("Y los milisegundos son: "+ (end-start));*/
    }
    public static double iterativa(double nu){
        double res = 1.0;
        for (double i = 1.0; i <= nu ; i++) {
            res *= i;
        }
        return res;
    }
    public static double recursiva(double num){
        if (num == 1) {
            return num;
        } else {
            return num * recursiva(num - 1);
        }
    }
    //METODO CON HILOS
    public static double factorialHilos(double num){
        // se debe aplicar el patron futuro
        double mitad = num/2;
        proc hiloUno = new proc(mitad);
        procDos hiloDos = new procDos(mitad + 1.0,num);

        return (hiloUno.get() * hiloDos.get());

       /* hiloUno.start();
        hiloDos.start();
        hiloUno.join();
        hiloDos.join();

        double resu1 = hiloUno.fact(mitad);
        double resu2 = hiloDos.fact(mitad, num);
        double resultadoFi = resu1 * resu2;
        */
        //return resultadoFi;
        //System.out.println("El factorial de "+num +" es: "+resultadoFi);
    }
}

